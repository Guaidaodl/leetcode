public class Solution {
    public int lengthOfLongestSubstring(String s) {
        int max = 0;
        for (int i = 0; i <s.length(); i++) {
            boolean []exist = new boolean[128];
            for (int j = 0; j < 26; j++) {
                exist[j] = false;
            }
            int length = 0;
            for (int j = i; j < s.length(); j++) {
                if (exist[s.charAt(j)]) {
                    break;
                }
                length++;
                exist[s.charAt(j)] = true;
            }
            if (length > max)
                max = length;
        }

        return max;
    }
}
