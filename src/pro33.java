public class pro33 {
    static public int search(int[] nums, int target) {
        if(nums.length==0) return -1;
        if(nums.length==1 && nums[0]==target) return 0;
        else if(nums.length==1 && nums[0]!=target) return -1;
        int minLoc = -1;
        int st=0;
        int ed=nums.length-1;
        while(st<ed){
            int mid = (st+ed)/2;
            if(nums[mid]>nums[mid+1]){
                minLoc=mid+1;
                break;
            }else if(nums[mid]>nums[st]){
                st=mid;
            }else
                ed=mid;
        }
        if(minLoc==-1) return binarySerach(0,nums.length-1,target,nums);
        if(target>=nums[0]) return binarySerach(0,minLoc-1,target,nums);
        else return binarySerach(minLoc,nums.length-1,target,nums);

    }
    static public int binarySerach(int st,int ed,int tar,int nums[]){
        while(st<=ed){
            int mid = (st+ed)/2;
            if(nums[mid]==tar) return mid;
            else if(nums[mid]>tar) ed=mid-1;
            else st=mid+1;
        }
        return -1;
    }
    static public void main(String argv[]){
        int nums[]={1,3};
        System.out.println(search(nums,2));
    }
}
