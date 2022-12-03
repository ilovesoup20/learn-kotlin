package learnbyexamples

/*
    Kotlin classes are 'final' by default.
    To use inheritance on a class it must be marked with the 'open' modifier

    Kotlin methods are also 'final by default.
    'open' modifier is required to override methods

    A class inherits a superclass when you specify the ': SuperclassName()' after its name.
    The empty parantheses indicate an invocation of the superclass default constructor.

    Overriding methods or attributes require the 'override' modifier
*/

// Inheritance
open class Dog {
    open fun sayHello() {
        println("wow wow!")
    }
}

class Yorkshire: Dog() {
    override fun sayHello() {
        println("wif wif!")
    }
}

// Inheritance with Parameterized Constructor
open class Tiger(val origin: String) {
    fun sayHello() {
        println("A tiger from $origin says: grrhhh!")
    }
}

class SiberianTiger : Tiger("Siberia")

// Passing constructor arguments to superclass
open class Lion(val name: String, val origin: String) {
    fun sayHello() {
        println("$name, the lion from $origin says: groah!")
    }
}
class Asiatic(name: String) : Lion(name = name, origin ="India")

fun main() {
    val dog: Dog = Yorkshire()
    dog.sayHello()

    val tiger: Tiger = SiberianTiger()
    tiger.sayHello()

    val lion: Lion = Asiatic("Rufo")
    lion.sayHello()
}