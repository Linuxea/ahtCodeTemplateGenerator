package com.linuxea.tool.tool.impl

import com.linuxea.tool.tool.Tool
import com.linuxea.tool.util.CamelUtil
import com.linuxea.tool.util.FileUtil
import com.linuxea.tool.util.TableNameUtil

class ServiceImplTool(override val table: String,override val path: String) : Tool {


    override fun readTemplate(): String {
        return FileUtil.readTemplate("/template/service_impl_template")
    }

    override fun generate(): String {
        val readTemplate = this.readTemplate()
        val replace = readTemplate
            .replace("{{tableService}}", CamelUtil.toCamel(TableNameUtil.tableName(this.table)).capitalize() + "Service")
            .replace("{{tablePO}}", CamelUtil.toCamel(TableNameUtil.tableName(this.table)).capitalize() + "PO")
            .replace("{{tableMapper}}", CamelUtil.toCamel(TableNameUtil.tableName(this.table)).capitalize() + "Mapper")
            .replace("{{table_comment}}", super.readTable().comment)
        this.writeFile(replace)
        return replace
    }

    override fun fileName(): String {
        return "${CamelUtil.toCamel(TableNameUtil.tableName(this.table)).capitalize()}ServiceImpl.java"
    }

}

