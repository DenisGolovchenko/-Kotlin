package Application
fun main() {
    val text = TextLines("Привіт світ")
    val symbols = Symbols("А*Б*В*Г*")
    val uppercaseLetters = UppercaseLetters("Ведмідь, Вовк, Вишня, Вода, Вулиця, Вітер, Віз, Ведмедиця, Вежа, Ваза")

    println("Текст: " + text.getText())
    println("Загальна кількість символів: " + text.countSymbols() + "\n")

    println("Текст: " + symbols.getText())
    println("Довжина тексту: " + symbols.getLength())
    println("Кількість '*': " + symbols.countSymbols() + "\n")

    println("Текст: " + uppercaseLetters.getText())
    println("Довжина тексту: " + uppercaseLetters.getLength())
    println("Кількість 'B': " + uppercaseLetters.countSymbols())
}
