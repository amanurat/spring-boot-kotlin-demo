package com.truthbean.demo.rdbms.modify.persistence.repository

import com.truthbean.demo.rdbms.modify.persistence.domain.ModifyDemoUser
import org.springframework.data.jpa.repository.JpaRepository

/**
 * Created by TruthBean on 2016/3/16 0016.
 */
interface ModifyDemoUserRepository: JpaRepository<ModifyDemoUser, String> {
}