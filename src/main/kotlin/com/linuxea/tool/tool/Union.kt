package com.linuxea.tool.tool

import com.linuxea.tool.tool.impl.*

class Union {

    fun generate(path: String, schema: String, tables: List<String>) {
        tables.forEach { table ->
            POTool(table, path).generate()
            DTOTool(table, path).generate()
            VOTool(table, path).generate()
            MapperTool(table, path).generate()
            ServiceTool(table, path).generate()
            ServiceImplTool(table, path).generate()
            ApiTool(table, path).generate()
            ClientTool(table, path).generate()
            ControllerTool(table, path).generate()
        }

    }

}

fun main(args: Array<String>) {
    println(args.contentToString())
    println("输入参数要求: path schema table1,table2...")
    Union().generate(args[0], args[1], args[2].split(",").toList())
}