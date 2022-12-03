// first, last
fun example1() {

    val numbers = listOf(1, -2, 3, -4, 5, -6) // 1

    val first = numbers.first() // 2
    val last = numbers.last() // 3

    val firstEven = numbers.first { it % 2 == 0 } // 4
    val lastOdd = numbers.last { it % 2 != 0 } // 5

    println("Numbers: $numbers")
    println("First $first, last $last, first even $firstEven, last odd $lastOdd")
}

// firstOrNull, lastOrNull
fun example2() {

    val words = listOf("foo", "bar", "baz", "faz") // 1
    val empty = emptyList<String>() // 2

    val first = empty.firstOrNull() // 3
    val last = empty.lastOrNull() // 4

    val firstF = words.firstOrNull { it.startsWith('f') } // 5
    val firstZ = words.firstOrNull { it.startsWith('z') } // 6
    val lastF = words.lastOrNull { it.endsWith('f') } // 7
    val lastZ = words.lastOrNull { it.endsWith('z') } // 8

    println("Empty list: first is $first, last is $last")
    println(
            "Word list: first item starting with 'f' is $firstF, first item starting with 'z' is $firstZ"
    )
    println("Word list: last item ending with 'f' is $lastF, last item ending with 'z' is $lastZ")
}

fun main() {
    example1()
    example2()
}
