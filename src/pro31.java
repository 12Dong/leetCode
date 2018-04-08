public class pro31 {
    static public void nextPermutation(int[] nums) {
        int len = nums.length;
        int loc=-1;
        for(int i=len-1;i>=1;i--){
            if(nums[i]>nums[i-1]){
                loc=i-1;
                break;
            }
        }
        int ans[] = new int[len];
        if(loc==-1){
            int st=0;
            for(int i=0;i<len/2;i++){
                int tar = len-i-1;
                nums[i]=nums[i]+nums[tar];
                nums[tar]=nums[i]-nums[tar];
                nums[i]=nums[i]-nums[tar];
            }
            return;
        }
        int st=len-1;
        int ed=loc+1;
        int tar=len-1;
        while(st>=ed){
            int mid = (st+ed)/2;
            if(nums[mid]>nums[loc]){
                tar = mid;
                ed=mid+1;
            }else{
                st=mid-1;
            }
        }
        nums[tar]=nums[tar]+nums[loc];
        nums[loc]=nums[tar]-nums[loc];
        nums[tar]=nums[tar]-nums[loc];
        len--;
        for(int i=loc+1;i<len;i++,len--){
            nums[i]=nums[i]+nums[len];
            nums[len]=nums[i]-nums[len];
            nums[i]=nums[i]-nums[len];
        }
        return ;
    }
    static public void main(String argv[]){
        int nums[] = {1,3,2};
        nextPermutation(nums);
        for(int num:nums){
            System.out.println(num);
        }
    }
}
