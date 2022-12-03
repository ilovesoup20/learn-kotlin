package learnbyexamples

import java.time.LocalDate
import java.time.chrono.ChronoLocalDate

/*
    Kotlin compiler is smart enough to perform type casts automatically
    including:
        - Casts from nullable types to their non-nullable counterparts.
        - Casts from a supertype to a subtype.
*/
fun main() {
    val date: ChronoLocalDate? = LocalDate.now()

    if (date != null) {
        println(date.isLeapYear)
    }

    if (date != null && date.isLeapYear) {
        println("It's a leap year!")
    }

    if (date == null || !date.isLeapYear) {
        println("There's no Feb 29 this year..")
    }

    if (date is LocalDate) {
        val month = date.monthValue
        println(month)
    }
}
