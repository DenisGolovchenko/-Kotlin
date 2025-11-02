import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class MathFunctionsTest {

    @Test
    fun testMaxNumber() {
        assertEquals(10, maxNumber(10, 5))
        assertEquals(7, maxNumber(7, 7))
        assertEquals(12, maxNumber(3, 12))
    }

    @Test
    fun testDivide() {
        val result1 = divide(10, 3)
        assertEquals(3, result1.first)
        assertEquals(1, result1.second)

        val result2 = divide(8, 2)
        assertEquals(4, result2.first)
        assertEquals(0, result2.second)
    }

    @Test
    fun testMultiply() {
        assertEquals(20, multiply(4, 5))
        assertEquals(0, multiply(0, 5))
        assertEquals(0, multiply(5, 0))
    }

    @Test
    fun testSeriesSum() {
        val result = seriesSum(3)
        assertEquals(3, result.size)
        assertTrue(result[0] > 0)
        assertTrue(result[1] > result[0])
        assertTrue(result[2] > result[1])
    }
}
