package com.example.springKotlin

import org.springframework.beans.factory.config.BeanPostProcessor
import org.springframework.context.ApplicationContext
import org.springframework.context.support.ClassPathXmlApplicationContext
import org.springframework.stereotype.Component


@Component
class MyBeanPostProcessor : BeanPostProcessor {

    private var isFirstCall = true

    override fun postProcessBeforeInitialization(bean: Any, beanName: String): Any? {

        // 最初の呼び出し以外は処理をスキップ
        if (!isFirstCall) {
            return bean
        }

        // 最初の呼び出しの場合の処理
        println("Processing bean: $beanName")

        // 最初の呼び出しを完了した後、フラグをfalseに設定する
        isFirstCall = false

        // 案1。プロパティファイル読み込んでメモリ保持
        val co = ConfigObject()
        co.loadProperties()

        // 案２．XML経由のBean取得
        val context: ApplicationContext = ClassPathXmlApplicationContext("conf/xml/readBean.xml")
        // Beanの取得
        val xmlPropertiesHolder: PropertiesHolder2 = context.getBean("xmlbean") as PropertiesHolder2
        println(xmlPropertiesHolder.host)


        // Springコンテナのシャットダウン（必要な場合）
        (context as ClassPathXmlApplicationContext).close()



        return bean
    }
}
