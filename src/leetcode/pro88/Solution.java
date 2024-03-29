package leetcode.pro88;

public class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int l = nums1.length - 1;
        m--;
        n--;
        while(m >= 0 && n >= 0) {
            if(nums1[m] > nums2[n]) {
                nums1[l] = nums1[m];
                l--;
                m--;
            } else {
                nums1[l] = nums2[n];
                l--;
                n--;
            }
        }
        while(m >= 0) {
            nums1[l] = nums1[m];
            l--;
            m--;
        }
        while(n >= 0) {
            nums1[l] = nums2[n];
            l--;
            n--;
        }
    }
}
