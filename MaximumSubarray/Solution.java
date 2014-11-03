public class Solution {
    public int maxSubArray(int[] A) {
        if (A.length == 0)
            return 0;
        
        int lastSum = A[0];
        int max = A[0];
        for (int i = 1; i < A.length; i++) {
            int sum;
            if (lastSum < 0)
                sum = A[i];
            else 
                sum = A[i] + lastSum;
            
            if (sum > max)
                max = sum;
            lastSum = sum;
        }
        
        return max;
    }
}