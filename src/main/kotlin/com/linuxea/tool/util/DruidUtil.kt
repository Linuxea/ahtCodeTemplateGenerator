package com.linuxea.tool.util

import com.alibaba.druid.pool.DruidDataSourceFactory
import java.sql.Connection
import java.sql.PreparedStatement
import java.sql.ResultSet
import java.sql.SQLException
import java.util.*


class Druid(properties: Properties) {

    // 静态数据源变量，供全局操作且用于静态代码块加载资源。
    private var dataSource = DruidDataSourceFactory.createDataSource(properties)

    /**
     * 创建数据库连接实例
     * @return 数据库连接实例 connection
     */
    val connection: Connection
        get() {
            try {
                return dataSource.connection
            } catch (e: SQLException) {
                e.printStackTrace()
            }
            throw RuntimeException("获取数据库连接异常")
        }

    /**
     * 释放数据库连接 connection 到数据库缓存池，并关闭 rSet 和 pStatement 资源
     * @param rSet 数据库处理结果集
     * @param pStatement 数据库操作语句
     * @param connection 数据库连接对象
     */
    fun releaseSqlConnection(rSet: ResultSet?, pStatement: PreparedStatement?, connection: Connection?) {
        println("准备释放数据库连接")
        try {
            rSet?.close()
        } catch (e: SQLException) {
            e.printStackTrace()
        } finally {
            try {
                pStatement?.close()
            } catch (e: SQLException) {
                e.printStackTrace()
            } finally {
                try {
                    connection?.close()
                } catch (e: SQLException) {
                    e.printStackTrace()
                }
            }
        }
    }

}