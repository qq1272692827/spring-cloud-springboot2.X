package com.zztl.testapi.datasource;

import com.alibaba.druid.pool.DruidDataSource;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;

import javax.sql.DataSource;
import java.sql.SQLException;

/**
 * @author wenzhenyu
 * @description 数据源
 * @date 2018/12/29
 */
@Configuration
// 扫描 Mapper 接口并容器管理
@MapperScan(basePackages = UserDatasourseConfig.PACKAGE, sqlSessionFactoryRef = "userSqlSessionFactory")
public class UserDatasourseConfig  {



    // 精确到 master 目录，以便跟其他数据源隔离
    static final String PACKAGE = "com.zztl.testapi.dao.zzkj_user";
    static final String MAPPER_LOCATION = "classpath:mapper/zzkj_user/*.xml";

    @Value("${user.datasource.url}")
    private String jdbcUrl;

    @Value("${user.datasource.username}")
    private String username;

    @Value("${user.datasource.password}")
    private String password;

    @Value("${user.datasource.driverClassName}")
    private String driverClass;

//    @Primary
    @Bean(name = "userDataSource")
    public DataSource getMysqlDataSource() throws SQLException {
        DruidDataSource dataSource = new DruidDataSource();
        dataSource.setDriverClassName(driverClass);
        dataSource.setUrl(jdbcUrl);
        dataSource.setUsername(username);
        dataSource.setPassword(password);
        return dataSource;

    }


    @Bean(name = "userSqlSessionFactory")
    public SqlSessionFactory sqlSessionFactoryBean(@Qualifier("userDataSource") DataSource userDataSource)
            throws Exception {
        final SqlSessionFactoryBean sqlSessionFactoryBean = new SqlSessionFactoryBean();
        sqlSessionFactoryBean.setDataSource(userDataSource);
        PathMatchingResourcePatternResolver resolver = new PathMatchingResourcePatternResolver();
        sqlSessionFactoryBean.setMapperLocations(resolver.getResources(MAPPER_LOCATION));
        return sqlSessionFactoryBean.getObject();

    }

}
