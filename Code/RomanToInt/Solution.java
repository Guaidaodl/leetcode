/**
 * Created by Guaidaodl on 1/4/16.
 */
public class Solution {
    public int romanToInt(String s) {
        int[] value =   {1000, 900,  500, 400,  100, 90,   50,  40,   10,  9,    5,   4,    1};
        String[] roman = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};

        int result = 0;
        int romanIndex = 0;
        int index = 0;
        while(index < s.length()) {
            if (s.startsWith(roman[romanIndex], index)) {
                result += value[romanIndex];
                index += roman[romanIndex].length();
            } else {
                romanIndex++;
            }
        }

        return result;
    }
}
