import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class pro40 {
    List<List<Integer>> ans;
    List<Integer> list;
    int nums[];
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        ans = new ArrayList<>();
        nums=candidates;
        list=new ArrayList<>();
        dfs(0,list,target,0);
        return ans;
    }
    void dfs(int loc,List<Integer> list,int target,int sum){
        if(sum==target){
            ans.add(new ArrayList<>(list));
            return;
        }
        if(loc==nums.length)return;
        if(sum+nums[loc]>target) return;
        list.add(nums[loc]);

        dfs(loc+1,list,target,sum+nums[loc]);
        list.remove(list.size()-1);
        while(loc<nums.length-1 && nums[loc]==nums[loc+1]) loc++;
        loc++;
        dfs(loc,list,target,sum);
    }
    static public void main(String argv[]){
        int nums[]={10, 1, 2, 7, 6, 1, 5};
        System.out.println(new pro40().combinationSum2(nums,8));
    }
}
