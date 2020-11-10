package test.org.evan.springcloud.base.support;

import lombok.extern.slf4j.Slf4j;

import org.evan.springcloud.core.components.restclient.TokenClientHttpRequestInterceptor;
import org.evan.springcloud.core.oauth.LoginAccountWebSession;
import org.evan.springcloud.core.oauth.LoginUser;
import org.junit.Before;
import org.junit.runner.RunWith;
import org.libraries.oauth.model.LoginAccountSetter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.client.ClientHttpRequestInterceptor;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.ArrayList;
import java.util.List;


@RunWith(SpringRunner.class)
@SpringBootTest(classes = {
        WebTestBeansConfig.class,
}, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@Slf4j
public class WebTestCaseSupport implements WebMvcConfigurer {
    protected RestTemplate restTemplate;

    @Autowired
    private TokenClientHttpRequestInterceptor tokenClientHttpRequestInterceptor;

    @Autowired
    private LoginAccountWebSession loginUserSession;

    @Value("${local.server.port}")
    private int port;

    @Before
    public void init() {
        LoginUser LoginUser = new LoginUser();
        LoginUser.setId(-1L);
        LoginUser.setRemoteAddr("127.0.0.1");
        //LoginUser.setRemoteAddr("127.2.3.1");
        LoginUser.setName("张三");
        LoginUser.setAccount("15600002222");

//        Set<String> permissions = new HashSet<>();
//        permissions.add(FunctionId.CONTRACT_CONFIRM);
//        LoginUser.setPermissions(permissions);

        loginUserSession.save(LoginUser);
        LoginAccountSetter.put(LoginUser);
//
        restTemplate = new RestTemplate();
        List<ClientHttpRequestInterceptor> interceptors = new ArrayList<>();
        interceptors.add(tokenClientHttpRequestInterceptor);
        restTemplate.setInterceptors(interceptors);

        log.info("Rest Test Init,loginUser is [{}]", LoginUser);
    }

    protected String getApiUri() {
        return "http://127.0.0.1:" + port;
    }

    protected String getFullApiUri(String subUrl) {
        return "http://127.0.0.1:" + port + subUrl;
    }

}
