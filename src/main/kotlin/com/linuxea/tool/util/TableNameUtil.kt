package com.linuxea.tool.util

class TableNameUtil {

    companion object {


        fun tableName(tableFullName: String): String {
            if (tableFullName.contains(".")) {
                val array = tableFullName.split(".")
                return array[array.size - 1]
            }
            return tableFullName
        }


    }

}