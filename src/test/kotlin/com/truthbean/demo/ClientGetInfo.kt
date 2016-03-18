package com.truthbean.demo

import net.minidev.json.JSONObject
import org.apache.http.client.methods.HttpGet
import org.apache.http.client.methods.HttpPost
import org.apache.http.entity.StringEntity
import org.apache.http.impl.client.HttpClients
import org.apache.http.util.EntityUtils
import java.io.IOException

/**
 * Created by TruthBean on 2016/3/18 0018.
 */

object ClientGetInfo {

    @Throws(IOException::class)
    @JvmStatic fun main(args: Array<String>) {
        val httpclient = HttpClients.createDefault()
        val httpGet = HttpGet("http://localhost:8080/loginServer/app/loginServer")
        val response1 = httpclient.execute(httpGet)
        try {
            println(response1.statusLine)
            val entity1 = response1.entity

            // do something useful with the response body
            // and ensure it is fully consumed
            println(EntityUtils.toString(entity1, "UTF-8"))
        } finally {
            response1.close()
        }

        println("=============================================================================")

        val httpPost = HttpPost("http://localhost:8080/loginServer/app/loginAccount")
        val params = JSONObject()
        params.put("userName", "libiming")
        params.put("password", "123456")
        val s = StringEntity(params.toString())
        s.setContentEncoding("UTF-8")
        s.setContentType("application/json")

        /*List<NameValuePair> nvps = new ArrayList<NameValuePair>();
        nvps.add(new BasicNameValuePair("username", "123"));
        nvps.add(new BasicNameValuePair("password", "123"));
        httpPost.setEntity(new UrlEncodedFormEntity(nvps));*/
        httpPost.entity = s
        val response2 = httpclient.execute(httpPost)

        try {
            println(response2.statusLine)
            val entity2 = response2.entity
            // do something useful with the response body
            // and ensure it is fully consumed
            println(EntityUtils.toString(entity2, "UTF-8"))
            EntityUtils.consume(entity2)
        } finally {
            response2.close()
        }
    }
}