import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class pro39 {
    List<List<Integer>> ans;
    List<Integer> list;
    int nums[];
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
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
        for(int i=loc;i<nums.length;i++){
            if(sum+nums[i]>target) break;
            else{
                list.add(nums[i]);
                dfs(i,list,target,sum+nums[i]);
                list.remove(list.size()-1);
            }
        }
    }
    static public void main(String argv[]){
        int nums[]={2,3,6,7};
        System.out.println(new pro39().combinationSum(nums,7));
    }
}
