package io.github.guaidaodl.leetcode;
/**
 * Created by Guaidaodl on 10/5/15;
 */
public class Solution {
    public String intToRoman(int num) {
        String roman = "";
        if (num / 1000 != 0) {
            int remain = num / 1000;
            roman  = roman + toRoman(remain, "", "", "M");
        }
        if (num / 100 != 0) {
            int remain = num % 1000 / 100;
            if (remain != 0) {
                roman = roman + toRoman(remain, "M", "D", "C");
            }
        }

        if (num / 10 != 0) {
            int remain = num % 100 / 10;
            if (remain != 0) {
                roman = roman + toRoman(remain, "C", "L", "X");
            }
        }

        int remain = num % 10;
        if (remain != 0) {
            roman = roman + toRoman(remain, "X", "V", "I");
        }

        return roman;
    }

    public String toRoman(int r, String ten, String five, String one) {
        switch(r) {
            case 1:
                return one;
            case 2:
                return one + one;
            case 3:
                return one + one + one;
            case 4:
                return one + five;
            case 5:
                return five;
            case 6:
                return five + one;
            case 7:
                return five + one + one;
            case 8:
                return five + one + one + one;
            case 9:
                return one +ten;
        }

        return "";
    }
}

