package concepts.coroutines

import kotlinx.coroutines.*

/*
    A coroutineScope builder can be used inside any suspending function to perform
    multiple concurrent operations. Let's launch two concurrent coroutines inside
    a `doWorld` suspending function.

    Both pieces of code inside `launch { ... }` blocks execute concurrently, with
    "World 1" printed first then "World 2" printed next. A coroutineScope in `doWorld`
    completes only after both are complete, so `doWorld` returns and allows `Done`
    string to be printed only after that.
 */
fun main() {
    runBlocking {
        doWorld3()
        println("Done")
        launch {
            println("launch 1")
        }
        launch {
            println("launch 2")
        }
    }
}

// Launching two concurrent coroutines
suspend fun doWorld3() = coroutineScope {
    launch {
        delay(2000L)
        println("World 2")
    }
    launch {
        delay(1000L)
        println("World 1")
    }
    println("Hello")
}