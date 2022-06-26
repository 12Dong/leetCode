package pro12;

class Solution {
    public String intToRoman(int num) {
        int[] nums = new int[] {1000,900,500,400,100,90,50,40,10,9,5,4,1};
        String[] strs = new String[] {"M","CM","D","CD","C","XC","L","XL","X","IX","V","IV","I"};
        StringBuilder res = new StringBuilder();
        int count = 0;
        while(num > 0) {
            while(num - nums[count] >= 0) {
                res.append(strs[count]);
                num -= nums[count];
            }
            count++;
        }
        return res.toString();
    }
}