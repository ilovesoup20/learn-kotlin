package learnbyexamples

fun printAll(vararg messages: String) {
    for (m in messages) println(m)
}

fun printAllWithPrefix(vararg messages: String, prefix: String) {
    for (m in messages) println(prefix + m)
}

fun printAllWithPrefix2(prefix: String, vararg messages: String) {
    for (m in messages) println(prefix + m)
}

fun log(vararg entries: String) {
    // '*' is a special spread operator
    printAll(*entries)
}

fun main() {
    printAll("Hello", "Hallo", "Salut", "Hola")
    printAllWithPrefix("Hello", "Hallo", prefix = "Greeting: ")
    printAllWithPrefix2("Greeting: ", "Hello", "Hallo")
}
