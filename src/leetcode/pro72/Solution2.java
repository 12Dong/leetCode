package leetcode.pro72;

public class Solution2 {

    /**
     * 给你两个单词 word1 和 word2， 请返回将 word1 转换成 word2 所使用的最少操作数 。
     *
     * 你可以对一个单词进行如下三种操作：
     *
     * 插入一个字符
     * 删除一个字符
     * 替换一个字符
     *
     *
     * 输入：word1 = "horse", word2 = "ros"
     *
     *
     * horse ros
     *    0  1  2  3
     * 0  0  1  2  3
     * 1  1  1  2  3
     * 2  2  2  1  2
     * 3  3  2  2
     * 4
     * 5
     * 输出：3
     * 解释：
     * horse -> rorse (将 'h' 替换为 'r')
     * rorse -> rose (删除 'r')
     * rose -> ros (删除 'e')
     *
     *
     * @param word1
     * @param word2
     * @return
     */
    public int minDistance(String word1, String word2) {
        int len1 = word1.length();
        int len2 = word2.length();
        int[][] dp = new int[len1 + 1][len2 + 1];
        for(int i = 0; i <= len1; i++) {
            dp[i][0] = i;
        }
        for(int i = 0; i <=len2; i++) {
            dp[0][i] = i;
        }

        for(int i = 1; i <= len1; i++) {
            for(int j = 1; j <= len2; j++) {
                if(word1.charAt(i - 1) == word2.charAt(j - 1)) {
                    dp[i][j] = dp[i-1][j-1];
                } else {
                    dp[i][j] = Math.min(dp[i][j-1], dp[i -1][j]);
                    dp[i][j] = Math.min(dp[i][j], dp[i-1][j-1]);
                    dp[i][j]++;
                }
            }
        }
        return dp[len1][len2];
    }

    public static void main(String[] argv) {
        new Solution2().minDistance("horse", "ros");
    }
}
