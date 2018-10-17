package com.zlikun.jee;

import com.zaxxer.hikari.HikariDataSource;
import org.apache.ibatis.mapping.Environment;
import org.apache.ibatis.session.Configuration;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.apache.ibatis.transaction.jdbc.JdbcTransactionFactory;

import javax.sql.DataSource;

/**
 * @author zlikun
 * @date 2018-10-17 14:46
 */
public abstract class TestBase {

    private String jdbcUrl = "jdbc:mysql://mysql.dev.zlikun.com:3306/db_zlikun";
    private String username = "root";
    private String password = "123456";

    /**
     * 数据源
     *
     * @return
     */
    private DataSource dataSource() {
        HikariDataSource dataSource = new HikariDataSource();
        dataSource.setJdbcUrl(jdbcUrl);
        dataSource.setUsername(username);
        dataSource.setPassword(password);
        return dataSource;
    }

    /**
     * 使用Java配置SqlSessionFactory
     *
     * @return
     */
    private SqlSessionFactory sqlSessionFactory() {
        Configuration config = new Configuration();
        config.setEnvironment(new Environment("zlikun-mybatis-example", new JdbcTransactionFactory(), dataSource()));
        config.setMapUnderscoreToCamelCase(true);
        return new SqlSessionFactoryBuilder().build(config);
    }

    /**
     * 使用Xml配置SqlSessionFactory
     *
     * @return
     */
    private SqlSessionFactory sqlSessionFactoryXml() {

        return null;
    }

}
