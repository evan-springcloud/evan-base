package org.evan.springcloud.base.config.datasource.first;


import org.apache.ibatis.session.SqlSessionFactory;
import org.evan.springcloud.base.config.datasource.MybatisIniter;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;

/**
 * Created on 2017/7/16.
 *
 * @author evan.shen
 */
@Configuration
//@EnableTransactionManagement
@EnableConfigurationProperties({DataSource1Properties.class})
@MapperScan(basePackages = {  //mybatis mapper 所在package
        "org.evan.springcloud.base.repository.mapper.first",
}, sqlSessionTemplateRef = "sqlSessionTemplateNo1")

public class DataSource1AutoConfiguration {
    private static final String TYPE_ALIASES_PACKAGE = "org.evan.springcloud.base.demo.**.model";

//    @Autowired
//    @Qualifier("dataSourceNo1")
//    private DruidDataSource dataSource;

    @Bean(name = "dataSourceNo1", initMethod = "init")
    public DataSource1 dataSourceNo1() {
        DataSource1 datasource = new DataSource1();
        return datasource;
    }

    @Bean(name = "jdbcTemplateNo1")
    public JdbcTemplate jdbcTemplateNo1(@Qualifier("dataSourceNo1") DataSource1 dataSource) {
        JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
        return jdbcTemplate;
    }

    @Bean("sqlSessionFactoryNo1")
    public SqlSessionFactory sqlSessionFactory(@Qualifier("dataSourceNo1") DataSource1 dataSource) {
        return MybatisIniter.getSqlSessionFactory(dataSource, TYPE_ALIASES_PACKAGE, "classpath*:mapper/first/*Mapper.xml");
    }


    @Bean("sqlSessionTemplateNo1")
    public SqlSessionTemplate sqlSessionTemplate(@Qualifier("sqlSessionFactoryNo1") SqlSessionFactory sqlSessionFactory) {
        return new SqlSessionTemplate(sqlSessionFactory);
    }

    @Bean(name = "dataSourceTransactionManager1")
    public PlatformTransactionManager dataSourceTransactionManager(@Qualifier("dataSourceNo1") DataSource1 dataSource) {
        return new DataSourceTransactionManager(dataSource);
    }

//    @Bean("annotationDrivenTransactionManagerNo1")
//    @Override
//    public PlatformTransactionManager annotationDrivenTransactionManager() {
//        return new DataSourceTransactionManager(dataSource);
//    }
}
