package com.linuxea.tool.tool.impl

import com.linuxea.tool.tool.Column
import com.linuxea.tool.tool.Tool
import com.linuxea.tool.util.CamelUtil
import com.linuxea.tool.util.DatabaseUtil
import com.linuxea.tool.util.FileUtil

open class POTool(override val table: String, override val path: String) : Tool {

    private fun readColumn(): List<Column> {
        val notShowColumn = this.notShowColumn()
        return DatabaseUtil.readColumns(table).filter { it.name !in notShowColumn }
    }

    private fun notShowColumn(): List<String> {
        return listOf("id", "isDeleted", "generateDate", "modifyDate", "createDate")
    }

    override fun readTemplate(): String {
        return FileUtil.readTemplate("/template/po_template")
    }

    override fun generate(): String {
        val readTemplate = readTemplate()

        // 构造字段
        val readColumn = readColumn()
        val stringBuilder = StringBuilder()
        readColumn.forEach {
            stringBuilder
                .append(
                    """
    /**
     * ${it.comment}
     */
    @ApiModelProperty("${it.comment}")
    private ${it.type} ${it.name};
        """
                )
                .append("\n")
        }

        val replace = readTemplate.replace("{{table_name}}", this.table)
            .replace("{{tableCamel}}", CamelUtil.toCamel(this.table).capitalize())
            .replace("{{columns}}", stringBuilder.toString())


        this.writeFile(replace)
        return replace

    }

    override fun fileName(): String {
        return "${CamelUtil.toCamel(this.table).capitalize()}PO.java"
    }

}



