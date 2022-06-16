package com.app.core;

import com.zaxxer.hikari.HikariDataSource;
import org.springframework.boot.autoconfigure.flyway.FlywayDataSource;
import org.springframework.context.annotation.Bean;
import org.testcontainers.containers.MySQLContainer;
import org.testcontainers.containers.wait.strategy.Wait;

import javax.sql.DataSource;


/**
 * @program: Code_Style
 * @description: 该类可以使用docker中的数据库，暂未使用到
 * @author: quliang
 * @create: 2022-06-16 15:00
 **/
public class DatabaseTestConfiguration {

    @Bean(initMethod = "start",destroyMethod = "stop")
    public MySQLContainer<?> mySQLContainer(){
        return new MySQLContainer<>("mysql:5.7-oracle")
                .waitingFor(Wait.forListeningPort());
    }

    @Bean
    @FlywayDataSource
    public DataSource dataSource(MySQLContainer<?> mySQLContainer){
        HikariDataSource hikariDataSource = new HikariDataSource();
        hikariDataSource.setJdbcUrl(mySQLContainer.getJdbcUrl());
        hikariDataSource.setUsername(mySQLContainer.getUsername());
        hikariDataSource.setPassword(mySQLContainer.getPassword());
        return new HikariDataSource(hikariDataSource);
    }
}
