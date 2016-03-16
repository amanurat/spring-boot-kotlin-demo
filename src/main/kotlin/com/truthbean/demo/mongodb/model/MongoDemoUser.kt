package com.truthbean.demo.mongodb.model

import org.springframework.data.mongodb.core.mapping.Document
import java.math.BigInteger

/**
 * Created by TruthBean on 2016/3/16 0016.
 */

@Document(collection = "demo_user")
data class  MongoDemoUser(
        var id: BigInteger? = null,
        var userName: String? = null,
        var userRealName: String? = null,
        var userPassword: String? = null,
        var userEmail: String? = null,
        var userPhone: String? = null) {
    override fun toString(): String {
        return "MongoDemoUser{id=$id, userName='$userName\', userRealName='$userRealName\', userPassword='$userPassword\', userEmail='$userEmail\', userPhone='$userPhone\'}"
    }
}