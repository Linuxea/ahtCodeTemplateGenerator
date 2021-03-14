package com.linuxea.tool.tool.impl

import com.linuxea.tool.tool.Tool
import com.linuxea.tool.util.CamelUtil
import com.linuxea.tool.util.FileUtil


class ApiTool(override val table: String, override val path: String) : Tool {


    override fun readTemplate(): String {
        return FileUtil.readTemplate("/template/api_template")
    }


    override fun generate(): String {
        val readTemplate = this.readTemplate()
        val replace = readTemplate.replace("{{table_name}}", this.table)
            .replace("{{tableCamel}}", CamelUtil.toCamel(this.table).capitalize())
            .replace("{{tablePO}}", CamelUtil.toCamel(this.table).capitalize() + "PO")
        this.writeFile(replace)
        return replace
    }

    override fun fileName(): String {
        return "${CamelUtil.toCamel(this.table).capitalize()}Api.java"
    }


}

