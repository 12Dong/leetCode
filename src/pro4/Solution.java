package pro4;

public class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int n = nums1.length;
        int m = nums2.length;
        if(n > m) {
            return findMedianSortedArrays(nums2, nums1);
        }
        Integer lMax1 = null;
        Integer rMin1 = null;
        Integer lMax2 = null;
        Integer rMin2 = null;
        int c1, c2;
        int lo = 0;
        int hi = 2 * n;
        while(lo <= hi) {
            c1 = (lo + hi) / 2;
            c2 = m + n - c1;
            lMax1 = (c1 == 0) ? Integer.MIN_VALUE : nums1[(c1 - 1) / 2];
            rMin1 = (c1 == 2 *n) ? Integer.MAX_VALUE : nums1[(c1 / 2)];
            lMax2 = (c2 == 0) ? Integer.MIN_VALUE : nums2[(c2 - 1) / 2];
            rMin2 = (c2 == 2 *m) ? Integer.MAX_VALUE : nums2[c2/2];
            if(lMax1 > rMin2) {
                hi = c1 - 1;
            } else if(lMax2 > rMin1){
                lo = c1 + 1;
            } else {
                break;
            }
        }
        return (Integer.max(lMax1, lMax2) + Integer.min(rMin1, rMin2)) / 2.0;
    }
}
