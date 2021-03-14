package com.linuxea.tool.util

import java.io.File

class FileUtil {

    companion object {

        fun readTemplate(path: String): String {
            val resourceAsStream = FileUtil.javaClass.getResourceAsStream(path)
            return resourceAsStream.bufferedReader().readText()
        }

        fun mkdirs(path: String) {
            val file = File(path)
            if (!file.exists()) {
                file.mkdirs()
            }
        }


        fun toFile(content: String, absolutePath: String) {
            val file = File(absolutePath)
            if (file.exists()) {
                file.delete()
            }
            file.createNewFile()
            file.writeText(content)
        }

    }

}