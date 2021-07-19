package com.qinggan.myjetpackdemo.test

import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch


fun main() {

    var person: Person = Person()
    person.also {
        it.age = 5
        it.sex = 2
    }

    person.apply {
        this.age = 6
        this.sex = 1
    }

    person.doWithTry() {
        person.age = 5
        person.sex = 1
    }


    launchTest()
}

fun launchTest() {
    println("start launchTest")
    GlobalScope.launch { //后台启动一个新的携程并继续
        println("delay start")
        delay(2000L)
        println("delay end")
    }
    println("end launchTest")
}


class Person {
    var age: Int = 0
    var sex: Int = 1
}