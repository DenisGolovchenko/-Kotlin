// Порівняння чисел
fun maxNumber(firstNum: Int, secondNum: Int): Int {
    return if (firstNum > secondNum) firstNum else secondNum
}

// Ділення через віднімання
fun divide(dividend: Int, divisor: Int): Pair<Int, Int> {
    var quotient = 0
    var remainder = dividend
    while (remainder >= divisor) {
        remainder -= divisor
        quotient++
    }
    return Pair(quotient, remainder)
}

// Множення через додавання
fun multiply(firstMultiplier: Int, secondMultiplier: Int): Int {
    var product = 0
    for (i in 1..secondMultiplier) {
        product += firstMultiplier
    }
    return product
}

// Сума ряду без вбудованих степенів
fun seriesSum(amountLimit: Int): List<Double> {
    val sumList = mutableListOf<Double>()
    var sum = 0.0

    for (i in 1..amountLimit) {
        // Факторіал
        var factorial = 1.0
        for (j in 1..i) {
            factorial *= j
        }

        // 3^i вручну
        var power3 = 1.0
        for (k in 1..i) {
            power3 *= 3
        }

        // i^i вручну
        var powerI = 1.0
        for (k in 1..i) {
            powerI *= i
        }

        sum += power3 * factorial / powerI
        sumList.add(sum)
    }

    return sumList
}

fun main() {
    // Порівняння
    print("Введіть перше число: ")
    val firstNum = readln().toInt()
    print("Введіть друге число: ")
    val secondNum = readln().toInt()
    println("Більше число: ${maxNumber(firstNum, secondNum)}")

    // Ділення
    print("Введіть ділене: ")
    val dividend = readln().toInt()
    print("Введіть дільник: ")
    val divisor = readln().toInt()
    val (quotient, remainder) = divide(dividend, divisor)
    println("Частка: $quotient")
    if (remainder != 0) println("Остача: $remainder")

    // Множення
    print("Введіть перший множник: ")
    val firstMultiplier = readln().toInt()
    print("Введіть другий множник: ")
    val secondMultiplier = readln().toInt()
    println("Добуток: ${multiply(firstMultiplier, secondMultiplier)}")

    // Сума ряду
    print("Введіть верхню межу суми: ")
    val amountLimit = readln().toInt()
    val sumList = seriesSum(amountLimit)
    for ((i, value) in sumList.withIndex()) {
        println("Ітерація №${i + 1}: $value")
    }
}
