package com.truthbean.demo.core.filter

import com.truthbean.demo.core.model.ErrorPage
import org.springframework.stereotype.Component
import org.springframework.web.filter.OncePerRequestFilter

import javax.servlet.FilterChain
import javax.servlet.ServletException
import javax.servlet.annotation.WebFilter
import javax.servlet.http.HttpServletRequest
import javax.servlet.http.HttpServletResponse
import java.io.IOException

/**
 * Created by TruthBean on 2016/3/14 0014.
 */
@Component
@WebFilter(asyncSupported = true, urlPatterns = arrayOf("/*"))
class PageFilter : OncePerRequestFilter() {

    @Throws(ServletException::class, IOException::class)
    override fun doFilterInternal(request: HttpServletRequest, response: HttpServletResponse, filterChain: FilterChain) {
        val uri = request.requestURI
        response.characterEncoding = "UTF-8"
        response.setHeader("Server", "Truth-Server/1.0")
        if (uri.endsWith(".jsp") || uri.endsWith(".jspx")) {
            response.status = 403
            response.setHeader("Cache-Control", "private,max-age=60,must-revalidate")
            response.contentType = "text/html;charset=UTF-8"
            response.writer.print(ErrorPage.setError("系统禁止直接访问jsp页面", "403-forbidden:页面${uri}禁止访问！"))
            return
        } else if (uri.endsWith(".php")) {
            response.status = 403
            response.setHeader("Cache-Control", "private,max-age=60,must-revalidate")
            response.contentType = "text/html;charset=UTF-8"
            response.writer.print(ErrorPage.setError("系统禁止直接访问php页面", "403-forbidden:页面${uri}禁止访问！"))
        } else if (uri.endsWith(".asp") || uri.endsWith(".aspx")) {
            response.status = 403
            response.setHeader("Cache-Control", "private,max-age=60,must-revalidate")
            response.contentType = "text/html;charset=UTF-8"
            response.writer.print(ErrorPage.setError("系统禁止直接访问php页面", "403-forbidden:页面${uri}禁止访问！"))
        } else {
            filterChain.doFilter(request, response)
        }

    }
}
