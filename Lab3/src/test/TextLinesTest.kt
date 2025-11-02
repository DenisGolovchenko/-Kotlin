package Application

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class TextLinesTest {

    @Test
    fun testTextLines() {
        val base = TextLines("Привіт світ")
        assertEquals("Привіт світ", base.getText())
        assertEquals(11, base.getLength())
        assertEquals(11, base.countSymbols())
    }

    @Test
    fun testSymbols() {
        val symbols = Symbols("А*Б*В*Г*")
        assertEquals("А*Б*В*Г*", symbols.getText())
        assertEquals(8, symbols.getLength())
        assertEquals(4, symbols.countSymbols())
    }

    @Test
    fun testUppercaseLetters() {
        val capitals = UppercaseLetters("Ведмідь, Вовк, Вишня, Вода, Вулиця, Вітер, Віз, Ведмедиця, Вежа, Ваза")
        assertEquals(
            "Ведмідь, Вовк, Вишня, Вода, Вулиця, Вітер, Віз, Ведмедиця, Вежа, Ваза",
            capitals.getText()
        )
        assertEquals(69, capitals.getLength())
        assertEquals(10, capitals.countSymbols())
    }
}
