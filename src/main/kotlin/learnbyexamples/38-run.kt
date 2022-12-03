package learnbyexamples

/*
    Like `let`, `run` is another scoping function from the standard library.
    Basically, it does the same: executes a code block and returns its result.
    The difference is that inside `run` the object is acccessed by `this`.
    This is useful when you want to call the object's methods rather than
    pass it as an argument.
*/

fun main() {
    fun getNullableLength(ns: String?) {
        println("for \"$ns\":")
        ns?.run {
            println("\tis empty? " + isEmpty())
            println("\tlength = $length")
            length
        }
    }

    getNullableLength(null)
    getNullableLength("")
    getNullableLength("some string with kotlin")
}
