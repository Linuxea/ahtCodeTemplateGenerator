package com.linuxea.tool.tool

import com.linuxea.tool.util.DatabaseUtil
import com.linuxea.tool.util.FileUtil
import java.io.File

interface Tool {

    val table: String

    val path: String

    fun readTemplate(): String

    fun generate(): String

    fun fileName(): String

    fun readTable(): Table {
        return DatabaseUtil.read(this.table)
    }


    fun writeFile(fileContext: String) {
        val separator = File.separator
        FileUtil.mkdirs("${path}${separator}${table}")
        FileUtil.toFile(fileContext, "${path}${separator}${table}${separator}${this.fileName()}")
    }

}