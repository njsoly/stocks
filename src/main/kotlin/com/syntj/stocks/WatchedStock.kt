package com.syntj.stocks

/** An enumeration of some known stock symbols. */
@Suppress("unused")
enum class WatchedStock(val longName: String) {

    DBX("Dropbox"),
    GNUS("Genius Brands"),
    MSFT("Microsoft"),
    MMM("3M");

    /** Safe alternative to [valueOf].  Returns `null` if no enum entries match [longName]. */
    fun getByLongName(longName: String) : WatchedStock? {
        WatchedStock.values().toList().forEach {
            if (it.longName.equals(longName, ignoreCase = true)) {
                return it
            }
        }
        return null
    }
}
