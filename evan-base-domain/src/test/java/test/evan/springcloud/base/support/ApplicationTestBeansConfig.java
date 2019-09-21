package test.evan.springcloud.base.support;

/**
 * @author Evan.Shen
 * @since 2019-09-20
 */

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.data.mongo.MongoDataAutoConfiguration;
import org.springframework.boot.autoconfigure.mongo.MongoAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;

@EnableAutoConfiguration(exclude = {MongoAutoConfiguration.class, MongoDataAutoConfiguration.class})
@ComponentScan(basePackages = {
        //"org.evanframework.datadict"
        //"org.evanframework.datadict.service"
        "org.evan.springcloud.base"
})

public class ApplicationTestBeansConfig {
}
