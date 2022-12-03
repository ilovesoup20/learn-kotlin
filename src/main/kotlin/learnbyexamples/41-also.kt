package learnbyexamples

/*
    `also` works like `apply`: it executes a given block and returns the object
    called. Inside the block, the object is referenced by `it`, so it's easier
    to pass it as an argument. This function is handy for embedding additional
    actions, such as logging in call chains.
*/
data class Person4(var name: String, var age: Int, var about: String) {
    constructor() : this("", 0, "")
}

fun writeCreationLog(p: Person4) {
    println("A new person ${p.name} was created.")
}

fun main() {
    val jake =
            Person4("Jake", 30, "Android developer") // 1
                    .also { // 2
                        writeCreationLog(it) // 3
                    }

    println(jake)
}
