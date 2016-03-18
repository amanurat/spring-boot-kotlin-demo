package com.truthbean.demo.config

import org.aspectj.lang.JoinPoint
import org.aspectj.lang.annotation.AfterReturning
import org.aspectj.lang.annotation.Aspect
import org.springframework.stereotype.Component
import java.util.logging.Logger

/**
 * Created by TruthBean on 2016/3/16 0016.
 */

@Aspect
@Component
open class ActionMonitor {

    @AfterReturning("execution(* com.truthbean.demo..*Service.*(..))")
    @Throws(Exception::class)
    open fun logServiceAccess(joinPoint: JoinPoint) {
        logger.warning("Completed: " + joinPoint)
        //throw new RuntimeException(joinPoint.toLongString());
    }

    @AfterReturning("execution(* *.*Controller.*(..))")
    @Throws(Exception::class)
    open fun logControllerAccess(joinPoint: JoinPoint) {
        logger.warning("Completed: " + joinPoint)
        //throw new RuntimeException(joinPoint.toLongString());
    }

    companion object {
        private val logger = Logger.getLogger(ActionMonitor::class.java.name)
    }

}