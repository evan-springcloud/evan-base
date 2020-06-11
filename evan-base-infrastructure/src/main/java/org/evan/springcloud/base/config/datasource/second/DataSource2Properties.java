package org.evan.springcloud.base.config.datasource.second;

import org.evan.springcloud.core.components.datasource.AbstractDataSourceProperties;
import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * @author Evan.Shen
 * @since 2019-10-02
 */
@ConfigurationProperties(
        prefix = "spring.datasource2"
)
public class DataSource2Properties extends AbstractDataSourceProperties {
}
