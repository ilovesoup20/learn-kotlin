package learnbyexamples

fun main() {
    // any
    val numbers1 = listOf(1, -2, 3, -4, 5, -6) // 1

    val anyNegative = numbers1.any { it < 0 } // 2

    val anyGT6 = numbers1.any { it > 6 } // 3

    println("Numbers: $numbers1")
    println("Is there any number less than 0: $anyNegative")
    println("Is there any number greater than 6: $anyGT6")

    // all
    val numbers2 = listOf(1, -2, 3, -4, 5, -6) // 1

    val allEven = numbers2.all { it % 2 == 0 } // 2

    val below6 = numbers2.all { it < 6 } // 3

    println("Numbers: $numbers2")
    println("All numbers are even: $allEven")
    println("All numbers are less than 6: $below6")

    // none
    var numbers3 = listOf(1, -2, 3, -4, 5, -6) // 1

    val allEvenFlag = numbers3.none { it % 2 == 1 } // 2

    val allLess6 = numbers3.none { it > 6 } // 3

    println("Numbers: $numbers3")
    println("All numbers are even: $allEvenFlag")
    println("No element greater than 6: $allLess6")
}
