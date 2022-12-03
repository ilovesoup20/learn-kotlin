package learnbyexamples

fun main() {
    //// Infix Functions
    infix fun Int.times(str: String) = str.repeat(this)
    println(2 times "Bye")

    val pair = "Ferrari" to "Katrina"
    println(pair)

    infix fun String.onto(other: String) = Pair(this, other)
    val myPair = "McLaren" onto "Lucas"
    println(myPair)

    val sophia = Person2("Sophia")
    val claudia = Person2("Caludia")
    sophia likes claudia
}

class Person2(val name: String) {
    val likedPeople = mutableListOf<Person2>()
    infix fun likes(other: Person2) {
        likedPeople.add(other)
    }
}
