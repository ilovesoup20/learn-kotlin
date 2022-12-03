package learnbyexamples

/*
    Kotlin supports passing arguments to methods and constructors according
    to the order they are defined. Kotlin also supports named arguments to
    allow clearer invocations and avoid mistakes with the order of arguments.

*/
fun format(userName: String, domain: String) = "$userName@$domain"

fun main() {
    println(format("mario", "example.com")) // 1
    println(format("domain.com", "username")) // 2
    println(format(userName = "foo", domain = "bar.com")) // 3
    println(format(domain = "frog.com", userName = "pepe")) // 4
}
