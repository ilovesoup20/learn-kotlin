package learnbyexamples

//// Default Parameter Values and Named Arguments
// 'Unit' means no return value. Similar to 'void' in Java
fun printMessage(message: String): Unit {
    println(message)
}

fun printMessageWithPrefix(message: String, prefix: String = "Info") {
    println("[$prefix] $message")
}

fun sum(x: Int, y: Int): Int {
    return x + y
}

fun multiply(x: Int, y: Int) = x * y

fun main() {
    printMessage("Hello")
    printMessageWithPrefix("hello", "log")

    // Use default value for prefix
    printMessageWithPrefix("Hello")

    // Using named arguments
    printMessageWithPrefix(prefix = "Log", message = "Hello")
    println(sum(1, 2))
    println(multiply(2, 4))
}
