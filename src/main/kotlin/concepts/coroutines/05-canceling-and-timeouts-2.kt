package concepts.coroutines

import kotlinx.coroutines.*

fun main() {
    /*
        Run non-cancellable block

        Any attempt to use a suspending function in the `finally` block causes `CancellationException`,
        because the coroutine running this code is cancelled. Usually this is not a problem since all
        well-behaving closing operations (closing a file, cancelling a job, or closing any kind of
        communication channel) are usually non-blocking and do not involve any suspending functions.
        However, in the rare case when you need to suspend in a cancelled coroutine you can wrap the
        corresponding code in `withContext(NonCancellable { ... }` using `withContext` function and
        `NonCancellable` context.
     */
    runBlocking {
        val job = launch {
            try {
                repeat(1000) { i ->
                    println("job: I'm sleeping $i ...")
                    delay(500L)
                }
            } finally {
                withContext(NonCancellable) {
                    println("job: I'm running finally")
                    delay(1000L)
                    println("job: And I've just delayed for 1 sec because I'm non-cancellable")
                }
            }
        }
        delay(1300L)
        println("main: I'm tired of waiting!")
        job.cancelAndJoin()
        println("main: Now I can quit.")
    }

    /*
        Timeout

        The most obvious practical reason to cancel execution of a coroutine is because its execution
        time has exceeded some timeout. While you can manually track the reference to the corresponding
        Job and launch a separate coroutine to cancel the tracked one after delay, there is a ready to
        use `withTimeout` function that does it.

        The `TimeoutCancellationException` that is thrown by `withTimeout` is a subclass of
        `CancellationException`. We have not seen its stack trace printed on the console before.
        That is because inside a cancelled coroutine `CancellationException` is considered to be a
        normal reason for coroutine completion. However, in below example we have used `withTimeout`
        right inside the `main` function
     */
    runBlocking {
        try {
            withTimeout(1300L) {
                repeat(1000) { i ->
                    println("I'm sleeping $i")
                    delay(500L)
                }
            }

        } catch (e: TimeoutCancellationException) {
            print(e)
        }
    }

    /*
        Since cancellation is just an exception, all resources are closed in the usual way. You can wrap
        the code with timeout in a `try { ... } catch (e: TimeoutCancellationException) { ... }` block if
        you need to do some additional action specifically on any kind of timeout or use the `withTimoutOrNull`
        function that is similar to `withTimeout` but returns `null` on timeout instead of throwing an exception.
     */
    runBlocking {
        val result = withTimeoutOrNull(1300L) {
            repeat(1000) { i ->
                println("I'm sleeping $i ...")
                delay(500L)
            }
            "done"// will get cancelled before it reaches here
        }
        println("Result is $result")
    }
}