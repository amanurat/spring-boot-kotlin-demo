package com.truthbean.demo.rdbms.query.service

import com.truthbean.demo.rdbms.query.persistence.domain.QueryDemoUser
import com.truthbean.demo.rdbms.query.persistence.repository.QueryDemoUserRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.cache.annotation.CacheConfig
import org.springframework.cache.annotation.Cacheable
import org.springframework.data.domain.Page
import org.springframework.data.domain.PageRequest
import org.springframework.data.domain.Sort
import org.springframework.security.crypto.password.StandardPasswordEncoder
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

/**
 * Created by TruthBean on 2016/3/16 0016.
 */
@Transactional(readOnly = true)
@CacheConfig(cacheNames = arrayOf("users"))
@Service
open class QueryDemoUserService{

    @Autowired lateinit var queryRepository: QueryDemoUserRepository

    private val passwordEncoder = StandardPasswordEncoder()

    @Cacheable(key = "#uuid")
    open fun getById(uuid: String): QueryDemoUser? {
        return queryRepository?.findOne(uuid)
    }

    @Cacheable
    open fun getAllByPage(current: Int, size: Int): Page<QueryDemoUser>? {
        val sort = Sort(Sort.Direction.ASC, "demo_user_id") //按id升序排列
        val page = PageRequest(current, size, sort)
        return queryRepository?.findAll(page)
    }

    open val all: List<QueryDemoUser>?
        @Cacheable
        get() = queryRepository?.findAll()

}