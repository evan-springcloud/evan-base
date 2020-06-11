package test.org.evan.springcloud.base.support;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;

@EnableAutoConfiguration
@ComponentScan(basePackages = {
        "org.evan.springcloud.core.config",
        "org.evan.springcloud.core.oauth",
        "org.evan.springcloud.base"
})
public class WebTestBeansConfig {

}

