package com.truthbean.demo.rdbms.modify.persistence.domain

import org.hibernate.annotations.GenericGenerator
import javax.persistence.*

/**
 * Created by TruthBean on 2016/3/16 0016.
 */

@Entity
@Table(name = "demo_user")
data class ModifyDemoUser(
        @Id
        @GenericGenerator(name = "demo_user_id", strategy = "uuid")
        @Column(name = "demo_user_id", unique = true, nullable = false, length = 32)
        @GeneratedValue(generator = "demo_user_id", strategy = javax.persistence.GenerationType.SEQUENCE)
        var userUUID: String? = null,

        @Column(name = "demo_user_name", unique = true, nullable = false, length = 20)
        var userName: String? = null,

        @Column(name = "demo_user_realname", length = 45)
        var userRealName: String? = null,

        @Column(name = "demo_user_password", nullable = false)
        var userPassword: String? = null,

        @Column(name = "demo_user_email", length = 45)
        var userEmail: String? = null,

        @Column(name = "demo_user_phone", length = 20)
        var userPhone: String? = null
) {
    override fun toString(): String {
        return "ModifyDemoUser{userUUID='$userUUID\', userName='$userName\', userRealName='$userRealName\', userPassword='$userPassword\', userEmail='$userEmail\', userPhone='$userPhone\'}"
    }
}