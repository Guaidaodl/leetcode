import java.util.Arrays;

public class Solution {
    private class IndexValuePair implements Comparable<IndexValuePair> {
        IndexValuePair(int num, int index) {
            this.num = num;
            this.index =index;
        }
        int num;
        int index;

        @Override
        public int compareTo(IndexValuePair o) {
            if (o.num < num) {
                return 1;
            } else if (o.num == num) {
                return 0;
            } else  {
                return -1;
            }

        }
    }
    public int[] twoSum(int[] nums, int target) {
        IndexValuePair []pairs = new IndexValuePair[nums.length];
        for (int i = 0; i < nums.length; i++) {
            pairs[i] = new IndexValuePair(nums[i], i + 1);
        }

        Arrays.sort(pairs);

        int beginIndex = 0;
        int small = pairs[beginIndex].num;
        int endIndex = pairs.length - 1;
        int big = pairs[endIndex].num;

        int sum = big + small;
        while(sum != target) {
            if (sum > target) {
                big = pairs[--endIndex].num;
            } else {
                small = pairs[++beginIndex].num;
            }

            sum = big + small;
        }

        int smallIndex = Math.min(pairs[beginIndex].index, pairs[endIndex].index);
        int bigIndex = Math.max(pairs[beginIndex].index, pairs[endIndex].index);

        return new int[]{smallIndex, bigIndex};
    }

}
