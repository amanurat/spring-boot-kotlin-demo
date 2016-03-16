package com.truthbean.demo.config

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.http.HttpStatus
import org.springframework.web.servlet.config.annotation.CorsRegistry
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter

/**
 * Created by TruthBean on 2016/3/16 0016.
 */

@Configuration
class MVCConfig : WebMvcConfigurerAdapter() {

    override fun addViewControllers(registry: ViewControllerRegistry?) {
        registry!!.addViewController("/home.html").setViewName("home")
        registry.addViewController("/hello").setViewName("hello")
        registry.addViewController("/login").setViewName("login")
        registry.addStatusController("/truthbean", HttpStatus.BAD_GATEWAY)
    }

    /*@Bean
    public EmbeddedServletContainerCustomizer containerCustomizer() {

        return (container -> {
            ErrorPage error400Page = new ErrorPage(HttpStatus.BAD_REQUEST, "/error?status=400");
            ErrorPage error401Page = new ErrorPage(HttpStatus.UNAUTHORIZED, "/error?status=401");
            //ErrorPage error404Page = new ErrorPage(HttpStatus.NOT_FOUND, "/error?status=404");
            ErrorPage error500Page = new ErrorPage(HttpStatus.INTERNAL_SERVER_ERROR, "/error?status=500");
            ErrorPage exceptionPage = new ErrorPage(Throwable.class, "/error?status="+Throwable.class.toGenericString()+"");
            //ErrorPage error = new ErrorPage("/default-error-page.html");

            //container.addErrorPages(error400Page, error401Page, error404Page, error500Page,exceptionPage, error);

            container.addErrorPages(error400Page, error401Page, error500Page,exceptionPage);


            //ErrorPage error = new ErrorPage("/666666.html");
            //container.addErrorPages(error);

        });
    }*/

    @Bean
    fun corsConfigurer(): WebMvcConfigurer {
        return object : WebMvcConfigurerAdapter() {
            override fun addCorsMappings(registry: CorsRegistry?) {
                registry!!.addMapping("/api/**")
            }
        }
    }

}