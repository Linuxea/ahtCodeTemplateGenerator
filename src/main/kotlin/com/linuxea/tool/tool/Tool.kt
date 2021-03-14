package com.linuxea.tool.tool

interface Tool {

    val table: String

    fun readTemplate(): String

    fun generate(): String

}