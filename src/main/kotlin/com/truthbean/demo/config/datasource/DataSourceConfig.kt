package com.truthbean.demo.config.datasource

import org.springframework.boot.autoconfigure.jdbc.DataSourceBuilder
import org.springframework.boot.context.properties.ConfigurationProperties
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.context.annotation.Primary
import javax.sql.DataSource

/**
 * Created by TruthBean on 2016/3/16 0016.
 */

@Configuration
open class DataSourceConfig {

    @Bean
    @Primary
    @ConfigurationProperties(prefix = "modify.datasource")
    open fun modifyDataSource(): DataSource {
        return DataSourceBuilder.create().build()
    }

    @Bean
    @ConfigurationProperties(prefix = "query.datasource")
    open fun queryDataSource(): DataSource {
        return DataSourceBuilder.create().build()
    }

}