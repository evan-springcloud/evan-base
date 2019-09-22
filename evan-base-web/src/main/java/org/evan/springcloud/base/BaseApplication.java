package org.evan.springcloud.base;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

/**
 *
 *
 * @author shenwei
 */
@SpringBootApplication
@ComponentScan(basePackages = {
        "org.evan.springcloud.core.config",
        "org.evan.springcloud.core.oauth",
        "org.evan.springcloud.base",
})
public class BaseApplication {
    public static void main(String[] args) {
        SpringApplication.run(BaseApplication.class, args);
    }
}
