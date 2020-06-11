package org.evan.springcloud.base;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * @author shenwei
 */
@SpringBootApplication
@EnableTransactionManagement
@EnableSwagger2
//@EnableDiscoveryClient
@ComponentScan(basePackages = {
        "org.evan.springcloud.core.config",
        "org.evan.springcloud.core.components",
        "org.evan.springcloud.core.oauth",
        "org.evan.springcloud.base",
})
public class BaseRestApplication {
    public static void main(String[] args) {
        SpringApplication.run(BaseRestApplication.class, args);
    }
}
