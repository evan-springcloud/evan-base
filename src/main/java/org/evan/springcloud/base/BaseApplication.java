package org.evan.springcloud.base;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

/**
 * 网关
 *
 * @author shenwei
 */
@SpringBootApplication
@ComponentScan(basePackages = {
        "org.evan.springcloud.base.api",
})
public class BaseApplication {
    public static void main(String[] args) {
        SpringApplication.run(BaseApplication.class, args);
    }
}
