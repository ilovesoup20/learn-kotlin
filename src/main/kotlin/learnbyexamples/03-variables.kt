package learnbyexamples

fun main() {
    var a: String = "initial" // declare and initialize mutable variable
    println(a)
    val b: Int = 1 // declare and initialize immutable variable
    val c = 3 // declare and initialize immutable variable. type is inferred

    // var e: Int // declare variable without initialization
    // println(e)   // using uninitialized variable causes compile error

    // variables must be initialized before the first read
    val d: Int
    if (true) {
        d = 1
    } else {
        d = 2
    }
    println(d)

    println("$b $c")
}
