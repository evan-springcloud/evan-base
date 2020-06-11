package test.evan.springcloud.base.support;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;

/**
 * @author evan.shen
 * @since 2017/7/16
 */
@EnableAutoConfiguration
@ComponentScan(basePackages = {
        //"org.evanframework.datadict"
        //"org.evanframework.datadict.service"
        "org.evan.springcloud.core.components.cache",
        "org.evan.springcloud.base"
})
public class CacheTestBeansConfig {

}
