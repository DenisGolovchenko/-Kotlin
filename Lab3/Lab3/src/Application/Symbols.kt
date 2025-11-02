package Application

class Symbols(text: String) : TextLines(text) {
    override fun countSymbols(): Int {
        val text = getText()
        var count = 0
        for (i in 0 until text.length) {
            if (text[i] == '*') {
                count++
            }
        }
        return count
    }
}