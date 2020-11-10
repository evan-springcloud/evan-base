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
        excludes.add("/**/login");
        excludes.add("/**/upload/image");
        excludes.add("/**/validate-code/image/**");
    }

    /**
     * 设置鉴权拦截器免登陆接口地址
     *
     * @param notRequiredLoginPaths
     */
    protected void putNotRequiredLoginPaths(Collection<String> notRequiredLoginPaths) {
        notRequiredLoginPaths.add("/**/demo/**");
    }

    @Bean
    public ServerEndpointExporter serverEndpointExporter() {
        return new ServerEndpointExporter();
    }
}
