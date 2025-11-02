import kotlin.math.pow

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
fun main() {
    // Порівняння
    print("Введіть перше число: ")
    var firstNum = readln().toInt();
    print("Введіть друге число: ")
    var secondNum = readln().toInt();
    if (firstNum > secondNum) {
        println("Більше число: " + firstNum)
    } else{
        println("Більше число: " + secondNum)
    }

    // Ділення через операцію віднімання
    print("Введіть ділене: ")
    var dividend = readln().toInt();
    print("Введіть дільник: ")
    var divisor = readln().toInt();
    var quotient = 0;
    while (dividend >= divisor) {
        dividend = dividend - divisor;
        quotient++;
    }
    println("Частка: " + quotient);
    if(dividend != 0 ){
        println("Остача: " + dividend);
    }

    // множення через операцію додавання,
    print("Введіть перший множник: ")
    var firstMultiplier = readln().toInt();
    print("Введіть другий множник: ")
    var secondMultiplier = readln().toInt();
    var product = 0;
    for (i in 1..secondMultiplier) {
        product += firstMultiplier;
    }
    println("Добуток: " + product);

    // сума ряду
    print("Введіть верхню межу суми: ")
    var amountLimit = readln().toInt()
    var sum = 0.0;
    var factorial = 1.0
    for(i in 1..amountLimit) {
        factorial *= i
        sum += (3.0.pow(i.toDouble()) * factorial / i.toDouble().pow(i.toDouble()))
        println("Ітерація №" + i + ": " + sum)
    }
}