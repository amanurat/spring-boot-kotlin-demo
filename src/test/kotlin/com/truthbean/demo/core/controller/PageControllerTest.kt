package com.truthbean.demo.core.controller

import com.truthbean.demo.SpringBootKotlinApplication
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.beans.factory.annotation.Value
import org.springframework.boot.test.SpringApplicationConfiguration
import org.springframework.boot.test.TestRestTemplate
import org.springframework.boot.test.WebIntegrationTest
import org.springframework.http.MediaType
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.setup.MockMvcBuilders
import org.springframework.web.context.WebApplicationContext

import org.junit.Assert.*
import org.hamcrest.Matchers.containsString
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*
import org.springframework.test.web.servlet.result.MockMvcResultMatchers.*

/**
 * Created by TruthBean on 2016/3/18 0018.
 */
@RunWith(SpringJUnit4ClassRunner::class)
@SpringApplicationConfiguration(classes = arrayOf(SpringBootKotlinApplication::class))
@WebIntegrationTest("server.port:0")
class PageControllerTest {

    @Autowired
    private val context: WebApplicationContext? = null

    @Value("\${local.server.port}")
    private val port: Int = 0

    private var mockMvc: MockMvc? = null
    private val restTemplate = TestRestTemplate()

    @Before
    fun setupMockMvc() {
        mockMvc = MockMvcBuilders.webAppContextSetup(context).build()
    }

    @Test
    @Throws(Exception::class)
    fun testError() {

        mockMvc!!.perform(get("/publishers/1").accept(MediaType.APPLICATION_JSON_UTF8)).andExpect(status().isNotFound())
        .andExpect(content().string(containsString("中文测试")))
        .andExpect(jsonPath("$.name").value("中文测试"));

    }
}