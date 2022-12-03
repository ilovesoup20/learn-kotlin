package learnbyexamples

/*
    Destructuring declaration syntax can be very handy, especially when
    you need an instance only for accessing its members. It lets you define
    the instance without a specific name therefore saving a few lines of code.
*/

fun findMinMax(list: List<Int>): Pair<Int, Int> {
    // do the math
    var min = list.get(0)
    var max = list.get(0)

    for (num in list) {
        min = Math.min(min, num)
        max = Math.max(max, num)
    }

    return Pair(min, max)
}

fun main() {
    //
    val (x, y, z) = arrayOf(5, 10, 15)
    println("$x $y $z")

    val map = mapOf("Alice" to 21, "Bob" to 25)
    for ((name, age) in map) {
        println("$name is $age years old")
    }

    val (min, max) = findMinMax(listOf(100, 90, 50, 98, 76, 83))
    println("min $min, max $max")

    //
    data class User(val username: String, val email: String)

    fun getUser() = User("Mary", "mary@somewhere.com")

    val user = getUser()
    val (username, email) = user
    println(username == user.component1())
    println(email == user.component2())

    val (_, emailAddress) = getUser()
    println(emailAddress)

    //
    class Pair<K, V>(val first: K, val second: V) {
        // `componentN` functions must be defined to use destructuring
        operator fun component1(): K {
            return first
        }
        operator fun component2(): V {
            return second
        }
    }
    val (num, name) = Pair(1, "one")
    println("num = $num, name = $name")
}
