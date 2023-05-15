import java.util.Iterator;

public class ASolution {

    public int firstMissingPositive(int[] nums) {
        for(int i = 0; i < nums.length; i++) {
            if(nums[i] == i + 1) {
                continue;
            } else {
                // 不断换位置 直到换到正确的位置 指数值 value 换到 nums数组中 value - 1的位置
                int value = nums[i];
                while(true) {
                    int location = value - 1;
                    if(location < 0 || location >= nums.length) {
                        // value有问题 先不换 看 i 之后 能不能换对
                        break;
                    }
                    // nums[location] 数值正确 value 多了一个
                    if(value == nums[location]) {
                        break;
                    }
                    // 换值
                    int tmp = nums[location];
                    nums[location] = value;
                    nums[i] = tmp;
                    value = tmp;
                }
            }
        }

        for(int i = 0; i < nums.length; i++) {
            if(i + 1 != nums[i]) {
                return i + 1;
            }
        }
        return nums.length + 1;
    }

    public static void main(String[] argv) {
        int[] nums = new int[]{3, 4, -1, 1};
        new ASolution().firstMissingPositive(new int[]{3, 4, -1, 1});
    }

}
