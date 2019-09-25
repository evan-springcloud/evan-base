package test.evan.springcloud.base.support;

/**
 * @author Evan.Shen
 * @since 2019-09-20
 */

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.data.mongo.MongoDataAutoConfiguration;
import org.springframework.boot.autoconfigure.mongo.MongoAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;

@EnableAutoConfiguration
@ComponentScan(basePackages = {
        //"org.evanframework.datadict"
        //"org.evanframework.datadict.service"
        "org.evan.springcloud.core.config",
        "org.evan.springcloud.core.oauth",
        "org.evan.springcloud.base"
})
//@MapperScan(basePackages = {
//        "org.evan.springcloud.base.*.repository",
//}) //mybatis mapper 所在package
public class ApplicationTestBeansConfig {
}
