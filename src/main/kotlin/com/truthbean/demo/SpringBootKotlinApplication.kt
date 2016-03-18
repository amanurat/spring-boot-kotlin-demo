package com.truthbean.demo

import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.cache.annotation.EnableCaching
import org.springframework.transaction.annotation.EnableTransactionManagement

@SpringBootApplication
@EnableTransactionManagement
@EnableCaching
open class SpringBootKotlinApplication

fun main(args: Array<String>) {
    SpringApplication.run(SpringBootKotlinApplication::class.java, *args)
}
