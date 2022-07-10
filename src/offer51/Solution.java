package offer51;

public class Solution {
    public int reversePairs(int[] nums) {
        int[] tmp = new int[nums.length];
        return mergeSort(0, nums.length - 1, tmp, nums);
    }

    public int mergeSort(int l, int r, int[] tmp, int[] nums) {
        if(l>=r) {
            return 0;
        }
        int mid = (l + r) / 2;
        int ans = mergeSort(l, mid, tmp, nums) + mergeSort(mid+ 1, r, tmp, nums);
        int i = l;
        int j = mid + 1;
        for(int index = l; index <= r; index++) {
            tmp[index] = nums[index];
        }
        for(int index = l; index <= r; index++) {
            if(i == mid + 1){
                nums[index] = tmp[j];
                j++;
            } else if(j == r + 1) {
                nums[index] = tmp[i];
                i++;
            } else if(tmp[i] <= tmp[j]) {
                nums[index] = tmp[i];
                i++;
            } else if(tmp[i] > tmp[j]){
                ans += mid - i + 1;
                nums[index] = tmp[j];
                j++;
            }
        }
        return ans;

    }
}
