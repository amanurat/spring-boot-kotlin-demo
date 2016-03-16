package com.truthbean.demo.mongodb.repository

import com.truthbean.demo.mongodb.model.MongoDemoUser
import org.springframework.data.mongodb.repository.MongoRepository
import java.math.BigInteger

/**
 * Created by TruthBean on 2016/3/16 0016.
 */

interface MongoDemoUserReponsitory : MongoRepository<MongoDemoUser, BigInteger>