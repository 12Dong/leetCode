import java.util.Arrays;
import java.util.List;

public class pro1 {
    static public void main(String argv[]){
        Solution solution = new Solution();
        int [] nums={-1,-2,-3,-4,-5};
        int target=-8;
        int ans[] = Solution.twoSum(nums,target);
        System.out.println(ans[0]+" "+ans[1]);
    }
}
class Solution {
    public int[] twoSum(int[] nums, int target) {
            int length = nums.length;
            int newnum[] = new int[length];
            for(int i=0;i<length;i++){
                newnum[i]=nums[i];
            }
            int ans[] = new int[2];
            Arrays.sort(nums);
            int st=0;
            int ed=nums.length-1;
            int ans1,ans2;
            while(true){
                if(nums[st]+nums[ed]>target) ed--;
                else if(nums[st]+nums[ed]<target)st++;
                else{
                    ans1=st;
                    ans2=ed;
                    break;
                }
            }
    //        System.out.println(Arrays.toString(newnum));
    //        System.out.println(Arrays.toString(nums));
    //        System.out.println(nums[st]+"  "+nums[ed]);
            for(int i=0;i<length;i++){
                if(newnum[i]==nums[st]){
                    ans[0]=i;
                    break;
                }
            }
            for(int i=0;i<length;i++){
                if(newnum[i]==nums[ed] && i!=ans[0]){
                    ans[1]=i;
                    break;
                }
            }
            return ans;
    }
}