import java.io.File
import java.io.FileNotFoundException
import java.io.IOException

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
fun main() {
    println("Введіть текст:")
    var text = readln();
    var result = ""
    var count = 0

    for (i in text) {
        if (i == 'і') {
            result = result + "1"
            count++
        } else {
            result += i
        }
    }
    println("Результат: " + result)
    println("Кількість замін: "+ count)

    try {
        val text = File("D:\\NAU\\Kotlin\\Lab2\\src\\input.txt").readText()
        println("Вміст файлу:")
        println(text)

        val regex = Regex("(П[=а-яЇїІіЄєҐґ]+):\\s*(\\d+)")
        val map = mutableMapOf<String, String>()

        for (match in regex.findAll(text)) {
            val surname = match.groupValues[1] // прізвище
            val phone = match.groupValues[2]   // номер
            map[surname] = phone
        }
        println(map)

        File("D:\\NAU\\Kotlin\\Lab2\\src\\output.txt").writeText(map.toString())

    } catch (e: FileNotFoundException) {
        println("Помилка: файл не знайдено! ${e.message}")
    } catch (e: IOException) {
        println("Помилка вводу/виводу: ${e.message}")
    } catch (e: Exception) {
        println("Сталася невідома помилка: ${e.message}")
    }
}