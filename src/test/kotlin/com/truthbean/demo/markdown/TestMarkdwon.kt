package com.truthbean.demo.markdown

import org.pegdown.PegDownProcessor
import org.springframework.core.io.ClassPathResource
import java.io.File
import java.io.IOException
import java.nio.file.Files
import java.nio.file.Paths
import java.util.*

/**
 * Created by TruthBean on 2016/3/18 0018.
 */
class TestMarkdwon {
    private val pegDownProcessor = PegDownProcessor()

    @Throws(IOException::class)
    fun all(): List<String> {
        val classPathResource = ClassPathResource("/posts/")

        val posts = ArrayList<String>()
        val files = classPathResource.file.listFiles() ?: throw RuntimeException("Something went really wrong")

        Arrays.asList(*files).forEach { post -> posts.add(post.name.split(".md".toRegex()).dropLastWhile { it.isEmpty() }.toTypedArray()[0]) }

        return posts
    }

    @Throws(IOException::class)
    operator fun get(name: String): String {
        val markdownFile = ClassPathResource("/posts/$name.md").file.absolutePath

        val fileContents = String(Files.readAllBytes(Paths.get(markdownFile)))
        return pegDownProcessor.markdownToHtml(fileContents)
    }
}