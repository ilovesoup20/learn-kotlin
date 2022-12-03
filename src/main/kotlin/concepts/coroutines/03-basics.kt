package concepts.coroutines

import kotlinx.coroutines.*

/*
    A launch coroutine builder returns a Job object that is a handle to the launched
    coroutine and can be used to explicitly wait for its completion. For example, you
    can wait for completion of the child coroutine and then print "Done" string.
 */
fun main() {
    runBlocking {
        val job = launch {
            delay(1000L)
            println("World!")
        }

        println("Hello")
        job.join()  // wait until child coroutine completes
        println("Done")
    }

    // You can have multiple `runBlocking` blocks
    runBlocking {
        launch {
            delay(1000L)
            println("World again!")
        }
        println("hello again!")
    }

    /*
        Coroutines are less resource-intensive than JVM threads. Code that exhausts the JVM's
        available memory when using threads can be expressed using coroutines without hitting
        resource limits.

        If you write the same program using threads (remove `runBlocking`, replace `launch` with
        `thread`, and replace `delay` with `Thread.sleep`), it will likely consume too much memory
        and throw an out-of-memory error.
     */
    runBlocking {
        repeat(100_000) {
            launch {
                delay(2000L)
                print(".")
            }
        }
    }
}