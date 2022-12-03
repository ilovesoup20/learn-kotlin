/*
    Kotlin uses '==' for structural comparison and '===' for referential comparison

    More precisely, 'a == b' compiles down to 'if(a == null) b == null else a.equals(b)'
*/

fun main() {
    val authors = setOf("shakespeare", "hemingway", "twain")
    val writers = setOf("twain", "shakespeare", "hemingway")

    println(authors == writers)
    println(authors === writers)
}
