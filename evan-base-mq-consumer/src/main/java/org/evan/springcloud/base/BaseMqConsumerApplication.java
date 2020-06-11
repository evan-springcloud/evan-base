package org.evan.springcloud.base;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * @author shenwei
 */
@SpringBootApplication
@EnableTransactionManagement
@ComponentScan(basePackages = {
        "org.evan.springcloud.core.config",
        "org.evan.springcloud.core.components",
        "org.evan.springcloud.core.oauth",
        "org.evan.springcloud.base",
})
@EnableSwagger2
@EnableScheduling
@EnableDiscoveryClient
public class BaseMqConsumerApplication {
    public static void main(String[] args) {
        SpringApplication.run(BaseMqConsumerApplication.class, args);
    }
}
