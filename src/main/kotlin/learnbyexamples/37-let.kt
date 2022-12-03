package learnbyexamples

/*
    Standard library function 'let' can be used for scoping and null-checks.
    When called on an object, 'let' executes the given block of code and
    returns the result of its last expression. The object is accessible
    inside the block by the reference 'it' (by default) or a custom name.
*/

fun customPrint(s: String) {
    print(s.uppercase())
}

fun main() {
    val empty =
            "test".let {
                customPrint(it)
                it.isEmpty()
            }
    println(" is empty: $empty")

    fun printNonNull(str: String?) {
        println("Printing \"$str\":")

        str?.let {
            print("\t")
            customPrint(it)
            println()
        }
    }

    fun printIfBothNonNull(strOne: String?, strTwo: String?) {
        strOne?.let { firstString ->
            strTwo?.let { secondString ->
                customPrint("$firstString : $secondString")
                println()
            }
        }
    }

    printNonNull(null)
    printNonNull("my string")
    printIfBothNonNull("first", "second")
}
