package com.truthbean.demo.config

import org.springframework.boot.autoconfigure.security.SecurityProperties
import org.springframework.context.annotation.Configuration
import org.springframework.core.annotation.Order
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder
import org.springframework.security.config.annotation.web.builders.HttpSecurity
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter

/**
 * Created by TruthBean on 2016/3/16 0016.
 */

@Configuration
@EnableWebSecurity
@Order(SecurityProperties.ACCESS_OVERRIDE_ORDER)
class SecurityConfig : WebSecurityConfigurerAdapter() {

    @Throws(Exception::class)
    override fun configure(httpSecurity: HttpSecurity) {
        httpSecurity.authorizeRequests().antMatchers("/").fullyAuthenticated().and().formLogin()
                .loginPage("/login").failureUrl("/login?error").permitAll().and()
                .logout().permitAll();
    }

    override fun configure(auth: AuthenticationManagerBuilder?) {
        super.configure(auth)
        auth!!.inMemoryAuthentication().withUser("admin").password("admin")
                .roles("ADMIN", "USER").and().withUser("user").password("user")
                .roles("USER");
    }

}