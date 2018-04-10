import java.util.*

class Solution {
    fun isValid(s: String): Boolean {

        val stack = LinkedList<Char>()
        s.forEach {
            if (it == '(' || it == '[' || it == '{') {
                stack.addFirst(it)
            } else {
                if (stack.isEmpty()) return false

                val c = stack.pop()
                if (!((c == '(' && it == ')') || (c == '[' && it == ']') || (c == '{' && it == '}'))) {
                    return false
                }
            }
        }

        return stack.isEmpty()
    }
}