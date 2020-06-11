package org.evan.springcloud.base.config.datasource.first;


import org.evan.springcloud.core.components.datasource.AbstractDataSourceProperties;
import org.evan.springcloud.core.components.datasource.AbstractDruidDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Primary;

/**
 * @author Evan.Shen
 * @since 2019-10-02
 */
@Primary
@ConfigurationProperties("spring.datasource1.druid")
public class DataSource1 extends AbstractDruidDataSource {

    @Autowired
    private DataSource1Properties dataSourceProperties;

    @Override
    public AbstractDataSourceProperties getBasicProperties() {
        return dataSourceProperties;
    }
}
