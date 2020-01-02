package test.evan.springcloud.base.support;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;

/**
 * Created on 2017/7/16.
 *
 * @author evan.shen
 */
@EnableAutoConfiguration
@ComponentScan(basePackages = {
        "org.evan.springcloud.**.config.datasource"
        , "org.evan.springcloud.base.**.jdbc"})
public class MySQLTestBeansConfig {

}
