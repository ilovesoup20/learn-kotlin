package learnbyexamples

fun main() {

    // using when statement
    cases("hello")
    cases(1)
    cases(0L)
    cases(MyClass())
    cases("Hello")

    // using when expression
    println(whenAssign("hello"))
    println(whenAssign(3.4))
    println(whenAssign(1))
    println(whenAssign(MyClass()))
}

fun cases(obj: Any) {
    // when statement
    when (obj) {
        1 -> println("One")
        "hello" -> println("Greeting")
        is Long -> println("Long")
        !is String -> println("not a string")
        else -> println("unknown")
    }
}

class MyClass

fun whenAssign(obj: Any): Any {
    val result =
            when (obj) {
                1 -> "one"
                "hello" -> 1
                is Long -> false
                else -> 42
            }
    return result
}
