import java.util.Arrays;
import java.util.HashMap;

public class pro16 {
        static public int threeSumClosest(int[] nums, int target) {
            Arrays.sort(nums);
            int ans=Integer.MAX_VALUE;
            int ansDIF = Integer.MAX_VALUE;
            for (int i = 0; i < nums.length; i++) {
                int tar = target - nums[i];
                int st = i + 1;
                int ed = nums.length - 1;
                while (st < ed) {
                    if(ansDIF>Math.abs(target-nums[i]-nums[st]-nums[ed])){
                        ansDIF = Math.abs(target-nums[i]-nums[st]-nums[ed]);
                        ans = nums[i]+nums[st]+nums[ed];
                    }
                    if (nums[st] + nums[ed] < tar) st++;
                    else if (nums[st] + nums[ed] > tar) ed--;
                    else return target;
                }
            }
            return ans;
        }
    static public void main(String argv[]){
          int nums[] = {-1,2,1,-4};
          int tar=1;
          System.out.println(threeSumClosest(nums,1));
    }
}
