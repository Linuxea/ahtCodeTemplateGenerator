package com.linuxea.tool.tool

class Union {

    fun generate() {
        val table = "train_check_in_course_detail"
        POTool(table).generate()
        DTOTool(table).generate()
        VOTool(table).generate()
        MapperTool(table).generate()
        ServiceTool(table).generate()
        ServiceImplTool(table).generate()
        ApiTool(table).generate()
        ClientTool(table).generate()
        ControllerTool(table).generate()
    }

}

fun main() {
    Union().generate()
}