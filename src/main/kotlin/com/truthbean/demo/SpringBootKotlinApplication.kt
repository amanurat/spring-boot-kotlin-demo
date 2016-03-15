package com.truthbean.demo

import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication

@SpringBootApplication
@EnableTransactionManagement
@EnableCaching
open class SpringBootKotlinApplication

fun main(args: Array<String>) {
    SpringApplication.run(SpringBootKotlinApplication::class.java, *args)
}
