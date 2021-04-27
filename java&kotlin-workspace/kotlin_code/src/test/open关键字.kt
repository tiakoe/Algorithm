package test


open class Person {
    open fun eat(food: String) {
        print("hello world")
    }

}

open class Man : Person() {
    override fun eat(food: String) {
        super.eat(food)
    }
}

fun main() {
   Man().eat("he")
}