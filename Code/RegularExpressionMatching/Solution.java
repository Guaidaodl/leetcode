public class Solution {
    private int end = -1;
    public boolean isMatch(String s, String p) {
        end = -1;
        return match(s, 0, p, 0) && end == s.length() - 1;
    }

    public boolean match(String s, int start, String pattern, int pStart) {
        //整个表达式匹配
        if (pStart >= pattern.length()) {
            return true;
        }

        if (pStart + 1 < pattern.length() && pattern.charAt(pStart + 1) == '*') {
            int matchEnd = start;
            while(matchEnd < s.length() && match(s.charAt(matchEnd), pattern, pStart)) {
                end = matchEnd;
                matchEnd++;
            }
            for (int i = matchEnd; i >= start; i--) {
                if (match(s, i, pattern, pStart + 2)) {
                    return true;
                }
                end--;
            }
            return false;
        } else if (start >= s.length()) {
            return false;
        } else if (match(s.charAt(start), pattern, pStart)) {
            end = start;
            return match(s, start + 1, pattern, pStart + 1);
        }

        return false;
    }

    public boolean match(char c, String pattern, int index) {
        char p = pattern.charAt(index);
        if (p == '.') {
            return true;
        } else if (p == '*' && index >= 1) {
            return match(c, pattern, index - 1);
        } else {
            return c == p;
        }
    }

    public static void main(String []args) {
        Solution solution = new Solution();
        System.out.println(solution.isMatch("abca", ".*c") + " false 2");
        System.out.println(solution.isMatch("", "a") + " false -1");
        System.out.println(solution.isMatch("", ".*") + " true -1");
        System.out.println(solution.isMatch("a", "a.*") + " true 0");
        System.out.println(solution.isMatch("aabb", "c*a*bb") + " true 3");
    }
}

