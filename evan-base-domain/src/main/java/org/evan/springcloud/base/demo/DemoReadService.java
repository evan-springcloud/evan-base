package org.evan.springcloud.base.demo;

import lombok.extern.slf4j.Slf4j;
import org.evan.libraries.model.result.PageResult;
import org.evan.libraries.utils.BeanUtil;
import org.evan.springcloud.base.demo.model.Demo;
import org.evan.springcloud.base.demo.model.DemoQueryDTO;
import org.evan.springcloud.base.demo.model.DemoVO;
import org.evan.springcloud.base.repository.jdbc.DemoJdbc;
import org.evan.springcloud.base.repository.mapper.first.DemoMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 读取Service
 *
 * @author Evan.Shen
 * @since 2019-09-21
 */

@Slf4j
@Service
public class DemoReadService {

    @Autowired
    private DemoJdbc demoDao;

    @Autowired
    private DemoMapper demoMapper;

    public PageResult<DemoVO> query(DemoQueryDTO demoQuery) {
        Assert.notNull(demoQuery, "Not find query param [DemoQuery]");

        // 如果排序编号(见DemoQuery.SortCode)不为空，而排序表达式为空，则需要将排序代码转换成排序表达式
//        boolean isNeedConvertSortCodeToSortExpression = StringUtils.isBlank(demoQuery.getSort())
//                && StringUtils.isNotBlank(demoQuery.getSortCode());

//        if (isNeedConvertSortCodeToSortExpression) {// 转换排序编号成排序表达式
//            DemoQuery.SortCode sortCode = null;
//            try {
//                sortCode = DemoQuery.SortCode.valueOf(demoQuery.getSortCode());
//                demoQuery.setSort(sortCode.getSortExpression());
//            } catch (IllegalArgumentException e) {
//                LOGGER.warn("The sort code [" + demoQuery.getSortCode() + "] of  demo query is wrong");
//            }
//        }

        PageResult<DemoVO> pageResult = new PageResult<>(demoQuery);

        if (demoQuery.getPageSize() == 0) {
            demoQuery.setPageSize(DemoQueryDTO.DEFAULT_PAGE_SIZE);
        }

        //demoQuery.setIncludeDeleted(true);

        int recordCount = demoMapper.queryCount(demoQuery);
        pageResult.setRecordCount(recordCount);

//        // 清除排序表达式
//        if (isNeedConvertSortCodeToSortExpression) {
//            demoQuery.setSort(null);
//        }

        if (recordCount > 0) {
            List<Demo> demos = demoMapper.queryList(demoQuery);
            List<DemoVO> demoVOs = convertRepresentation(demos);

            pageResult.setData(demoVOs);
        }

        return pageResult;
    }

    private List<DemoVO> convertRepresentation(List<Demo> demos) {
        int recordCountOnCurrentPage = demos.size();
        List<DemoVO> demoVOs = new ArrayList<>(recordCountOnCurrentPage);

        // 将列表中每条数据中的值属性转换成用于显示文本
        // 循环的时候缓存结果，遇到相同的数据，从缓存中取出，缓存new的时候就分配大小，尽量不要出现扩容的情况
        Map<String, String> dataDictCache = new HashMap<>(recordCountOnCurrentPage);
        Map<String, String> regionCache = new HashMap<>(recordCountOnCurrentPage * 2);
        for (Demo o : demos) {
            DemoVO demoVO = new DemoVO();

            BeanUtil.quickCopy(o, demoVO);
            convertValueToText(demoVO, dataDictCache, regionCache);

            demoVOs.add(demoVO);
        }

        return demoVOs;
    }

    public DemoVO getById(long id) {
        Demo demo = demoMapper.selectById(id);// 取demo
        DemoVO demoVO = null;

        if (demo != null) {
            demoVO = new DemoVO();
            BeanUtil.quickCopy(demo, demoVO);
            convertValueToText(demoVO, null, null);
        }
        return demoVO;
    }

    /**
     * 根据多个id获取实体类
     *
     * @param demoIds
     * @return <p/>
     * author: <a href="mailto:shenw@hundsun.com">shenw</a><br>
     * create at: 2014年4月16日上午2:03:44
     */
    public List<DemoVO> getByIds(Long[] demoIds) {
        DemoQueryDTO demoQuery = new DemoQueryDTO();
        demoQuery.setIdArray(demoIds);
//        demoQuery.setColumns(DemoColumns.ID.getColumn(), DemoColumns.FIELD_TEXT.getColumn(),
//                DemoColumns.STATUS.getColumn());
        demoQuery.setSortByDefault(false);
        demoQuery.setIncludeDeleted(true);

        List<Demo> demos = demoMapper.queryList(demoQuery);
        List<DemoVO> demoVOs = convertRepresentation(demos);
        return demoVOs;
    }


    public boolean notExists(Long id, String fieldText) {
        return demoDao.notExists(id, fieldText);
    }

    private void convertValueToText(DemoVO demoVO, Map<String, String> dataDictCache, Map<String, String> regionCache) {
//        // 转化地区
//        demo.setFieldProvinceName(regionService.getNameByCode(demo.getFieldProvince(), regionCache));
//        demo.setFieldCityName(regionService.getNameByCode(demo.getFieldCity(), regionCache));
//        demo.setFieldRegionName(regionService.getNameByCode(demo.getFieldRegion(), regionCache));
//
//        // 根据数据字典表将值转换成文本
//        String fieldSelectText = dataDictionaryService.getForString("education", demo.getFieldSelect(), dataDictCache);
//        demo.setFieldSelectText(fieldSelectText);
    }
}
