/**
 * 地址:https://leetcode.com/problems/median-of-two-sorted-arrays/
 * 比较直接的方法, 复杂是log(m+n)
 */
public class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int small = 0;
        int big = nums1.length + nums2.length;

        int smallIndex1 = 0;
        int smallIndex2 = 0;
        int bigIndex1 = nums1.length - 1;
        int bigIndex2 = nums2.length - 1;

        while (small < big) {
            if (smallIndex1 < nums1.length && smallIndex2 < nums2.length) {
                if (nums1[smallIndex1] < nums2[smallIndex2]) {
                    small = nums1[smallIndex1];
                    smallIndex1++;
                } else {
                    small = nums2[smallIndex2];
                    smallIndex2++;
                }
            } else if (smallIndex2 < nums2.length) {
                small = nums2[smallIndex2];
                smallIndex2++;
            } else if (smallIndex1 < nums1.length) {
                small = nums1[smallIndex1];
                smallIndex1++;
            }

            if (bigIndex1 >= 0 && bigIndex2 >= 0) {
                if (nums1[bigIndex1] > nums2[bigIndex2]) {
                    big = nums1[bigIndex1];
                    bigIndex1--;
                } else {
                    big = nums2[bigIndex2];
                    bigIndex2--;
                }
            } else if (bigIndex2 >= 0) {
                big = nums2[bigIndex2];
                bigIndex2--;
            } else if (bigIndex1 >= 0) {
                big = nums1[bigIndex1];
                bigIndex1--;
            }
        }

        return (double)(small + big) / 2;
    }
}
