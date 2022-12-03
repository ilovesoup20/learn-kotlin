package learnbyexamples

/*
    Kotlin easily supports implementation of delegation pattern on the
    native level without any boilerplate code.
*/

interface SoundBehavior {
    fun makeSound()
}

class ScreamBehavior(val n: String) : SoundBehavior {
    override fun makeSound() = println("${n.uppercase()} !!!")
}

class RockAndRollBehavior(val n: String) : SoundBehavior {
    override fun makeSound() = println("I'm the king of rock n roll: $n")
}

class TomAraya(n: String) : SoundBehavior by ScreamBehavior(n)

class ElvisPresley(n: String) : SoundBehavior by RockAndRollBehavior(n)

fun main() {
    val tomAraya = TomAraya("Thrash Metal")
    tomAraya.makeSound()

    val elvisPresley = ElvisPresley("Dancin' to the Jailhouse Rock.")
    elvisPresley.makeSound()
}
