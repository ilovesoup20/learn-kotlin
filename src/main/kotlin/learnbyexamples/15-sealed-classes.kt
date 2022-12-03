package learnbyexamples

/*
    Sealed classes restricts the usage of inheritance.

    Once you declare a class sealed, it can only be subclassed from
    inside the same package where the sealed class is declared. It
    cannot be subclassed outside of the package where the sealed class
    is declared.
*/
sealed class Mammal(val name: String)

class Cat(val catName: String) : Mammal(catName)

class Human(val humanName: String, val job: String) : Mammal(humanName)

fun greetMammal(mammal: Mammal): String {
    when (mammal) {
        is Human -> return "Hello ${mammal.name}; You're working as ${mammal.job}"
        is Cat -> return "Hello ${mammal.name}"
    }
}

fun main() {
    println(greetMammal(Cat("Snowy")))
}
