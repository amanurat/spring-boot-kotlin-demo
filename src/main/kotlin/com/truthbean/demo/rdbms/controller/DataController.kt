package com.truthbean.demo.rdbms.controller

import com.truthbean.demo.rdbms.query.persistence.domain.QueryDemoUser
import com.truthbean.demo.rdbms.query.service.QueryDemoUserService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.data.domain.Page
import org.springframework.web.bind.annotation.*

/**
 * Created by TruthBean on 2016/3/16 0016.
 */
@RestController
class DataController @Autowired constructor(val userService: QueryDemoUserService) {

    val allMySQLDemoUsersForList: List<QueryDemoUser>
        @RequestMapping("/demo/user/mysql/all")
        get() = userService!!.all

    @RequestMapping(value = "/demo/user/mysql/page", method = arrayOf(RequestMethod.POST))
    fun getSomeMySQLDemoUsersForListByPage(@RequestParam(name = "size", defaultValue = "20") size: Int,
                                           @RequestParam(name = "current", defaultValue = "1") current: Int): Page<QueryDemoUser> {
        return userService!!.getAllByPage(current, size)
    }

    @RequestMapping(value = "/demo/user/mysql/{current}", method = arrayOf(RequestMethod.POST))
    fun getSomeMySQLDemoUsersForPages(@PathVariable current: Int,
                                      @RequestParam(name = "size", defaultValue = "20") size: Int): Page<QueryDemoUser> {
        return userService!!.getAllByPage(current, size)
    }
}