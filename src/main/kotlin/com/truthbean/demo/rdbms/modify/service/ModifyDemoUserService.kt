package com.truthbean.demo.rdbms.modify.service

import com.truthbean.demo.mix.core.util.isEmpty
import com.truthbean.demo.mix.core.util.isNotEmpty
import com.truthbean.demo.rdbms.modify.persistence.domain.ModifyDemoUser
import com.truthbean.demo.rdbms.modify.persistence.repository.ModifyDemoUserRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.cache.annotation.CacheEvict
import org.springframework.cache.annotation.CachePut
import org.springframework.security.crypto.password.StandardPasswordEncoder
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

/**
 * Created by TruthBean on 2016/3/16 0016.
 */
@Service
@Transactional(rollbackFor = arrayOf(RuntimeException::class))
open class ModifyDemoUserService {

    @Autowired
    lateinit var userRepository: ModifyDemoUserRepository

    private val passwordEncoder = StandardPasswordEncoder()

    @CachePut(cacheNames = arrayOf("user"), key = "#demoUser.userUUID")
    open fun save(demoUser: ModifyDemoUser): ModifyDemoUser? {
        var demoUser = demoUser
        if (isEmpty(demoUser.userUUID)) {
            demoUser.userPassword = passwordEncoder.encode(demoUser.userPassword)
            demoUser = userRepository!!.save(demoUser)
            return demoUser
        }
        return null
    }

    @CachePut(cacheNames = arrayOf("user"), key = "#demoUser.userUUID")
    open fun update(demoUser: ModifyDemoUser): ModifyDemoUser? {
        var demoUser = demoUser
        if (isNotEmpty(demoUser.userUUID)) {
            demoUser.userUUID = null
            demoUser.userPassword = passwordEncoder.encode(demoUser.userPassword)
            demoUser = userRepository!!.save(demoUser)
            return demoUser
        }
        return null
    }

    //@CacheEvict(cacheNames="user", allEntries=true)
    @CacheEvict(cacheNames = arrayOf("user"), key = "#uuid")
    open fun delete(uuid: String): Boolean {
        userRepository!!.delete(uuid)
        val tmp = userRepository.findOne(uuid)
        return tmp == null
    }

}