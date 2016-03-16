package com.truthbean.demo.core.controller

import org.springframework.boot.autoconfigure.web.ErrorController
import org.springframework.http.HttpStatus
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import javax.servlet.http.HttpServletRequest
import com.truthbean.demo.mix.core.util.isNumeric

/**
 * Created by TruthBean on 2016/3/16 0016.
 */
@Controller
class PageController : ErrorController {

    @RequestMapping("/default.html")
    fun greeting(@RequestParam(value = "name", required = false, defaultValue = "World") name: String, model: Model): String {
        model.addAttribute("name", name)
        return "default"
    }

    @RequestMapping("/error")
    fun error(model: Model, @RequestParam(name = "status", defaultValue = "404") status: String,
              @RequestParam(name = "reason", defaultValue = "系统错误") reason: String): String {
        var reason = reason
        var value = -1
        if (isNumeric(status))
            value = Integer.parseInt(status)
        var httpStatus = HttpStatus.NOT_FOUND
        try {
            httpStatus = HttpStatus.valueOf(value)
            reason = httpStatus.reasonPhrase
        } catch (lae: IllegalArgumentException) {
            //lae.printStackTrace();
        }

        model.addAttribute("error", reason)
        //return this.getErrorPath();
        return this.errorPath
    }

    override fun getErrorPath(): String {
        return "error/error"
    }
}