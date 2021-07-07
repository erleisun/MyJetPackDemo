package com.qinggan.myjetpackdemo.test


fun main() {
    test2()
}

//无参数函数
fun test() {
    println("无参数")
}

val test1 = {
    println("无参数1")
}

fun test2() {
    test()
    test1
    add(1, 2)
    add1

    val total = sum(10) { num1: Int, num2: Int -> num1 + num2 }
    println(total)

    filter(arr)
    println(test2(10) { it > 5 })

}


//有参数函数
fun add(a: Int, b: Int): Int {
    return a + b
}

val add1 = { a: Int, b: Int ->
    a + b
}


fun sum(a: Int, b: (num1: Int, num2: Int) -> Int): Int {
    return a + b.invoke(1, 2)
}


val arr = arrayOf<Int>(1, 2, 3, 4, 5)
fun filter(arr: Array<Int>) {
// 过滤掉数组中元素小于2的元素，取其第一个打印。这里的it就表示每一个元素。
    println(arr.filter { it < 5 }.component1())
}


fun test2(num1: Int, bool: (Int) -> Boolean): Int {

    return if (bool(num1)) {
        num1
    } else {
        0
    }
}

// 让函数返回一个函数,并携带状态值
fun test3(a: Int): () -> Int {
    var b = 3
    return fun(): Int {
        return a + b
    }
}

//引用外部变量，并改变外部变量的值
fun test4() {
    var sum = 0
    val arr = arrayOf(1, 2, 3, 4, 5, 6)
    arr.filter { it < 4 }.forEach { sum += it }
    println("sum $sum")

}







