package learnbyexamples

/*
    Kotlin allows adding new members to any class with the extension
    mechanisn. Namely, there are two types of extensions: extension
    functions and extension properties. They look a lot like normal
    functions and properties but with one important difference: you
    need to specify the type that you extend.
*/

data class Item(val name: String, val price: Float)

data class Order(val items: Collection<Item>)

// Add extension function
fun Order.maxPricedItemValue(): Float = this.items.maxByOrNull { it.price }?.price ?: 0F

fun Order.maxPricedItemName() = this.items.maxByOrNull { it.price }?.name ?: "NO_PRODUCT"

// Add extension property
val Order.commaDelimitedItemNames: String
    get() = items.map { it.name }.joinToString()

// It is possible to execute extensions on 'null' references.
// In an extension function, you can check the object for 'null'
// and use the result in your code:
fun <T> T?.nullSafeToString() = this?.toString() ?: "NULL"

fun main() {
    val order = Order(listOf(Item("Bread", 25.0F), Item("Wine", 29.0F), Item("Water", 12.0F)))
    println("Max priced item name: ${order.maxPricedItemName()}")
    println("Max priced item value: ${order.maxPricedItemValue()}")
    println("Items: ${order.commaDelimitedItemNames}")
}
