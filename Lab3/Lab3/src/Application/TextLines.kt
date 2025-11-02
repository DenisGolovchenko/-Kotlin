package Application

open class TextLines(private var text: String) {
    fun getLength(): Int {
        return text.length
    }

    open fun countSymbols(): Int {
        return text.length
    }

    fun getText(): String {
        return text
    }
}