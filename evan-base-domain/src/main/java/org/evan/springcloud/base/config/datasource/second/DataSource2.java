package org.evan.springcloud.base.config.datasource.second;



import org.evan.springcloud.core.components.datasource.AbstractDataSourceProperties;
import org.evan.springcloud.core.components.datasource.AbstractDruidDataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * @author Evan.Shen
 * @since 2019-10-02
 */
@ConfigurationProperties("spring.datasource2.druid")
public class DataSource2 extends AbstractDruidDataSource {
    @Autowired
    private DataSource2Properties dataSourceProperties;

    @Override
    public AbstractDataSourceProperties getBasicProperties() {
        return dataSourceProperties;
    }
}