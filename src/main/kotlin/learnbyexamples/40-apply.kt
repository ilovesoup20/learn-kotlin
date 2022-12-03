package learnbyexamples

/*
    `apply` executes a block of code on an object and returns the object
    itself. Inside the block, the object is referenced by `this`. This
    function is handy for initializing objects.
*/

data class Person3(var name: String, var age: Int, var about: String) {
    constructor() : this("", 0, "")
}

fun main() {
    val jake = Person3()
    val stringDescription =
            jake
                    .apply {
                        name = "Jake"
                        age = 30
                        about = "Android developer"
                    }
                    .toString()
    println(stringDescription)

    jake.apply {
        name = "Jake 2"
        age = 31
        about = "Android developer"
    }
    println(jake)
}
