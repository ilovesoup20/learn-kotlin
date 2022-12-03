package learnbyexamples

/*
    flatMap transforms each element of a collection into an iterable
    object and builds a single list of the transformation results.
    The transformation is user-defined.
*/

fun main() {
    val fruitsBag = listOf("apple", "orange", "banana", "grapes")
    val clothesBag = listOf("shirts", "pants", "jeans")
    val cart = listOf(fruitsBag, clothesBag)
    val mapBag = cart.map { it }
    val flatMapBag = cart.flatMap { it }

    println("Your bags are: $mapBag")
    println("The things you bought are: $flatMapBag")
}
