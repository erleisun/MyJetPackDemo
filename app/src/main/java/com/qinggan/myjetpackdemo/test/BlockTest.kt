package com.qinggan.myjetpackdemo.test

import kotlinx.coroutines.*


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
    repeatTest()
}

fun launchTest() {
    println("start launchTest")
    val job = GlobalScope.launch(Dispatchers.IO) { //后台启动一个新的携程并继续
        val delay = setDelay()
        println("setDelay = $delay")
    }
    println("end launchTest")

    Thread.sleep(3000L)
    job.cancel()
}

suspend fun setDelay(): Long = withContext(Dispatchers.IO) {
    val delay = 2000L
    delay(delay)

    return@withContext delay
}


 fun repeatTest() {

    val job = GlobalScope.launch {
        repeat(1000) { i: Int ->
            println("repeat $i")
            delay(500L)
        }
    }

    Thread.sleep(3000L)
    job.cancel()
//    job.join()

}


class Person {
    var age: Int = 0
    var sex: Int = 1
}