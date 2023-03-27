package pro581;

import java.util.Arrays;
import java.util.Stack;

public class Solution {

    public int findUnsortedSubarray(int[] nums) {
        int targetMaxL = -1;
        int max = Integer.MIN_VALUE;
        int targetMinL = -1;
        int min = Integer.MAX_VALUE;
        for(int i = 0; i < nums.length; i++) {
            if(nums[i] >= max) {
                max = nums[i];
            } else {
                targetMaxL = i;
            }
        }

        for(int i = nums.length - 1; i >= 0; i--) {
            if(nums[i] <= min) {
                min = nums[i];
            } else {
                targetMinL = i;
            }
        }
        return targetMaxL == -1 ? 0 : targetMaxL - targetMinL + 1;
    }

    public int findUnsortedSubarray3(int[] nums) {
        Stack<Integer> up = new Stack<>();
        int[] upDp = new int[nums.length];
        Arrays.fill(upDp, -1);
        for(int i = 0; i < nums.length; i++) {
            if(up.isEmpty()) {
                up.add(i);
            } else {
                if(nums[i] > nums[up.peek()]) {
                    up.add(i);
                } else {
                    while(!up.isEmpty() && nums[up.peek()] > nums[i]) {
                        upDp[up.pop()] = i;
                    }
                    up.add(i);
                }
            }
        }
        int start = -1;
        for(int i =0; i < upDp.length;i++) {
            if(start == -1 && upDp[i] != -1) {
                start = i;
                break;
            }
        }

        Stack<Integer> down = new Stack<>();
        int[] downDp = new int[nums.length];
        Arrays.fill(downDp, -1);
        for(int i = nums.length - 1; i >=0; i--) {
            if(down.isEmpty()) {
                down.add(i);
            } else {
                if(nums[i] < nums[down.peek()]) {
                    down.add(i);
                } else {
                    while(!down.isEmpty() && nums[down.peek()] < nums[i]) {
                        downDp[down.pop()] = i;
                    }
                    down.add(i);
                }
            }
        }
        int end = -1;
        for(int i = downDp.length - 1; i >= 0; i--) {
            if(end == -1 && downDp[i] != -1) {
                end = i;
                break;
            }
        }
        return start == -1 ? 0 : end - start + 1;
    }

    public int findUnsortedSubarray2(int[] nums) {
        int[] n = Arrays.copyOf(nums, nums.length);
        Arrays.sort(n);
        int start = -1;
        int end = -1;
        for(int i = 0; i < nums.length; i++) {
            if(nums[i] != n[i]) {
                if(start == -1) {
                    start = i;
                }
                end = i;
            }
        }
        return start == 0 ? 0 : end - start + 1;
    }

    public static void main(String[] argv) {
        new Solution().findUnsortedSubarray(new int[]{2,1});
    }
}
