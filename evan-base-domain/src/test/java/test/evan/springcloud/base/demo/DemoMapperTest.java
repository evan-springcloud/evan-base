package test.evan.springcloud.base.demo;


import org.evan.libraries.model.result.PageResult;
import org.evan.springcloud.base.repository.mapper.first.DemoMapper;
import org.evan.springcloud.base.model.demo.Demo;
import org.evan.springcloud.base.model.demo.DemoQueryDTO;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import test.evan.springcloud.base.support.MySQLTestCaseSupport;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

public class DemoMapperTest extends MySQLTestCaseSupport {

    @Autowired
    private DemoMapper demoMapper;

    @Test
    public void testLoad() {
        Demo demo = demoMapper.selectById(1L);
        LOGGER.info(">>>> test load:" + demo + "");
    }

    @Test
    @Rollback(false)
    public void testInsert() {
        Demo demo = DemoTestData.randomDemo();
        demoMapper.insert(demo);
        LOGGER.info(">>>> test testInsert: id[{}]", demo.getId());

        demo = DemoTestData.randomDemo();
        //demo.setFieldCity("12345677889");
        demoMapper.insert(demo);
        LOGGER.info(">>>> test testInsert:" + demo);
    }

    @Test
    @Rollback(false)
    public void testUpdate() {
        Demo demo = new Demo(4823L);
        demo.setFieldText("BBB");
        demo.setFieldDatetime(new Date());
        demo.setFieldNumber(new BigDecimal("22121212.312121212"));
        demo.setFieldHtmleditor("aaa");

        demoMapper.updateById(demo);

        LOGGER.info(">>>> test testUpdate:" + demo);
    }

    @Test
    @Rollback(false)
    public void testUpdateStatus() {
        demoMapper.updateStatus(4823L, 2);
    }

    @Test
    public void testDelete() {
        demoMapper.deleteById(4823L);
    }

    @Test
    public void testQueryForList() {
        DemoQueryDTO demoQuery = new DemoQueryDTO();
//        demoQuery.setGmtCreateFrom(DateUtils.parse("2011-01-01"));
//        demoQuery.setGmtCreateTo(DateUtils.parse("2013-12-31"));
//        demoQuery.setStatusEnumArray(PublishStatusEnum.NO_PUBLISH, PublishStatusEnum.PUBLISHED);
//        demoQuery.setSort(DemoColumns.ID.getColumn());
//        demoQuery.setColumns(DemoColumns.ID.getColumn(),//
//                DemoColumns.FIELD_REGION.getColumn(),//
//                DemoColumns.GMT_CREATE.getColumn(),//
//                DemoColumns.GMT_MODIFY.getColumn()//
//        );
//        demoQuery.setJoinDemoChild1(true);
        List<Demo> demos = demoMapper.queryList(demoQuery);

        LOGGER.info(">>>> testQueryForList:" + demos.size());
    }

    @Test
    public void testQueryForCount() {
        DemoQueryDTO demoQuery = new DemoQueryDTO();

        demoQuery.setFieldText("1");
        //demoQuery.setPageSize(5);

        List<Demo> demos = demoMapper.queryList(demoQuery);

        LOGGER.info(">>>> testQueryForCount:" + demos.size());
    }

    @Test
    public void testQueryForPage() {
        DemoQueryDTO demoQuery = new DemoQueryDTO();

        //demoQuery.setFieldText("1");
//        demoQuery.setPageNo(2);
//        demoQuery.setPageSize(4);
//        demoQuery.setJoinDemoChild1(true);


        PageResult<Demo> demos = demoMapper.queryPage(demoQuery);
        //PageResult<Demo> pageResult = PageResult.create(demoQuery, demos, count);

        //log.info(pageResult.toString());
    }
}
