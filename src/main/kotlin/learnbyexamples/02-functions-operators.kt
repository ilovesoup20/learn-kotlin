package learnbyexamples

operator fun Int.times(str: String) = str.repeat(this)

operator fun String.get(range: IntRange) = substring(range)

val str = "Always forgive your enemies; nothing annoys them so much."

fun main() {
    println(2 * "Bye ")
    println(str[0..14])
}
