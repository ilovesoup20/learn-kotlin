package learnbyexamples

fun main() {
    var neverNull: String = "This can't be null"

    // Cannot assign null to non-nullable variable
    // neverNull = null

    var nullable: String? = "You can use null here"
    nullable = null

    var inferredNonNull = "The compile assumes non-null"
    // Cannot assign null because the variable is assumed to be non-nullable by the compiler
    // inferredNonNull = null

    println(strLength(neverNull))

    // Not possible since function requires non-null string parameter
    // println(strLength(nullable))

    println(strLength(inferredNonNull))

    println(nullable)
}

fun strLength(notNull: String): Int {
    return notNull.length
}

fun describeString(maybeString: String?): String {
    if (maybeString != null && maybeString.length > 0) {
        return "String of length ${maybeString.length}"
    } else {
        return "Empty or null string"
    }
}
