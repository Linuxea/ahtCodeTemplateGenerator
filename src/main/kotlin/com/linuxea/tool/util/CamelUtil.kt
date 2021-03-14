package com.linuxea.tool.util

import java.util.regex.Pattern

class CamelUtil {

    companion object {

        fun toCamel(sneakString: String): String {
            val linePattern: Pattern = Pattern.compile("_(\\w)")
            val matcher = linePattern.matcher(sneakString.toLowerCase())
            val sb = StringBuffer()
            while (matcher.find()) {
                matcher.appendReplacement(sb, matcher.group(1).toUpperCase())
            }
            matcher.appendTail(sb)
            return sb.toString()
        }

    }

}