class Solution {
    private val letterMap: Map<Int, CharArray> = mapOf(
            Pair(2, charArrayOf('a', 'b', 'c')),
            Pair(3, charArrayOf('d', 'e', 'f')),
            Pair(4, charArrayOf('g', 'h', 'i')),
            Pair(5, charArrayOf('j', 'k', 'l')),
            Pair(6, charArrayOf('m', 'n', 'o')),
            Pair(7, charArrayOf('p', 'q', 'r', 's')),
            Pair(8, charArrayOf('t', 'u', 'v')),
            Pair(9, charArrayOf('w', 'x', 'y', 'z'))
    )
    fun letterCombinations(digits: String): List<String> {
        val charArrays = digits.filter { it in '2' .. '9' }
                               .map { letterMap[it - '0']!! }

        val r = merge(charArrays)

        return r.map { String(it.toCharArray()) }
    }

    private fun merge(charArrays: List<CharArray>): List<List<Char>> {
        if (charArrays.isEmpty()) {
            return ArrayList()
        }

        val initial: List<List<Char>> = ArrayList()
        return charArrays.fold(initial) { acc, chars ->
            if (acc.isEmpty()) {
                chars.map { listOf(it) }
            } else {
                acc.flatMap { list -> chars.map { list.plus(it) } }
            }
        }
    }
}