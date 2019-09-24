package test.evan.springcloud.base.support;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;

/**
 * Created on 2017/9/20.
 *
 * @author evan.shen
 * @since
 */
@EnableAutoConfiguration
@ComponentScan(basePackages = {
        "org.evan.springcloud.core.config.cache",
        "org.evan.springcloud.base"
})
public class MongoDBTestBeansConfig {

}
