package com.truthbean.demo.mongodb.service

import com.truthbean.demo.mongodb.model.MongoDemoUser
import com.truthbean.demo.mongodb.repository.MongoDemoUserReponsitory
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.security.crypto.password.StandardPasswordEncoder
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import java.math.BigInteger

/**
 * Created by TruthBean on 2016/3/16 0016.
 */

@Service
@Transactional(readOnly = true)
class MongoDemoUserService {

    @Autowired
    private val demoUserRepository: MongoDemoUserReponsitory? = null

    private val passwordEncoder = StandardPasswordEncoder()

    @Transactional
    fun save(demoUser: MongoDemoUser): MongoDemoUser {
        var demoUser = demoUser
        demoUser.userPassword = passwordEncoder.encode(demoUser.userPassword)
        demoUser = demoUserRepository!!.save(demoUser)
        return demoUser
    }

    @Transactional
    fun update(demoUser: MongoDemoUser): MongoDemoUser {
        //demoUser = demoUserRepository.
        //TODO
        throw UnsupportedOperationException()
    }

    @Transactional
    fun delete(id: BigInteger): Boolean {
        demoUserRepository!!.delete(id)
        val tmp = demoUserRepository!!.findOne(id)
        return tmp == null
    }

    fun getById(id: BigInteger): MongoDemoUser {
        return demoUserRepository!!.findOne(id)
    }

    /*public List<MongoDemoUser> getAllByPage(Pageable page){
        return demoUserRepository.findAll(page);
    }*/

    val all: List<MongoDemoUser>
        get() = demoUserRepository!!.findAll()
}