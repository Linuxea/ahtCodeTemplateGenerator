package com.linuxea.tool.tool.impl

import com.linuxea.tool.tool.Tool
import com.linuxea.tool.util.CamelUtil
import com.linuxea.tool.util.FileUtil
import com.linuxea.tool.util.TableNameUtil

open class POTool(override val table: String, override val path: String) : Tool {


    private fun notShowColumn(): List<String> {
        return listOf("id", "isDeleted", "generateDate", "modifyDate", "createDate")
    }

    override fun readTemplate(): String {
        return FileUtil.readTemplate("/template/po_template")
    }

    override fun generate(): String {
        val readTemplate = readTemplate()

        // 构造字段
        val readTable = this.readTable()
        val readColumn = readTable.columns.filter { it.name !in notShowColumn() }
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

        val replace = readTemplate.replace("{{table_name}}", TableNameUtil.tableName(this.table))
            .replace("{{tableCamel}}", CamelUtil.toCamel(TableNameUtil.tableName(this.table)).capitalize())
            .replace("{{columns}}", stringBuilder.toString())
            .replace("{{table_comment}}", readTable.comment)
            .replace("{{full_table_name}}", this.table)


        this.writeFile(replace)
        return replace

    }

    override fun fileName(): String {
        return "${CamelUtil.toCamel(TableNameUtil.tableName(this.table)).capitalize()}PO.java"
    }

}



