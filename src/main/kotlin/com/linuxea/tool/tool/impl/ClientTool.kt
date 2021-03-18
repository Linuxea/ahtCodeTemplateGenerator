package com.linuxea.tool.tool.impl

import com.linuxea.tool.tool.Tool
import com.linuxea.tool.util.CamelUtil
import com.linuxea.tool.util.FileUtil
import com.linuxea.tool.util.TableNameUtil

class ClientTool(override val table: String, override val path: String) : Tool {


    override fun readTemplate(): String {
        return FileUtil.readTemplate("/template/client_template")
    }

    override fun generate(): String {
        val readTemplate = this.readTemplate()
        val replace = readTemplate.replace("{{table_name}}", TableNameUtil.tableName(this.table))
            .replace("{{tableCamel}}", CamelUtil.toCamel(TableNameUtil.tableName(this.table)).capitalize())
            .replace("{{table_api}}", CamelUtil.toCamel(TableNameUtil.tableName(this.table)).capitalize() + "Api")
            .replace("{{table_comment}}", super.readTable().comment)
        this.writeFile(replace)
        return replace
    }

    override fun fileName(): String {
        return "${CamelUtil.toCamel(TableNameUtil.tableName(this.table)).capitalize()}Client.java"
    }
}