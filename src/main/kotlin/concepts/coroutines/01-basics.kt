package concepts.coroutines

import kotlinx.coroutines.*

/*
    A coroutine is an instance of suspendable computation. It is conceptually similar to a
    thread, in the sense that it takes a block of code to run that works concurrently with
    the rest of the code. However, a coroutine is not bound to any particular thread. It may
    suspend its execution in one thread and resume in another one.

    Coroutines can be thought of as light-weight threads, but there is a number of important
    differences that make their real-life usage very different from threads.

    "launch" is a coroutine builder. It launches a new coroutine concurrently with the rest
    of the code, which continues to work independently.

    "delay" is a special suspending function. It suspends the coroutine for a specific time.
    Suspending a coroutine does not block the underlying thread, but allows other coroutines
    to run and use the underlying thread for their code.

    "runBlocking" is also a coroutine builder that bridges the noncoroutine world of a regular
    `fun main()` and the code with coroutines inside of `runBlocking { ... }` curly braces. This
    is highlighted in an IDE by `this: CoroutineScope` hint right after the `runBlocking` opening
    curly brace.

    Structured concurrency
        Coroutines follow a principle of "structured concurrency" which means that new coroutines
        can be only launched in a specific CoroutineScope which delimits the lifetime of the coroutine.
        The below example shows that `runBlocking` establishes the corresponding scope and that is
        why the previous example waits until "World!" is printed after a second's delay and only then
        exits.

        In a real application, you will be launching a lot of coroutines. Structured concurrency ensures
        that they are not lost and do not leak. An outer scope cannot complete until all its children
        coroutines complete. Structured concurrency also ensures that any errors in the code are
        properly reported and are never lost.
 */
fun main() {
    runBlocking { // this: CoroutineScope
        launch { // launch a new coroutine and continue
            delay(1000L) // non-blocking delay for 1 second (default time unit is ms)
            println("World!") // print after delay
            doWorld()
        }
        println("Hello") // main coroutine continues while a previous one is delayed

        delay(1500L)

        println("Hello again!")

        doWorld2()
        regularFunction()
    }
}

/*
    Suspending functions can be used inside coroutines just like regular functions, but
    their additional feature is that they can, in turn, use other suspending functions
    (like delay in this example) to suspend execution of a coroutine.
 */
suspend fun doWorld() {
    delay(1000L)
    println("World! (Suspend)")
}

fun regularFunction() {
    println("Don't suspend")
}

/*
    In addition to the coroutine scope provided by different builders, it is possible to
    declare your own scope using the coroutineScope builder. It creates a coroutine scope
    and does not complete until all launched children complete.

    `runBlocking` and `coroutineScope` builders may look similar because they both wait
    for their body and all its children to complete. The main difference is that the
    `runBlocking` method blocks the current thread for waiting, while `coroutineScope` just
    suspends, releasing the underlying thread for other usages. Because of that difference,
    `runBlocking` is a regular function and `coroutineScope` is a suspending function.

    You can use `coroutineScope` from any suspending function. For example, you can move the
    concurrent printing of 'Hello' and 'World' into a `suspend fun doWorld2()` function:
 */
suspend fun doWorld2() = coroutineScope {
    launch {
        delay(2000L)
        println("World 22")
    }
    println("Hello 22")
}

