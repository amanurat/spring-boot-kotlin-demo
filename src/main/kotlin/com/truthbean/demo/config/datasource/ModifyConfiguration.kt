package com.truthbean.demo.config.datasource

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.beans.factory.annotation.Qualifier
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.context.annotation.Primary
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
@EnableJpaRepositories(entityManagerFactoryRef = "modifyEntityManagerFactory", transactionManagerRef = "modifyTransactionManager", basePackages = arrayOf("com.truthbean.demo.MySQL.persistence.repository.modify")) //设置dao（repo）所在位置
class ModifyConfiguration {

    @Autowired
    @Qualifier("modifyDataSource")
    private val modifyDataSource: DataSource? = null

    @Bean
    @Primary
    fun modifyEntityManager(builder: EntityManagerFactoryBuilder): EntityManager {
        return modifyEntityManagerFactory(builder).`object`.createEntityManager()
    }

    @Bean
    @Primary
    fun modifyEntityManagerFactory(
            builder: EntityManagerFactoryBuilder): LocalContainerEntityManagerFactoryBean {
        return builder.dataSource(modifyDataSource).packages("com.truthbean.demo.MySQL.persistence.domain.modify").persistenceUnit("modify").build()
    }

    @Bean
    @Primary
    internal fun modifyTransactionManager(builder: EntityManagerFactoryBuilder): PlatformTransactionManager {
        return JpaTransactionManager(modifyEntityManagerFactory(builder).`object`)
    }

}