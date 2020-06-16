package org.evan.springcloud.base.config;


import org.evan.springcloud.core.oauth.AbstractRestBeansAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.socket.server.standard.ServerEndpointExporter;

import java.util.Collection;

/**
 * @author Evan.Shen
 * @since 2019-09-30
 */
@Configuration
public class DemoRestBeansAutoConfiguration extends AbstractRestBeansAutoConfiguration {
    public void putInterceptorExcludes(Collection<String> excludes) {
//        excludes.add("/**/login");
//        excludes.add("/**/login/**");
        excludes.add("/**/account/**");
        excludes.add("/**/upload/image");
        excludes.add("/**/validate-code/image/**");
        excludes.add("/pay/wap/alipay/notify");
        excludes.add("/pay/wap/wxpay/notify");
    }

    @Bean
    public ServerEndpointExporter serverEndpointExporter() {
        return new ServerEndpointExporter();
    }
}
