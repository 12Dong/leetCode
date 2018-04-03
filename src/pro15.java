import java.util.*;

public class pro15 {
    static public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> s  = new ArrayList<>();
        Arrays.sort(nums);
        for(int i=0;i<nums.length-2;i++){
            if(nums[i]>0) break;
            if(i>0 && nums[i]==nums[i-1]) continue;
            int target = - nums[i];
            int st=i+1;
            int ed=nums.length-1;
            while(st<ed){
                int sum=nums[st]+nums[ed];
                if(sum==target){
                    List<Integer> v = new ArrayList<>();
                    v.add(nums[i]);
                    v.add(nums[st]);
                    v.add(nums[ed]);
                    s.add(v);
                    st++;
                    ed--;
                    while(st<ed && nums[st]==nums[st-1]) st++;
                    while(st<ed && nums[ed]==nums[ed+1]) ed--;
                }
                else{
                    if(sum<target){
                        st++;
                    }
                    else{
                        ed--;
                    }
                }
            }
        }

        return s;
    }
    static public void main(String argv[]){
        int nums[] = {-1, 0, 1, 2, -1, -4};
        List<List<Integer>> list = threeSum(nums);
        for(List<Integer> l:list){
            System.out.println(l);
        }
    }
}
