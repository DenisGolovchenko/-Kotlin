package Application

class UppercaseLetters(text: String) : TextLines(text) {
    override fun countSymbols(): Int {
        val text = getText()
        var count = 0
        for (i in 0 until text.length) {
            if (text[i] == 'В') {
                count++
            }
        }
        return count
    }
}