package leetcode.pro845;

public class Solution {
    public int longestMountain(int[] arr) {
        int ans = 0;
        int up = 0;
        int down = 0;
        for(int i = 1; i < arr.length; i++) {
            if(arr[i] > arr[i - 1]) {
                if(down != 0) {
                    ans = Math.max(ans, up + down);
                    up = 0;
                    down = 0;
                }
                up++;
            } else if(arr[i] == arr[i - 1]){
                up = 0;
                down = 0;
            } else {
                if(up != 0) {
                    down ++;
                    ans = Math.max(ans, up + down);
                }
            }
        }
        if(up != 0 && down != 0) {
            ans = Math.max(ans, up + down);
        }
        return ans == 0 ? ans : ans + 1;
    }

    public static void main(String[]  argv) {
        System.out.println(new Solution().longestMountain(new int[]{2,1,4,3,2,2,2,5}));
        System.out.println(new Solution().longestMountain(new int[]{1,1,1}));
    }
}
