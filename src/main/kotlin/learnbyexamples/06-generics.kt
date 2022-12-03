package learnbyexamples

// Generic class
class MutableStack<E>(vararg items: E) {
    private val elements = items.toMutableList()

    fun push(element: E) = elements.add(element)

    fun peek(): E = elements.last()

    fun pop(): E = elements.removeAt(elements.size - 1)

    fun isEmpty() = elements.isEmpty()

    fun size() = elements.size

    override fun toString() = "MutableStack(${elements.joinToString()})"
}

// Generic function
fun <E> mutableStackOf(vararg elements: E) = MutableStack(*elements)

fun main() {
    val stack = MutableStack(1, 2)

    println(stack)

    val stack2 = mutableStackOf("a", "b")
    println(stack2)

    val stack3 = mutableStackOf(true, false, false)
    println(stack3)
}
