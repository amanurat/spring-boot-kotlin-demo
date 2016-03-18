package com.truthbean.demo.MySQL.controller.rest

import com.truthbean.demo.SpringBootKotlinApplication
import org.junit.After
import org.junit.Before
import org.junit.Test
import org.junit.Assert.assertNotNull
import org.junit.runner.RunWith
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.beans.factory.annotation.Value
import org.springframework.boot.test.SpringApplicationConfiguration
import org.springframework.boot.test.TestRestTemplate
import org.springframework.boot.test.WebIntegrationTest
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.setup.MockMvcBuilders
import org.springframework.web.context.WebApplicationContext
import java.util.*

/**
 * Created by TruthBean on 2016/3/18 0018.
 */

@RunWith(SpringJUnit4ClassRunner::class)
@SpringApplicationConfiguration(classes = arrayOf(SpringBootKotlinApplication::class))
@WebIntegrationTest("server.port:0")
class DataControllerTest {

    @Autowired
    private val context: WebApplicationContext? = null

    @Value("\${local.server.port}")
    private val port: Int = 0

    private var mockMvc: MockMvc? = null
    private val restTemplate = TestRestTemplate()

    @Before
    @Throws(Exception::class)
    fun setUp() {
        mockMvc = MockMvcBuilders.webAppContextSetup(context).build()
    }

    @After
    @Throws(Exception::class)
    fun tearDown() {

    }

    @Test
    @Throws(Exception::class)
    fun testGetAllMySQLDemoUsersForList() {
        val users = restTemplate.getForObject("http://localhost:${port}/demo/user/mysql/all", ArrayList::class.java)
        assertNotNull(users)
        println(users)
        //QueryDemoUser user = users.get(0);
        //assertEquals("卡尔·逗比", user.getUserRealName());
    }

    @Test
    @Throws(Exception::class)
    fun testGetSomeMySQLDemoUsersForListByPage() {

    }

    @Test
    @Throws(Exception::class)
    fun testGetSomeMySQLDemoUsersForPages() {

    }
}