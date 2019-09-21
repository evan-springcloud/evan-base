package test.org.evan.springcloud.base.support;

import com.github.dozermapper.core.DozerBeanMapper;
import com.github.dozermapper.core.DozerBeanMapperBuilder;
import com.github.dozermapper.core.Mapper;
import org.junit.Before;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * Created by evan.shen on 2017/3/16.
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = {
        WebTestBeansConfig.class,
}, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class WebTestCaseSupport implements WebMvcConfigurer {

    protected RestTemplate restTemplate;

    protected  Mapper dozerBeanMapper = DozerBeanMapperBuilder.buildDefault();

//    @Autowired
//    private TokenClientHttpRequestInterceptor tokenClientHttpRequestInterceptor;
//
//    @Autowired
//    private UserAgentSession userAgentSession;

    @Value("${local.server.port}")
    private int port;

    @Before
    public void init() {
//        UserAgent userAgent = new UserAgent();
//        userAgent.setId(-1L);
//        userAgent.setRemoteAddr("127.0.0.1");
//        //userAgent.setRemoteAddr("127.2.3.1");
//        userAgent.setUserName("测试管理员");
//        userAgent.setAccount("mizhi_admin");
//        userAgent.setOrgId(212);
//        userAgent.setUserType(UserTypeEnum.SUPPLIER.getValue());
//
//        Set<String> permissions = new HashSet<>();
//        permissions.add(FunctionId.CONTRACT_CONFIRM);
//        userAgent.setPermissions(permissions);
//
//        userAgentSession.save(userAgent);
//        UserAgentContext.put(userAgent);
//
        restTemplate = new RestTemplate();
//        List<ClientHttpRequestInterceptor> interceptors = new ArrayList<>();
////        interceptors.add(tokenClientHttpRequestInterceptor);
////        restTemplate.setInterceptors(interceptors);
    }

    protected String getApiUri() {
        return "http://127.0.0.1:" + port;
    }

    protected String getFullApiUri(String subUrl) {
        return "http://127.0.0.1:" + port + subUrl;
    }

}
