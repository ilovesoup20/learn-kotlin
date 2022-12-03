package learnbyexamples

/*
    Lambda functions are a simple way to create functions ad-hoc.
    Lambdas can be denoted very concisely in many cases thanks to type
    inference and the implicit 'it' variable.
*/

val upperCase1: (String) -> String = { str: String -> str.uppercase() }

val upperCase2: (String) -> String = { str -> str.uppercase() }

val upperCase3 = { str: String -> str.uppercase() }

// This isn't possible.
// val upperCase4 = { str -> str.uppercase() }

// Lambda functions with single parameter have implicit 'it' variable.
val upperCase5: (String) -> String = { it.uppercase() }

// If a lambda consists of a single function call, you may use function pointers (::)
val upperCase6: (String) -> String = String::uppercase

fun main() {
    println(upperCase1("hello"))
    println(upperCase2("hello"))
    println(upperCase3("hello"))
    println(upperCase5("hello"))
    println(upperCase6("hello"))
}
