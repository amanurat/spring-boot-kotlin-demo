package com.truthbean.demo.config.datasource

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.beans.factory.annotation.Qualifier
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.data.jpa.repository.config.EnableJpaRepositories
import org.springframework.orm.jpa.JpaTransactionManager
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean
import org.springframework.transaction.PlatformTransactionManager
import org.springframework.transaction.annotation.EnableTransactionManagement
import javax.persistence.EntityManager
import javax.sql.DataSource

/**
 * Created by TruthBean on 2016/3/16 0016.
 */

@Configuration
@EnableTransactionManagement
@EnableJpaRepositories(entityManagerFactoryRef = "queryEntityManagerFactory", transactionManagerRef = "queryTransactionManager", basePackages = arrayOf("com.truthbean.demo.rdbms.query.persistence.repository")) //设置dao（repo）所在位置
open class QueryConfiguration {

    @Autowired
    @Qualifier("queryDataSource")
    private val queryDataSource: DataSource? = null

    @Bean
    open fun queryEntityManager(builder: EntityManagerFactoryBuilder): EntityManager {
        return queryEntityManagerFactory(builder).`object`.createEntityManager()
    }

    @Bean
    open fun queryEntityManagerFactory(
            builder: EntityManagerFactoryBuilder): LocalContainerEntityManagerFactoryBean {
        return builder.dataSource(queryDataSource)
                .packages("com.truthbean.demo.rdbms.query.persistence.domain")
                .persistenceUnit("query").build()
    }

    @Bean
    open internal fun queryTransactionManager(builder: EntityManagerFactoryBuilder): PlatformTransactionManager {
        return JpaTransactionManager(queryEntityManagerFactory(builder).`object`)
    }

}