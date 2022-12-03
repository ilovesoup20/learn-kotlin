package learnbyexamples

import kotlin.reflect.KProperty

class Example {
    var p: String by Delegate()

    override fun toString() = "example class"
}

class Delegate() {
    operator fun getValue(thisRef: Any?, prop: KProperty<*>): String {
        return "$thisRef, thank for the delegating '${prop.name}' to me!"
    }
    operator fun setValue(thisRef: Any?, prop: KProperty<*>, value: String) {
        println("$value has been assigned to ${prop.name} in $thisRef")
    }
}

class LazySample {
    init {
        println("created!")
    }

    val lazyStr: String by lazy {
        println("computed!")
        "my lazy"
    }
}

fun main() {
    /*
        Using delegated propertie -

        Kotlin provides a mechanism of `delegated properties` that allows
        delegating the calls of the property `set` and `get` methods to a
        certain object. The delegate object in this case should have the
        method `getValue`. For mutable properties, you'll also need `setValue`.
    */
    val e = Example()
    println(e.p)
    e.p = "NEW"

    /*
       Standard delegates
           - Property `lazy` is not initialized on object creation
           - First call to `get()` executes the lambda expression
           passed to `lazy()` as an argument and saves the result.
           - Further calls to `get()` return the saved result.
           - If you want thread safety, use `blockingLazy()` instead:
           it guarantees that the values will be computed only in one thread
           and that all threads will see the same value.
    */
    val sample = LazySample()
    println("lazyStr = ${sample.lazyStr}")
    println(" = ${sample.lazyStr}")

    /*
        Storing Properties in a Map
            Property delegation can be used for storing properties in a map.
            This is handy for tasks like parsing JSON or doing other "dynamic" stuff.
    */
    class User(val map: Map<String, Any?>) {
        val name: String by map
        val age: Int by map
    }

    val user = User(mapOf(
        "name" to "John Doe",
        "age" to 25
    ))

    println("name = ${user.name}, age = ${user.age}")
}
