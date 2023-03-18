package concepts.coroutines

import kotlinx.coroutines.*


fun main() {
    /*
        Coroutines can be cancelled.
    */
    runBlocking {
        val job = launch {
            repeat(1000) { i ->
                println("job: I'm sleeping $i ...")
                delay(500L)
            }
        }

        delay(1300L)
        println("main: I'm tired of waiting!")
        job.cancel() // cancel job
        job.join() // wait for job to finish

        // Can use `cancel` and `join` in single statement
//        job.cancelAndJoin()
        println("main: Now I can quit.")
    }
    println("\n\n")
    /*
        Cancellation is cooperative. A coroutine has to be cooperative to be cancellable.
        All the suspending functions in `kotlinx.coroutines` are cancellable. They check
        for cancellation of coroutine and throw `CancellationException` when cancelled.
        However, it a coroutine is working in a computation and does not check for
        cancellation, then it cannot be cancelled, like the following example:
     */
    runBlocking {
        val startTime = System.currentTimeMillis()
        val job = launch(Dispatchers.Default) {
            var nextPrintTime = startTime
            var i = 0
            while (i < 5) {
                if (System.currentTimeMillis() >= nextPrintTime) {
                    println("job: I'm sleeping ${i++} ...")
                    nextPrintTime += 500L
                }
            }
        }
        delay(1300L)
        println("main: I'm tired of waiting")
        job.cancelAndJoin()
        println("main: Now I can quit.")
    }
    println("\n\n")

    /*
        The same problem can be observed by catching a `CancellationException` and not
        rethrowing it. While catching `Exception` is an anti-pattern, this issue may surface
        in more subtle ways, like when using the `runCatching` function, which does not rethrow
        `CancellationException`.
     */
    runBlocking {
        val job = launch(Dispatchers.Default) {
            repeat(5) { i ->
                try {
                    println("job: I'm sleeping $i ...")
                    delay(500)
                } catch (e: Exception) {
                    println(e)
                }
            }
        }
        delay(1300L)
        println("main: I'm tired of waiting!")
        job.cancelAndJoin()
        println("main: Now I can quit.")
    }
    println("\n\n")
    /*
        Making computation code cancellable.

        There are two ways to make computation code cancellable. The first one is to periodically
        invoke a suspending function that checks for cancellation. There is a `yield` function
        that is a good choice for that purpose. The other one is to explicitly check the cancellation
        status. Below example is the latter approach.

        `isActive` is an extension property available inside the coroutine via the `CoroutineScope`
        object.
     */
    runBlocking {
        val startTime = System.currentTimeMillis()
        val job = launch(Dispatchers.Default) {
            var nextPrintTime = startTime
            var i = 0
            while (isActive) { // cancellation computation loop
                if (System.currentTimeMillis() >= nextPrintTime) {
                    println("job: I'm sleeping ${i++} ...")
                    nextPrintTime += 500L
                }
            }
        }
        delay(1300L)
        println("main: I'm tired of waiting!")
        job.cancelAndJoin()
        println("main: Now I can quit.")
    }
    println("\n\n")

    /*
        Closing resources with finally

        Cancellable suspending functions throw `CancellationException` on cancellation, which
        can be handled in the usual way. For example, the `try { ... } finally { ... }` expression
        and Kotlin's `use` function execute their finalization actions normally when a coroutine is
        cancelled.

        Both `join()` and `cancelAndJoin()` wait for all finalization actions to complete.
     */
    runBlocking {
        val job = launch {
            try {
                repeat(1000) { i ->
                    println("job: I'm sleeping $i ...")
                    delay(500L)
                }
            } finally {
                println("job: I'm running finally")
            }
        }
        delay(1300L)
        println("main: I'm tired of waiting!")
        job.cancelAndJoin()
        println("main: Now I can quit.")
    }
}