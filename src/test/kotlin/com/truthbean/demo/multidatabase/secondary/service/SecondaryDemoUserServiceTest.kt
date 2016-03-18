package com.truthbean.demo.multidatabase.secondary.service

import com.truthbean.demo.SpringBootKotlinApplication
import com.truthbean.demo.rdbms.query.service.QueryDemoUserService
import org.junit.After
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.SpringApplicationConfiguration
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner

/**
 * Created by TruthBean on 2016/3/18 0018.
 */
@RunWith(SpringJUnit4ClassRunner::class)
@SpringApplicationConfiguration(classes = arrayOf(SpringBootKotlinApplication::class))
class SecondaryDemoUserServiceTest {

    @Autowired
    private val userService: QueryDemoUserService? = null

    @Before
    @Throws(Exception::class)
    fun setUp() {

    }

    @After
    @Throws(Exception::class)
    fun tearDown() {

    }

    @Test
    @Throws(Exception::class)
    fun testGetById() {

    }

    @Test
    @Throws(Exception::class)
    fun testGetAllByPage() {

    }

    @Test
    @Throws(Exception::class)
    fun testGetAll() {
        val begin = System.currentTimeMillis()
        for (i in 0..2047) {
            userService!!.all
        }
        val end = System.currentTimeMillis()
        println(end - begin)
    }
}