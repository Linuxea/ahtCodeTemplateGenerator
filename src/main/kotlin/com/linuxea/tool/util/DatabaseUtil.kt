package com.linuxea.tool.util

import com.linuxea.tool.tool.Column
import java.sql.Connection
import java.sql.ResultSet
import java.util.*

class DatabaseUtil {


    companion object {

        private val properties: Properties = Properties()

        init {
            val resourceAsStream = this.javaClass.classLoader.getResourceAsStream("db.properties")
            this.properties.load(resourceAsStream)
            val iter = properties.propertyNames().iterator()
            while (iter.hasNext()) {
                val next = iter.next() as String
                val property = properties.getProperty(next)
                println("${next}:${property}")
            }
        }

        fun doIt(table: String): List<Column> {
            val druid = Druid(this.properties)
            var resultSet: ResultSet? = null
            var connection: Connection? = null
            try {
                connection = druid.connection
                val createStatement = connection.createStatement()
                createStatement.execute("show create table $table")
                resultSet = createStatement.resultSet
                var createSql = ""
                while (resultSet.next()) {
                    createSql = (resultSet.getString(2))
                }
                return UglyParseCreateTable.parse(createSql)
            } catch (e: Exception) {
                println("发生了异常$e")
            } finally {
                druid.releaseSqlConnection(resultSet, null, connection)
            }
            return listOf()
        }
    }

}

