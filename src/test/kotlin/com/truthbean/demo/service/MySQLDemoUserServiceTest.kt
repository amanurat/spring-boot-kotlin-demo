package com.truthbean.demo.service

import com.truthbean.demo.SpringBootKotlinApplication
import com.truthbean.demo.rdbms.modify.persistence.domain.ModifyDemoUser
import com.truthbean.demo.rdbms.modify.service.ModifyDemoUserService
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
class MySQLDemoUserServiceTest {

    @Autowired
    private val queryService: QueryDemoUserService? = null

    @Autowired
    private val modifyService: ModifyDemoUserService? = null

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
    fun testSave() {
        val username = "卡尔法狗666"
        val realname = "阿尔法·谷鸽...."
        val email = "go66@doby.net"
        val password = "doby660982222"
        val phone = "+8100006662"

        val demoUser = ModifyDemoUser()
        demoUser.userPassword = password
        demoUser.userEmail = email
        demoUser.userName = username
        demoUser.userPhone = phone
        demoUser.userRealName = realname

        val result = modifyService!!.save(demoUser)

        System.out.println(result)
    }

    @Test
    @Throws(Exception::class)
    fun testUpdate() {

    }

    @Test
    @Throws(Exception::class)
    fun testDelete() {

    }

    @Test
    @Throws(Exception::class)
    fun testGetById() {

    }

    @Test
    @Throws(Exception::class)
    fun testGetAll() {
        System.out.println(queryService?.all)
    }
}