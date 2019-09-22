package org.evan.springcloud.base.demo;

import lombok.extern.slf4j.Slf4j;
import org.evan.libraries.model.result.PageResult;
import org.evan.springcloud.base.demo.model.DemoModel;
import org.evan.springcloud.base.demo.model.DemoQuery;
import org.evan.springcloud.base.demo.model.DemoRepresentation;
import org.evan.springcloud.base.demo.repository.DemoJdbc;
import org.evan.springcloud.base.demo.repository.DemoMapper;
import org.evan.springcloud.base.utils.BeanUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Evan.Shen
 * @since 2019-09-21
 */

@Slf4j
@Service
public class DemoRepresentationService {

    @Autowired
    private DemoJdbc demoDao;

    @Autowired
    private DemoMapper demoMapper;

    public PageResult<DemoRepresentation> query(DemoQuery demoQuery) {
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

        PageResult<DemoRepresentation> pageResult = new PageResult<>(demoQuery);

        if (demoQuery.getPageSize() == 0) {
            demoQuery.setPageSize(DemoQuery.DEFAULT_PAGE_SIZE);
        }

        //demoQuery.setIncludeDeleted(true);

        int recordCount = demoMapper.queryCount(demoQuery);
        pageResult.setRecordCount(recordCount);

//        // 清除排序表达式
//        if (isNeedConvertSortCodeToSortExpression) {
//            demoQuery.setSort(null);
//        }

        if (recordCount > 0) {
            List<DemoModel> demos = demoMapper.queryList(demoQuery);
            List<DemoRepresentation> demoRepresentations = convertRepresentation(demos);

            pageResult.setData(demoRepresentations);
        }

        return pageResult;
    }

    private List<DemoRepresentation> convertRepresentation(List<DemoModel> demos) {
        int recordCountOnCurrentPage = demos.size();
        List<DemoRepresentation> demoRepresentations = new ArrayList<>(recordCountOnCurrentPage);

        // 将列表中每条数据中的值属性转换成用于显示文本
        // 循环的时候缓存结果，遇到相同的数据，从缓存中取出，缓存new的时候就分配大小，尽量不要出现扩容的情况
        Map<String, String> dataDictCache = new HashMap<>(recordCountOnCurrentPage);
        Map<String, String> regionCache = new HashMap<>(recordCountOnCurrentPage * 2);
        for (DemoModel o : demos) {
            DemoRepresentation demoRepresentation = new DemoRepresentation();

            BeanUtil.quickCopy(o, demoRepresentation);
            convertValueToText(demoRepresentation, dataDictCache, regionCache);

            demoRepresentations.add(demoRepresentation);
        }

        return demoRepresentations;
    }

    public DemoRepresentation getById(long id) {
        DemoModel demo = demoMapper.load(id);// 取demo
        DemoRepresentation demoRepresentation = new DemoRepresentation();

        if (demo != null) {
            BeanUtil.quickCopy(demo, demoRepresentation);
            convertValueToText(demoRepresentation, null, null);
        }
        return demoRepresentation;
    }

    /**
     * 根据多个id获取实体类
     *
     * @param demoIds
     * @return <p/>
     * author: <a href="mailto:shenw@hundsun.com">shenw</a><br>
     * create at: 2014年4月16日上午2:03:44
     */
    public List<DemoRepresentation> getByIds(Long[] demoIds) {
        DemoQuery demoQuery = new DemoQuery();
        demoQuery.setIdArray(demoIds);
//        demoQuery.setColumns(DemoColumns.ID.getColumn(), DemoColumns.FIELD_TEXT.getColumn(),
//                DemoColumns.STATUS.getColumn());
        demoQuery.setSortByDefault(false);
        demoQuery.setIncludeDeleted(true);

        List<DemoModel> demos = demoMapper.queryList(demoQuery);
        List<DemoRepresentation> demoRepresentations = convertRepresentation(demos);
        return demoRepresentations;
    }


    public boolean notExists(Long id, String fieldText) {
        return demoDao.notExists(id, fieldText);
    }

    private void convertValueToText(DemoRepresentation demoRepresentation, Map<String, String> dataDictCache, Map<String, String> regionCache) {
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
