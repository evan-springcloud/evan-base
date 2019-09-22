package test.org.evan.springcloud.base.support;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;

/**
 * Created on 2017/7/16.
 *
 * @author evan.shen
 */
@EnableAutoConfiguration
@ComponentScan(basePackages = {
        "org.evan.springcloud.**.config.mysql"
        , "org.evan.springcloud.base.repository.jdbc"})
public class MySQLTestBeansConfig {

}
