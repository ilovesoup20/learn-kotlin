package learnbyexamples

/*
    A "higher-order function" is a function that takes another function
    as parameter and/or returns a function.
*/
fun calculate(x: Int, y: Int, operation: (Int, Int) -> Int): Int {
    return operation(x, y)
}

fun sum2(x: Int, y: Int) = x + y

fun operation(): (Int) -> Int {
    return ::square
}

fun square(x: Int) = x * x

fun main() {

    // Taking functions as parameters
    val sumResult = calculate(4, 5, ::sum2)
    val mulResult = calculate(4, 5) { a, b -> a * b }

    println("sum $sumResult; mul $mulResult")

    // Returning functions
    val func = operation()
    println(func(2))
}
