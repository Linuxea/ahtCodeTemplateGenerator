package com.linuxea.tool.tool

import com.linuxea.tool.util.FileUtil

interface Tool {

    val table: String

    val path: String

    fun readTemplate(): String

    fun generate(): String

    fun fileName(): String


    fun writeFile(fileContext: String) {
        FileUtil.mkdirs("${path}\\${table}")
        FileUtil.toFile(fileContext, "${path}\\${table}\\${this.fileName()}")
    }

}