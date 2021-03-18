package com.linuxea.tool.util

import com.linuxea.tool.tool.Column
import com.linuxea.tool.tool.Table
import java.util.*
import java.util.regex.Pattern

class UglyParseCreateTable {

    companion object {

        fun parse(tableName: String, createSql: String): Table {
            println("$tableName 打印建表语句 : \n${createSql}")

            val split = createSql.split("\n")

            val columns = split
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

                    // 获取注释
                    val commentPattern = Pattern.compile("COMMENT\\s+'(.*)'")
                    val commendMatch = commentPattern.matcher(it.trim())
                    val comment = if (commendMatch.find()) {
                        commendMatch.group(1)
                    } else CamelUtil.toCamel(group)
                    Column(CamelUtil.toCamel(group), typeClass, comment ?: "无注释")
                }
                .filter { Objects.nonNull(it) }


            val tableCommentPattern = Pattern.compile("COMMENT='(.*)'")
            val tableCommentMatcher = tableCommentPattern.matcher(createSql)
            val tableComment = if (tableCommentMatcher.find()) {
                tableCommentMatcher.group(1)
            } else "无表注释"

            return Table(tableName, tableComment, columns)

        }
    }

}