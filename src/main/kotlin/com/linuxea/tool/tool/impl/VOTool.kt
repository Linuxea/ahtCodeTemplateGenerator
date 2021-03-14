package com.linuxea.tool.tool.impl

import com.linuxea.tool.util.CamelUtil
import com.linuxea.tool.util.FileUtil

class VOTool(override val table: String, override val path: String) : POTool(table, path) {


    override fun readTemplate(): String {
        return FileUtil.readTemplate("/template/vo_template")
    }


    override fun fileName(): String {
        return "${CamelUtil.toCamel(this.table).capitalize()}VO.java"
    }

}


