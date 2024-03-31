package com.example.springKotlin

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class MyConfiguration {

    @Bean
    fun myBean(): MyBean {
        println("called MyBean")
        println(PropertiesHolder.ip)
        println(PropertiesHolder2.host)


        return MyBean()
    }
}

class MyBean {
    fun doSomething() {
        println("Doing something...")
    }
}