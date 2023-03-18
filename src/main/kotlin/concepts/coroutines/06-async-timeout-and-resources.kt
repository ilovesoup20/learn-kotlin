package concepts.coroutines

import kotlinx.coroutines.*

var acquired = 0

class Resource {
    init {
        acquired++
    } // Acquire resource

    fun close() {
        acquired--
    }  // Release resource
}

fun main() {
    runBlocking {
        repeat(100_000) {
            launch {
                val resource = withTimeout(60) {
                    delay(50)
                    Resource()
                }
                resource.close()
            }
        }
    }
    println(acquired)
}