package pro4;

public class Solution2 {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        return find(nums1, 0, nums2, 0, (int) Math.ceil(1.0 * (nums1.length + nums2.length) / 2));
    }

    public double find(int nums1[], int start1, int[] nums2, int start2, int k) {
        if(start1 == nums1.length) {
            if((nums1.length + nums2.length) % 2 == 0) {
                return 1.0 * (nums2[start2 + k - 1] + nums2[start2 + k]) / 2;
            } else {
                return nums2[start2 + k - 1];
            }
        } else if(start2 == nums2.length) {
            if((nums1.length + nums2.length) % 2 == 0) {
                return 1.0 * (nums1[start1 + k - 1] + nums1[start1 + k]) / 2;
            } else {
                return nums1[start1 + k - 1];
            }
        }

        if(k == 1) {
            if((nums1.length + nums2.length) % 2 == 0) {
                if(nums1[start1] <= nums2[start2]) {
                    int num1 = nums1[start1];
                    if(start1 + 1 == nums1.length) {
                        int num2 = nums2[start2];
                        return 1.0 * (num1 + num2) / 2;
                    } else {
                        return 1.0 * (num1 + Math.min(nums1[start1 + 1], nums2[start2])) / 2;
                    }
                } else {
                    int num1 = nums2[start2];
                    if(start2 + 1 == nums2.length) {
                        int num2 = nums1[start1];
                        return 1.0 * (num1 + num2) / 2;
                    } else {
                        return 1.0 * (num1 + Math.min(nums1[start1], nums2[start2 + 1])) / 2;
                    }
                }
            } else {
                return Math.min(nums1[start1], nums2[start2]);
            }
        }
        // todo 判断 k == 1
        int kk = k / 2;
        if((start1 + kk - 1) >= nums1.length && (start2 + kk - 1) >= nums2.length) {
            // 不可能出现
            return 0;
        } else if((start1 + kk - 1) >= nums1.length){
            if(nums1[nums1.length - 1] <= nums2[start2 + kk - 1]) {
                return find(nums1, nums1.length, nums2, start2, k - (nums1.length - start1));
            } else {
                return find(nums1, start1, nums2, start2 + kk, k - kk);
            }
        } else if((start2 + kk - 1) >= nums2.length) {
            if(nums1[start1 + kk - 1] <= nums2[nums2.length - 1]) {
                return find(nums1, start1 + kk, nums2, start2, k - kk);
            } else {
                return find(nums1, start1, nums2, nums2.length, k - (nums2.length - start2));
            }
        } else {
            if(nums1[start1 + kk - 1] <= nums2[start2 + kk - 1]) {
                return find(nums1, start1 + kk, nums2, start2, k - kk);
            } else {
                return find(nums1, start1, nums2, start2 + kk, k - kk);
            }
        }
    }

    public static void main(String[] argv) {
        System.out.println(new Solution2().findMedianSortedArrays2(new int[]{1,2,4,5,6,7}, new int[]{3}));
    }

    public double findMedianSortedArrays2(int[] nums1, int[] nums2) {
        int left = (nums1.length + nums2.length + 1) / 2;
        int right = (nums1.length + nums2.length + 2) / 2;
        return (find2(nums1, 0, nums2, 0, left) + find2(nums1, 0, nums2, 0, right)) * 0.5;
    }

    public double find2(int[] nums1, int start1, int[] nums2, int start2, int k) {
        int len1 = nums1.length - start1;
        int len2 = nums2.length - start2;
        if(len1 > len2) {
            return find2(nums2,start2, nums1, start1, k);
        }
        if(len1 == 0) return nums2[start2 + k - 1];
        if(k == 1) {
            return Math.min(nums1[start1], nums2[start2]);
        }
        int kk = k / 2;
        int next1 = Math.min(start1 + kk - 1, nums1.length - 1);
        int next2 = Math.min(start2 + kk - 1, nums2.length - 1);
        if(nums1[next1] <= nums2[next2]) {
            return find2(nums1, next1 + 1, nums2, start2, k - (next1 - start1 + 1));
        } else {
            return find2(nums1, start1, nums2, next2 + 1, k - (next2 - start2 + 1));
        }
    }
}
