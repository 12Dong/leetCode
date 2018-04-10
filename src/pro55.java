public class pro55 {
    public boolean canJump(int[] nums) {
        if(nums.length==1) return true;
        if(nums.length==0) return false;
        if(nums[0]==0) return false;
        int step = nums[0]-1;
        for(int i=1;i<nums.length;i++){
            if(i==nums.length-1) return true;
            if(nums[i]==0 && step==0) return false;
            if(nums[i]>step)  step = nums[i];
            step--;
        }
        return true;
    }
    static public void main(String argv[]){
        int nums[]={3,2,1,0,4};
        System.out.println(new pro55().canJump(nums));
    }
}
