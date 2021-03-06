package test.evan.springcloud.base.support;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;


/**
 * @author Evan.Shen
 * @since 2019-09-20
 */
@EnableAutoConfiguration
@ComponentScan(basePackages = {
        "org.evan.springcloud"
})
public class ApplicationTestBeansConfig {
}
