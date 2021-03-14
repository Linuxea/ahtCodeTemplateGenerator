package com.linuxea.tool.util

import com.linuxea.tool.tool.Column
import java.util.*
import java.util.regex.Pattern

class UglyParseCreateTable {

    companion object {

        fun parse(createSql: String): List<Column> {

            println("建表语句 $createSql")

            val split = createSql.split("\n")

            return split
                .filter { it.trim().startsWith("`") }
                .map {
                    val fields = it.trim().split(" ")

                    val linePattern: Pattern = Pattern.compile("`(\\w+)`")
                    val matcher = linePattern.matcher(fields[0])
                    val group = if (matcher.find()) {
                        matcher.group(1)
                    } else "不确定字段"

                    val type = fields[1]
                    val longs = listOf("bigint")
                    val ints = listOf("tinyint", "int")
                    val strings = listOf("varchar")
                    val dates = listOf("datetime", "date")
                    val typeClass: String = when {
                        longs.any { long -> type.contains(long) } -> {
                            "Long"
                        }
                        dates.any { date -> type.contains(date) } -> {
                            "Date"
                        }
                        ints.any { int -> type.contains(int) } -> {
                            "Integer"
                        }
                        strings.any { str -> type.contains(str) } -> {
                            "String"
                        }
                        else -> {
                            "不确定类型"
                        }
                    }

                    Column(CamelUtil.toCamel(group), typeClass, "无注释")
                }
                .filter { Objects.nonNull(it) }
        }
    }

}