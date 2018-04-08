public class pro34 {
    static public int[] searchRange(int[] nums, int target) {
            int st = binaryEqualFirstSearch(nums, 0, nums.length - 1, target);
            if(st==-1) return new int[]{-1,-1};
            int ed = binaryBigger(nums, 0, nums.length - 1, target);
            int ans[] = {st, ed - 1};
            return ans;
        }

        static int binaryEqualFirstSearch(int nums[], int st, int ed, int tar) {
            int ans = -1;
            while (st <= ed) {
                int mid = (st + ed) / 2;
                if (nums[mid] == tar) {
                    ans = mid;
                    ed = mid - 1;
                } else if (nums[mid] > tar) ed = mid - 1;
                else st = mid + 1;
            }
            return ans;
        }

        static int binaryBigger(int nums[], int st, int ed, int tar) {
            int ans = nums.length;
            while (st <= ed) {
                int mid = (st + ed) / 2;
                if (nums[mid] > tar) {
                    ed = mid - 1;
                    ans=mid;
                }
                else st = mid + 1;
            }
            return ans;
        }

    static public void main(String argv[]) {
        int nums[] = {0, 1, 1, 2};
        for (int num : searchRange(nums, 1)) {
            ;
            System.out.println(num);
        }

    }
}
