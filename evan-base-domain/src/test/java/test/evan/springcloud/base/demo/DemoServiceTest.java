package test.evan.springcloud.base.demo;


import org.evan.libraries.exception.DataNotFindException;
import org.evan.springcloud.base.demo.DemoApplicationService;
import org.evan.springcloud.base.demo.model.Demo;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import test.evan.springcloud.base.support.ApplicationTestCaseSupport;
import test.evan.springcloud.base.testdata.TestData;

public class DemoServiceTest extends ApplicationTestCaseSupport {

    @Autowired
    private DemoApplicationService demoService;

    @Test
    @Rollback(false)
    public void testAdd() {
        Demo demo = TestData.random();
        demoService.add(demo);
    }

    @Test
    @Rollback(false)
    public void testUpdate() throws DataNotFindException {
        Demo demo = TestData.random();
        demo.setId(101L);
        demoService.update(demo);
    }
}
