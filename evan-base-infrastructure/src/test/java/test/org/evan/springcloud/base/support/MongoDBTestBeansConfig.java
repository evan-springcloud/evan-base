package test.org.evan.springcloud.base.support;

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
        "org.evan.springcloud.**.config.mongodb"
})
public class MongoDBTestBeansConfig {

}
