package test.evan.springcloud.base.demo;

import lombok.extern.slf4j.Slf4j;
import org.evan.libraries.model.result.PageResult;
import org.evan.libraries.utils.DateUtil;
import org.evan.libraries.utils.RandomDataUtil;
import org.evan.springcloud.base.service.demo.DemoReadService;
import org.evan.springcloud.base.service.demo.model.DemoQueryDTO;
import org.evan.springcloud.base.service.demo.model.DemoVO;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import test.evan.springcloud.base.support.ApplicationTestCaseSupport;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Evan.Shen
 * @since 2019-09-21
 */
@Slf4j
public class DemoReadServiceTest extends ApplicationTestCaseSupport {

    @Autowired
    private DemoReadService demoReadService;


    @Test
    public void testQuery() {
        DemoQueryDTO demoQuery = new DemoQueryDTO();
        demoQuery.setGmtCreateFrom(DateUtil.parse("2018-01-01"));
        demoQuery.setGmtCreateTo(DateUtil.parse("2019-12-31"));
//        demoQuery.setStatusEnumArray(PublishStatusEnum.NO_PUBLISH, PublishStatusEnum.PUBLISHED);
//        demoQuery.setSort(DemoColumns.ID.getColumn());
//        demoQuery.setColumns(DemoColumns.ID.getColumn(),//
//                DemoColumns.FIELD_REGION.getColumn(),//
//                DemoColumns.GMT_CREATE.getColumn(),//
//                DemoColumns.GMT_MODIFY.getColumn()//
//        );
//        demoQuery.setJoinDemoChild1(true);
        PageResult demos = demoReadService.query(demoQuery);

        log.info(">>>> testQuery:" + demos.getRecordCount());
    }


    @Test
    public void testGetById() {
        long id = RandomDataUtil.randomLong(100);
        DemoVO demoVO = demoReadService.getById(id);
        log.info(">>>> testGetById:" + demoVO);
    }

    @Test
    public void testGetByIds() {
        List<Long> demoIds = new ArrayList<>();
        int count = RandomDataUtil.randomInt(10);

        for (int i = 0; i < count; i++) {
            demoIds.add(RandomDataUtil.randomLong(10 * (i + 1)));
        }

        List<DemoVO> demoVOs = demoReadService.getByIds(demoIds.toArray(new Long[]{}));

        log.info(">>>> testGetByIds:" + demoVOs);
    }

    @Test
    public void testNotExists() {
        long id = RandomDataUtil.randomLong(100);
        boolean notExists = demoReadService.notExists(id, "Txt");
        log.info(">>>> testNotExists:" + notExists);
    }
}