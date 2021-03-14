package com.linuxea.tool.tool

import com.linuxea.tool.util.CamelUtil
import com.linuxea.tool.util.FileUtil

class MapperTool(override val table: String) : Tool {


    override fun readTemplate(): String {
        return FileUtil.readTemplate("/template/mapper_template")
    }

    override fun generate(): String {
        val readTemplate = this.readTemplate()
        val replace = readTemplate.replace("{{table_name}}", this.table)
            .replace("{{tableCamel}}", CamelUtil.toCamel(this.table).capitalize())
            .replace("{{tablePO}}", CamelUtil.toCamel(this.table).capitalize() + "PO")
            .replace("{{table_api}}", CamelUtil.toCamel(this.table).capitalize() + "Api")


        FileUtil.mkdirs("C:\\Users\\MI\\Desktop\\github\\ahtCodeTool\\src\\main\\resources\\result\\${table}")
        FileUtil.toFile(
            replace,
            "C:\\Users\\MI\\Desktop\\github\\ahtCodeTool\\src\\main\\resources\\result\\${table}\\${
                CamelUtil.toCamel(this.table).capitalize()
            }Mapper.java"
        )

        return replace
    }

}
