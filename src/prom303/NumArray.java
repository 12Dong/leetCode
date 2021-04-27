package prom303;

public class NumArray {

    private int[] sum;

    public NumArray(int[] nums) {
        sum = new int[nums.length];
        for(int i = 0; i < nums.length; i++){
            if(i == 0) {
                sum[i] = nums[i];
            } else {
                sum[i] = sum[i-1] + nums[i];
            }
        }
    }

    public int sumRange(int left, int right) {
        if(left == 0) {
            return sum[right];
        } else {
            return sum[right] - sum[left - 1];
        }
    }
}
