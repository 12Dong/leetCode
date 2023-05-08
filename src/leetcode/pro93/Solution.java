package leetcode.pro93;

import java.util.LinkedList;
import java.util.List;

public class Solution {

    public List<String> restoreIpAddresses(String s) {
        List<String> ans = new LinkedList<>();
        dfs(0, new LinkedList<>(), s, ans);
        return ans;
    }

    public static void dfs(int curIndex, List<Integer> ipList, String s, List<String> ans) {
        if(ipList.size() > 4) {
            return;
        }
        if(curIndex >= s.length()) {
            if(ipList.size() != 4) {
                return;
            } else {
                String ipAddress = "";
                for(int index = 0; index < 3; index++) {
                    ipAddress += ipList.get(index).toString() + '.';
                }
                ipAddress += ipList.get(3);
                ans.add(ipAddress);
            }
        }

        String curNumber = "";
        for(int i = curIndex; i < s.length(); i++) {
            curNumber += s.charAt(i);
            if(judge(curNumber)) {
                ipList.add(Integer.valueOf(curNumber));
                dfs(i + 1, ipList, s, ans);
                ipList.remove(ipList.size() - 1);
            } else {
                break;
            }
        }
    }

    public static boolean judge(String number) {
        Integer ip = Integer.valueOf(number);
        if(ip >= 0 && ip <= 255 && ip.toString().equals(number)) {
            return true;
        } else {
            return false;
        }
    }

    public static void main(String[] argv) {
        new Solution().restoreIpAddresses("25525511135");
    }

}
