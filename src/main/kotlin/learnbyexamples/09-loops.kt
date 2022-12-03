fun eatACake() = println("eat a cake")

fun bakeACake() = println("bake a cake")

class Animal(val name: String)

class Zoo(val animals: List<Animal>) {
    operator fun iterator(): Iterator<Animal> {
        return animals.iterator()
    }
}

fun main() {
    val cakes = listOf("carrot", "cheese", "chocolate")

    // for loop
    for (cake in cakes) {
        println("yummy $cake")
    }

    // while and do-while
    var cakesEaten = 0
    var cakesBaked = 0

    while (cakesEaten < 5) {
        eatACake()
        cakesEaten++
    }

    do {
        bakeACake()
        cakesBaked++
    } while (cakesBaked < cakesEaten)

    // iterators
    val zoo = Zoo(listOf(Animal("zebra"), Animal("lion")))
    for (animal in zoo) {
        println("watch out for ${animal.name}")
    }
}
