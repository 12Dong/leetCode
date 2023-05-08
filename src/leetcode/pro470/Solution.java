package leetcode.pro470;

public class Solution {

    public int rand10() {
        int num = (rand7() - 1 ) * 7 + rand7();
        do{
            if(num<=40) {
                break;
            } else {
                if (num >= 41 && num <= 49) {
                    num = (num - 1) * 7 + rand7();
                    if(num <= 60) {
                        break;
                    } else {
                        num = (rand7() - 1 ) * 7 + rand7();
                    }
                }
            }
        } while(num > 40);
        return num % 10 + 1;
    }

    public int rand7() {
        return 1;
    }
}
