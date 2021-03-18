package com.linuxea.tool.util

import com.linuxea.tool.tool.Table
import java.sql.Connection
import java.sql.ResultSet
import java.util.*
import kotlin.collections.HashMap

class DatabaseUtil {


    companion object {

        private val properties: Properties = Properties()
        private val tableMap: HashMap<String, Table> = HashMap()

        init {
            val resourceAsStream = this.javaClass.classLoader.getResourceAsStream("db.properties")
            this.properties.load(resourceAsStream)
            val iter = properties.propertyNames().iterator()
            while (iter.hasNext()) {
                val next = iter.next() as String
                val property = properties.getProperty(next)
                println("${next}:${property}")
            }
            println("###################################")
        }

        @Synchronized
        fun read(tableName: String): Table {
            val cacheTable = tableMap[tableName]
            if (cacheTable != null) {
                return cacheTable
            }

            val druid = Druid(this.properties)
            var resultSet: ResultSet? = null
            var connection: Connection? = null
            try {
                connection = druid.connection
                val createStatement = connection.createStatement()
                createStatement.execute("show create table $tableName")
                resultSet = createStatement.resultSet
                var createSql = ""
                while (resultSet.next()) {
                    createSql = (resultSet.getString(2))
                }
                val parseTable = UglyParseCreateTable.parse(tableName, createSql)
                tableMap[tableName] = parseTable
                return parseTable
            } catch (e: Exception) {
                println("发生了异常$e")
            } finally {
                druid.releaseSqlConnection(resultSet, null, connection)
            }

            throw java.lang.Exception("读取表异常")
        }

    }

}

