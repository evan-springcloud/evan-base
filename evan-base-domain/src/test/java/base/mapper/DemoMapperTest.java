package base.mapper;


import base.support.MySQLTestCaseSupport;
import base.testdata.TestData;
import org.evan.springcloud.base.demo.model.Demo;
import org.evan.springcloud.base.demo.repository.DemoMapper;
import org.evan.springcloud.base.query.DemoQuery;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

public class DemoMapperTest extends MySQLTestCaseSupport {
    @Autowired
    private DemoMapper demoMapper;

    @Test
    public void testLoad() {
        Demo demo = demoMapper.load(1L);
        LOGGER.info(">>>> test load:" + demo + "");
    }

    @Test
    @Rollback(false)
    public void testInsert() {
        Demo demo = TestData.random();
        demoMapper.insert(demo);
        LOGGER.info(">>>> test testInsert: id[{}]",demo.getId());

        demo = TestData.random();
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

        demoMapper.update(demo);

        LOGGER.info(">>>> test testUpdate:" + demo);
    }

    @Test
    @Rollback(false)
    public void testUpdateStatus() {
        demoMapper.updateStatus(4823L, 2);
    }

    @Test
    public void testDelete() {
        demoMapper.delete(4823L);
    }

    @Test
    public void testQueryForList()  {
        DemoQuery demoQuery = new DemoQuery();
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
        DemoQuery demoQuery = new DemoQuery();

        demoQuery.setFieldText("1");
        //demoQuery.setPageSize(5);

        List<Demo> demos = demoMapper.queryList(demoQuery);

        LOGGER.info(">>>> testQueryForCount:" + demos.size());
    }

    @Test
    public void testQueryForPage() {
        DemoQuery demoQuery = new DemoQuery();

        //demoQuery.setFieldText("1");
//        demoQuery.setPageNo(2);
//        demoQuery.setPageSize(4);
//        demoQuery.setJoinDemoChild1(true);

        int count = demoMapper.queryCount(demoQuery);
        List<Demo> demos = demoMapper.queryList(demoQuery);
        //PageResult<Demo> pageResult = PageResult.create(demoQuery, demos, count);

        //log.info(pageResult.toString());
    }
}
