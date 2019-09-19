package test.evan.springcloud.base.support;


import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;


@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = {
        ApplicationTestBeansConfig.class
}, webEnvironment = SpringBootTest.WebEnvironment.NONE)
public class ApplicationTestCaseSupport {
//    protected UserAgent userAgent = null;
//
//    @Before
//    public void init() {
//        userAgent = new UserAgent();
////        userAgent.setId(-5L);
//
//        userAgent.setId(1903L);
//        userAgent.setOrgName("测试新增");
//        userAgent.setId(1797L);
//        userAgent.setRemoteAddr("127.2.3.1");
//        userAgent.setUserName("测试指定车辆");
//        userAgent.setOrgId(1002);
//
//        userAgent.setAccount("测试指定车辆");
//
////        userAgent.setUserType(UserTypeEnum.SUPPLIER.getValue());
////        userAgent.setUserType(UserTypeEnum.CUSTOM.getValue());
//
//
////        userAgent.setUserType(UserTypeEnum.CUSTOM.getValue());
//        UserAgentContext.put(userAgent);
//    }
}
