package com.example.Julien3DBack.config;

import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

import javax.sql.DataSource;

@Configuration
@EnableJpaAuditing()
class DataSourceConfiguration {

    @Bean
    public DataSource getDataSource() {
        DataSourceBuilder dataSourceBuilder = DataSourceBuilder.create();
        dataSourceBuilder.username(System.getenv("julien3d_db_user"));
        dataSourceBuilder.password(System.getenv("julien3d_db_password"));
        dataSourceBuilder.url(System.getenv("julien3d_db_url"));

        return dataSourceBuilder.build();
    }
}