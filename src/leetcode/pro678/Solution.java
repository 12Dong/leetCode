package leetcode.pro678;

import java.util.Collection;
import java.util.LinkedList;
import java.util.Stack;

public class Solution {
    public boolean checkValidString(String s) {
        boolean[][] dp = new boolean[s.length()][s.length()];
        for(int i  = s.length() - 1; i >= 0; i--) {
            for(int j = i; j < s.length(); j++) {
                if(i == j) {
                    if(s.charAt(i) == '*') {
                        dp[i][j] = true;
                    }
                } else if(j - i == 1) {
                    char left = s.charAt(i);
                    char right = s.charAt(j);
                    if(left == '*' && right == '*') {
                        dp[i][j] = true;
                    } else if(left == '(' && right == '*') {
                        dp[i][j] = true;
                    } else if(left == '*' && right == ')') {
                        dp[i][j] = true;
                    } else if(left == '(' && right == ')') {
                        dp[i][j] = true;
                    }
                } else {
                    char left = s.charAt(i);
                    char right = s.charAt(j);
                    if(left == '*' && right == '*') {
                        if(dp[i + 1][j - 1]) {
                            dp[i][j] = true;
                        } else {
                            for(int k = i; k < j; k++) {
                                if(dp[i][k] && dp[k+1][j]) {
                                    dp[i][j] = true;
                                    break;
                                }
                            }
                        }
                    } else if(left == '(' && right == '*') {
                        if(dp[i + 1][j - 1]) {
                            dp[i][j] = true;
                        } else {
                            for(int k = i; k < j; k++) {
                                if(dp[i][k] && dp[k+1][j]) {
                                    dp[i][j] = true;
                                    break;
                                }
                            }
                        }
                    } else if(left == '*' && right == ')') {
                        if(dp[i + 1][j - 1]) {
                            dp[i][j] = true;
                        } else {
                            for(int k = i; k < j; k++) {
                                if(dp[i][k] && dp[k+1][j]) {
                                    dp[i][j] = true;
                                    break;
                                }
                            }
                        }
                    } else if(left == '(' && right == ')') {
                        if(dp[i + 1][j - 1]) {
                            dp[i][j] = true;
                        } else {
                            for(int k = i; k < j; k++) {
                                if(dp[i][k] && dp[k+1][j]) {
                                    dp[i][j] = true;
                                    break;
                                }
                            }
                        }
                    }
                }
            }
        }
        return dp[0][s.length() - 1];
    }
    static String ss = "((((()(()()()*()(((((*)()*(**(())))))(())()())(((())())())))))))(((((())*)))()))(()((*()*(*)))";


    public static void main(String[] argv) {
        System.out.println(new Solution().checkValidString("(*())"));
    }

}
