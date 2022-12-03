package learnbyexamples

import java.util.Random

class LuckDispatcher {
    fun getNumber() {
        var objRandom = Random()
        println(objRandom.nextInt(90))
    }
}

/*
    Kotlin has an 'object' keyword.
    It's used to obtain a data type with a single implementation.
    It's the same as the Singleton pattern in Java.

    To achieve singleton in kotlin, you only need to declare an object:
    no class, no constructor, only a lazy instance. Why lazy? Because
    it will be created once when the object is accessed. Otherwise,
    it won't even be created
*/

/*
    Here is a basic typical usage of object expression: a simple
    object/properties structure. There is no need to do so in class
    declaration: you create a single object, declare its members and
    access it within one function. Objects like this are often created
    in Java as anonymous class instances.
*/
fun rentPrice(standardDays: Int, festivityDays: Int, specialDays: Int): Unit {
    // using object expression
    val dayRates =
            object {
                var standard: Int = 30 * standardDays
                var festivity: Int = 50 * festivityDays
                var special: Int = 100 * specialDays
            }
    val total = dayRates.standard + dayRates.festivity + dayRates.special

    println("Total price:$$total")
}

object DoAuth {
    fun takeParams(username: String, password: String) {
        println("input Auth parameters = $username:$password")
    }
}

/*
    An object declaration inside a class is called 'companion object'.
    Syntactically it's similar to static methods in Java: you call object
    members using its class name as a qualifier. If you plan to use a
    companion object in Kotlin, consider using a 'package-level' function
    instead.
*/
class BigBen {
    companion object Bonger {
        fun getBongs(nTimes: Int) {
            for (i in 1..nTimes) {
                print("BONG ")
            }
        }
    }
}

fun main() {
    // Example 1 - Use class to instantiate objects
    val d1 = LuckDispatcher()
    val d2 = LuckDispatcher()

    d1.getNumber()
    d2.getNumber()

    // Example 2 - Using object expression
    rentPrice(10, 2, 1)

    // Example 3 - Using object declaration
    DoAuth.takeParams("foo", "qwerty")

    // Example 4 - companion objects
    BigBen.getBongs(12)
}
