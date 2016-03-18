package com.truthbean.demo.service

import com.truthbean.demo.SpringBootKotlinApplication
import com.truthbean.demo.mongodb.model.MongoDemoUser
import com.truthbean.demo.mongodb.service.MongoDemoUserService
import org.junit.After
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.SpringApplicationConfiguration
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner
import java.math.BigInteger

/**
 * Created by TruthBean on 2016/3/18 0018.
 */

@RunWith(SpringJUnit4ClassRunner::class)
@SpringApplicationConfiguration(classes = arrayOf(SpringBootKotlinApplication::class))
class MongoDemoUserServiceTest {

    @Autowired
    private val demoUserService: MongoDemoUserService? = null

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
        val username = "黑客帝国2号机器人"
        val realname = "卡尔·大白"
        val email = "byer@doby.net"
        val password = "doby098656"
        val phone = "+81000030345"

        val demoUser = MongoDemoUser()
        demoUser.userPassword = password
        demoUser.userEmail = email
        demoUser.userName = username
        demoUser.userPhone = phone
        demoUser.userRealName = realname

        val result = demoUserService!!.save(demoUser)

        System.out.println(result)
    }

    @Test
    @Throws(Exception::class)
    fun testUpdate() {

    }

    @Test
    @Throws(Exception::class)
    fun testDelete() {
        val inputId = "26875008962597706027681232555".toByteArray()
        val id = BigInteger(inputId)
        System.out.println(demoUserService!!.delete(id))
    }

    @Test
    @Throws(Exception::class)
    fun testGetById() {
        val inputId = "26875033072492093148397883872".toByteArray()
        val id = BigInteger(inputId)
        System.out.println(demoUserService!!.getById(id))
    }

    @Test
    @Throws(Exception::class)
    fun testGetAll() {
        System.out.println(demoUserService!!.all)
    }
}