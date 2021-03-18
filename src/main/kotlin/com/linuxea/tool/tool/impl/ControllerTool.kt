package com.linuxea.tool.tool.impl

import com.linuxea.tool.tool.Tool
import com.linuxea.tool.util.CamelUtil
import com.linuxea.tool.util.FileUtil
import com.linuxea.tool.util.TableNameUtil

class ControllerTool(override val table: String, override val path: String) : Tool {


    override fun readTemplate(): String {
        return FileUtil.readTemplate("/template/controller_template")
    }

    override fun generate(): String {
        val readTemplate = this.readTemplate()
        val replace = readTemplate
            .replace("{{table_name}}", TableNameUtil.tableName(this.table))
            .replace("{{tableCamel}}", CamelUtil.toCamel(TableNameUtil.tableName(this.table)).capitalize())
            .replace("{{tablePO}}", CamelUtil.toCamel(TableNameUtil.tableName(this.table)).capitalize() + "PO")
            .replace("{{tableApi}}", CamelUtil.toCamel(TableNameUtil.tableName(this.table)).capitalize() + "Api")
            .replace("{{tableService}}", CamelUtil.toCamel(TableNameUtil.tableName(this.table)).capitalize() + "Service")
            .replace("{{table_comment}}", super.readTable().comment)
        this.writeFile(replace)
        return replace
    }

    override fun fileName(): String {
        return "${CamelUtil.toCamel(TableNameUtil.tableName(this.table)).capitalize()}Controller.java"
    }

}
