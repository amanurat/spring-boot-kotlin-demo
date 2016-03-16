package com.truthbean.demo.rdbms.query.persistence.repository

import com.truthbean.demo.rdbms.query.persistence.domain.QueryDemoUser
import org.springframework.data.domain.Pageable
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query
import org.springframework.scheduling.annotation.Async
import org.springframework.util.concurrent.ListenableFuture
import java.util.concurrent.CompletableFuture
import java.util.concurrent.Future
import java.util.stream.Stream

/**
 * Created by TruthBean on 2016/3/16 0016.
 */
interface QueryDemoUserRepository: JpaRepository<QueryDemoUser, String> {

    @Query("select u from QueryDemoUser u")
    abstract fun findAllByCustomQueryAndStream(): Stream<QueryDemoUser>

    abstract fun readAllByUserRealNameNotNull(): Stream<QueryDemoUser>

    @Query("select u from QueryDemoUser u")
    abstract fun streamAllPaged(pageable: Pageable): Stream<QueryDemoUser>

    @Async
    abstract fun findByUserRealName(realname: String): Future<QueryDemoUser>

    @Async
    abstract fun findOneByUserRealName(realname: String): CompletableFuture<QueryDemoUser>

    @Async
    abstract fun findOneByUserEmail(email: String): ListenableFuture<QueryDemoUser>
}