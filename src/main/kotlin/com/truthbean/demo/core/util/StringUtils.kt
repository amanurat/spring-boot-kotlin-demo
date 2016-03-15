package com.truthbean.demo.mix.core.util

import java.sql.Blob
import java.sql.SQLException
import java.text.SimpleDateFormat
import java.util.*
import java.util.regex.Matcher
import java.util.regex.Pattern

/**
 * @since 2016-02-11 10:25
 * @author TruthBean
 */

fun isEmpty(str: Any?): Boolean {
    return str == null || "" == str
}

fun isRealValue(obj: Any?): Boolean {
    return obj != null && obj is String && !(obj as String?)!!.trim { it <= ' ' }.isEmpty()
}

fun isNotEmpty(obj: Any?): Boolean {
    return obj != null && obj is String && !(obj as String?)!!.isEmpty()
}

fun isNotEmpty(vararg args: Any?): Boolean {
    var count = 0
    for (obj in args) {
        if (obj != null && obj is String && !(obj as String?)!!.trim { it <= ' ' }.isEmpty()) {
            count++
        } else {
            break
        }
    }
    return count == args.size
    //return false
}

fun isNumeric(str: String?): Boolean {
    val pattern = Pattern.compile("[0-9]*")
    var result = false
    try{
        if(isRealValue(str)){
            val isNum = pattern.matcher(str)
            result = isNum.matches()
        }
    }catch(e: Exception){
        e.printStackTrace()
    }
    return result
}

fun generateHtmlURI(): String {
    val df = SimpleDateFormat("yyyyMMddHHmmssSSS")// 设置日期格式
    val result = StringBuilder(df.format(Date(System.currentTimeMillis())))// new Date()为获取当前系统时间
    result.append(".html")
    return result.toString()
}

fun format(obj: Any?): String {
    var result: String? = null
    if (obj != null && obj is Blob) {
        var bolblen = 0
        try {
            bolblen = obj.length().toInt()
        } catch (e: SQLException) {
            e.printStackTrace()
        }
        var data: ByteArray? = null
        try {
            data = obj.getBytes(1, bolblen)
        } catch (e: SQLException) {
            e.printStackTrace()
        }
        result = data.toString()
    }
    return result as String
}

fun Html2Text(inputString: String): String {
    //var htmlStr = inputString // 含html标签的字符串
    var textStr = ""
    val p_html: Pattern
    val m_html: Matcher

    try {
        val regEx_html = "<[^>]+>" // 定义HTML标签的正则表达式

        p_html = Pattern.compile(regEx_html, Pattern.CASE_INSENSITIVE)
        m_html = p_html.matcher(inputString)
        val htmlStr = m_html.replaceAll("") // 过滤html标签

        textStr = htmlStr.replace("\\s".toRegex(), "").replace("&nbsp;".toRegex(), "").trim({ it <= ' ' })

    } catch (e: Exception) {
        System.err.println("Html2Text: " + e.message)
    }

    return textStr// 返回文本字符串
}