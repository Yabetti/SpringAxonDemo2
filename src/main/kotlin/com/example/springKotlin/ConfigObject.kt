package com.example.springKotlin

import java.io.FileInputStream
import java.util.*

class ConfigObject {
    fun loadProperties() {
        val filePath = "C:\\Users\\teemo\\Github\\springKotlin\\src\\main\\resources\\conf\\default.properties"
        val properties = Properties()
        val fileInputStream = FileInputStream(filePath)
        properties.load(fileInputStream)
        fileInputStream.close()
        // プロパティをStaticクラスにセット
        PropertiesHolder.host = properties.getProperty("test.host")
        PropertiesHolder.ip = properties.getProperty("test.ip")
        //PropertiesHolder.username = properties.getProperty("spring.datasource.username")
        //PropertiesHolder.password = properties.getProperty("spring.datasource.password")
    }
}