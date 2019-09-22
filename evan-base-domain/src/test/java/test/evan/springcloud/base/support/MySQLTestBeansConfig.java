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
        "org.evan.springcloud.core.config.mysql"
        , "org.evan.springcloud.base.*.repository"})
public class MySQLTestBeansConfig {

}
