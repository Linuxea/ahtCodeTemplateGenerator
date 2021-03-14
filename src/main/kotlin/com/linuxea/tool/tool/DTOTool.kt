package com.linuxea.tool.tool

import com.linuxea.tool.util.CamelUtil
import com.linuxea.tool.util.FileUtil

class DTOTool(override val table: String) : Tool {

    private fun readColumn(): List<Column> {
        return arrayListOf(Column("name", "String", "姓名"), Column("id", "Long", "id"))
    }

    override fun readTemplate(): String {
        return FileUtil.readTemplate("/template/dto_template")
    }

    override fun generate(): String {
        val readTemplate = readTemplate()

        // 构造字段
        val readColumn = readColumn()
        val stringBuilder = StringBuilder()
        readColumn.forEach {
            stringBuilder
                .append("    ")
                .append(
                    """
    /**
     * ${it.comment}
     */
                """.trimEnd()
                )
                .append("\n")
                .append("    ")
                .append("private ").append(it.type).append(" ").append(it.name).append(";")
                .append("\n\n")
        }

        val replace = readTemplate.replace("{{table_name}}", this.table)
            .replace("{{tableCamel}}", CamelUtil.toCamel(this.table).capitalize())
            .replace("{{columns}}", stringBuilder.toString())



        FileUtil.mkdirs("C:\\Users\\MI\\Desktop\\github\\ahtCodeTool\\src\\main\\resources\\result\\${table}")
        FileUtil.toFile(
            replace,
            "C:\\Users\\MI\\Desktop\\github\\ahtCodeTool\\src\\main\\resources\\result\\${table}\\${
                CamelUtil.toCamel(this.table).capitalize()
            }DTO.java"
        )

        return replace

    }

}


