package learnbyexamples

val nums = listOf(1, -2, 3, -4, 5, -6)

val doubled = nums.map { x -> x * 2 }
val tripled = nums.map { it * 3 }

fun main() {
    println(doubled)
    println(tripled)
}
