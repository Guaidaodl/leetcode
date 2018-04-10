public class Solution {
    public String longestCommonPrefix(String[] strs) {
        if (strs.length == 0) return "";
        
        int length = 0;
        boolean hasDifferentChar = false;
        while (!hasDifferentChar) {
            if (length >= strs[0].length()) {
                break;
            }
            char commonChar = strs[0].charAt(length);
            for (int i = 1; i < strs.length; i++) {
                if (length >= strs[i].length() || strs[i].charAt(length) != commonChar) {
                    hasDifferentChar = true;
                    break;
                }
            }
            if (!hasDifferentChar) {
                length++;
            }
        }

        return strs[0].substring(0, length);
    }
}