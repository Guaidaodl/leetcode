public class Solution {
    public int climbStairs(int n) {
        if (n == 0)
            return 0;
        if (n == 1)
            return 1;
        if (n == 2)
            return 2;

        int l1 = 1;
        int l2 = 2;
        int i = 3;
        int stepNum = 0;
        while(i <= n) {
            stepNum = l1 + l2;
            l1 = l2;
            l2 = stepNum;
            i++;
        }

        return stepNum;
    }
}