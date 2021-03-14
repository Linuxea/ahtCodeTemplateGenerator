package com.linuxea.tool.tool.impl

import com.linuxea.tool.tool.Tool
import com.linuxea.tool.util.CamelUtil
import com.linuxea.tool.util.FileUtil

class ServiceImplTool(override val table: String,override val path: String) : Tool {


    override fun readTemplate(): String {
        return FileUtil.readTemplate("/template/service_impl_template")
    }

    override fun generate(): String {
        val readTemplate = this.readTemplate()
        val replace = readTemplate
            .replace("{{tableService}}", CamelUtil.toCamel(this.table).capitalize() + "Service")
            .replace("{{tablePO}}", CamelUtil.toCamel(this.table).capitalize() + "PO")
            .replace("{{tableMapper}}", CamelUtil.toCamel(this.table).capitalize() + "Mapper")
        this.writeFile(replace)
        return replace
    }

    override fun fileName(): String {
        return "${CamelUtil.toCamel(this.table).capitalize()}ServiceImpl.java"
    }

}

