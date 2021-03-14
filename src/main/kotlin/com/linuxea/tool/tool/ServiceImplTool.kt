package com.linuxea.tool.tool

import com.linuxea.tool.util.CamelUtil
import com.linuxea.tool.util.FileUtil

class ServiceImplTool(override val table: String) : Tool {


    override fun readTemplate(): String {
        return FileUtil.readTemplate("/template/service_impl_template")
    }

    override fun generate(): String {
        val readTemplate = this.readTemplate()
        val replace = readTemplate
            .replace("{{tableService}}", CamelUtil.toCamel(this.table).capitalize() + "Service")
            .replace("{{tablePO}}", CamelUtil.toCamel(this.table).capitalize() + "PO")
            .replace("{{tableMapper}}", CamelUtil.toCamel(this.table).capitalize() + "Mapper")


        FileUtil.mkdirs("C:\\Users\\MI\\Desktop\\github\\ahtCodeTool\\src\\main\\resources\\result\\${table}")
        FileUtil.toFile(
            replace,
            "C:\\Users\\MI\\Desktop\\github\\ahtCodeTool\\src\\main\\resources\\result\\${table}\\${
                CamelUtil.toCamel(this.table).capitalize()
            }ServiceImpl.java"
        )

        return replace
    }

}

