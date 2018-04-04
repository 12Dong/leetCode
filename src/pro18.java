import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class pro18 {
    static public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> list = new ArrayList<>();
        if(nums==null || nums.length<4) return list;
        Arrays.sort(nums);
        for(int i=0;i<nums.length;i++){
            if(i>0 && nums[i]==nums[i-1]) continue;
            for(int j=nums.length-1;j>i;j--){
                if(j<nums.length-1 && nums[j]==nums[j+1]) continue;
                int tar = target-nums[i]-nums[j];
                int st=i+1;
                int ed=j-1;
                while(st<ed){
                    if(nums[st]+nums[ed]==tar){
                        List<Integer> l = new ArrayList<>();
                        l.add(nums[i]);
                        l.add(nums[st]);
                        l.add(nums[ed]);
                        l.add(nums[j]);
                        list.add(l);
                        do{
                            st++;
                        }while(st<nums.length-1 && nums[st]==nums[st-1]);
                        do{
                            ed--;
                        }while(ed>0 && nums[ed]==nums[ed+1]);
                    }else if(nums[st]+nums[ed]<tar) st++;
                    else ed--;
                }
            }
        }
        return list;
    }
    static public void main(String argv[]){
        int nums[] = {1, 0, -1, 0, -2, 2};
        List<List<Integer>> list = fourSum(nums,0);
        for(List<Integer> l:list){
            System.out.println(l);
        }
    }
}
