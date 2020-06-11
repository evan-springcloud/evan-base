package org.evan.springcloud.base.config.datasource.first;


import org.evan.springcloud.core.components.datasource.AbstractDataSourceProperties;
import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * @author Evan.Shen
 * @since 2019-10-02
 */
@ConfigurationProperties(
        prefix = "spring.datasource1"
)
public class DataSource1Properties extends AbstractDataSourceProperties {
}
