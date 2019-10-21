package org.evan.springcloud.base.config.datasource.second;

import org.apache.ibatis.session.SqlSessionFactory;
import org.evan.springcloud.base.config.datasource.MybatisIniter;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;

/**
 * Created on 2017/7/16.
 *
 * @author evan.shen
 */
@Configuration
//@EnableTransactionManagement
@EnableConfigurationProperties({DataSource2Properties.class})
@MapperScan(basePackages = {
        "com.shumai.tianyandata.merchant.repository.mapper.second",
}, sqlSessionTemplateRef = "sqlSessionTemplateNo2")
public class DataSource2AutoConfiguration {
    private static final String TYPE_ALIASES_PACKAGE = "com.shumai.tianyandata.merchant.**.model";

    @Bean(name = "dataSourceNo2", initMethod = "init")
    public DataSource2 dataSourceNo2() {
        DataSource2 datasource = new DataSource2();
        return datasource;
    }
//
//    @Autowired
//    @Qualifier("dataSourceNo2")
//    private DruidDataSource dataSource;

    @Bean(name = "jdbcTemplateNo2")
    public JdbcTemplate jdbcTemplateNo2(@Qualifier("dataSourceNo2") DataSource2 dataSource) {
        JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
        return jdbcTemplate;
    }

    @Bean("sqlSessionFactoryNo2")
    public SqlSessionFactory sqlSessionFactory(@Qualifier("dataSourceNo2") DataSource2 dataSource) {
        return MybatisIniter.getSqlSessionFactory(dataSource, TYPE_ALIASES_PACKAGE, "classpath*:mapper/second/*Mapper.xml");
    }

    @Bean("sqlSessionTemplateNo2")
    public SqlSessionTemplate sqlSessionTemplate(@Qualifier("sqlSessionFactoryNo2") SqlSessionFactory sqlSessionFactory) {
        return new SqlSessionTemplate(sqlSessionFactory);
    }

//    @Bean(name = "dataSourceTransactionManager2")
////    public PlatformTransactionManager dataSourceTransactionManager(@Qualifier("dataSourceNo2") DataSource2 dataSource) {
////        return new DataSourceTransactionManager(dataSource);
////    }
}
