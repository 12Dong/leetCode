package HJ16;

import java.util.*;

// 注意类名必须为 Main, 不要有任何 package xxx 信息
public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        // 注意 hasNext 和 hasNextLine 的区别
        while (in.hasNextInt()) { // 注意 while 处理多个 case
            int n = in.nextInt();
            int m = in.nextInt();
            List<Integer> vs = new ArrayList<>();
            List<Integer> ws = new ArrayList<>();
            Map<Integer, List<Integer>> congshuMap = new HashMap<>();
            Map<Integer, Integer> shucong = new HashMap<>();
            for(int i = 0; i < m; i ++) {
                int tmpV = (in.nextInt());
                vs.add(tmpV);
                int tmpW = (in.nextInt());
                ws.add(tmpW);
                int congshu = in.nextInt();
                if(congshu != 0) {
                    List<Integer> cur = congshuMap.getOrDefault(congshu -1, new ArrayList<>());
                    cur.add(i);
                    congshuMap.put(congshu - 1, cur);
                    shucong.put(i, congshu - 1);
                }
            }
            int ans = 0;
            // dp[i][j][0] 在花费 i 块钱
            int[][] dp = new int[m + 1][n + 1];
            for(int j = 0; j < m; j++) {
                for(int i = 0; i <= n; i++) {

                    if(shucong.containsKey(j)) {
                        if(j == 0) {
                            dp[j][i] = 0;
                        } else {
                            dp[j][i] = Math.max(dp[j][i], dp[j-1][i]);

                        }
                        continue;
                    }
                    if(j == 0) {
                        dp[j][i] = 0;
                    } else {
                        dp[j][i] = Math.max(dp[j][i], dp[j-1][i]);

                    }

                    if(i - vs.get(j) < 0) {
                        if(j == 0) {
                            dp[j][i] = 0;
                        } else {
                            dp[j][i] = Math.max(dp[j][i], dp[j-1][i]);
                        }
                        continue;
                    }
                    // 买了 第 j 件 主键
                    if(j == 0) {
                        dp[j][i] = Math.max(dp[j][i], vs.get(j) * ws.get(j));
                    } else {
                        dp[j][i] = Math.max(dp[j][i], dp[j-1][i -vs.get(j)] + vs.get(j) * ws.get(j));
                    }

                    List<Integer> congshu = congshuMap.getOrDefault(j, new ArrayList<>());
                    if(congshu.size() == 0) {
                        continue;
                    }
                    if(congshu.size() == 1) {
                        int targetV = vs.get(j) + vs.get(congshu.get(0));
                        int targetW = vs.get(j) * ws.get(j) + vs.get(congshu.get(0)) * ws.get(congshu.get(0));
                        if(i - targetV >= 0) {
                            if(j == 0) {
                                dp[j][i] = Math.max(dp[j][i], targetW);
                            } else {
                                dp[j][i] = Math.max(dp[j][i], dp[j-1][i - targetV] + targetW);
                                dp[j][i] = Math.max(dp[j][i], dp[j-1][i]);
                            }
                        }

                    }

                    if(congshu.size() == 2) {

                        int targetV = vs.get(j) + vs.get(congshu.get(0));
                        int targetW = vs.get(j) * ws.get(j) + vs.get(congshu.get(0)) * ws.get(congshu.get(0));

                        if(i - targetV >= 0) {
                            if(j == 0) {
                                dp[j][i] = Math.max(dp[j][i], targetW);
                            } else {
                                dp[j][i] = Math.max(dp[j][i], dp[j-1][i - targetV] + targetW);
                            }
                        }

                        targetV = vs.get(j) + vs.get(congshu.get(1));
                        targetW = vs.get(j) * ws.get(j) + vs.get(congshu.get(1)) * ws.get(congshu.get(1));
                        if(i - targetV >= 0) {
                            if(j == 0) {
                                dp[j][i] = Math.max(dp[j][i], targetW);
                            } else {
                                dp[j][i] = Math.max(dp[j][i], dp[j-1][i - targetV] + targetW);
                            }
                        }
                        targetV = vs.get(j) + vs.get(congshu.get(0)) + vs.get(congshu.get(1));
                        targetW = vs.get(j) * ws.get(j) + vs.get(congshu.get(0)) * ws.get(congshu.get(0)) + vs.get(congshu.get(1)) * ws.get(congshu.get(1));
                        if(i - targetV >= 0) {
                            if(j == 0) {
                                dp[j][i] = Math.max(dp[j][i], targetW);
                            } else {
                                dp[j][i] = Math.max(dp[j][i], dp[j-1][i - targetV] + targetW);
                            }
                        }
                    }
                    ans = Math.max(ans, dp[j][i]);

                }
            }
            System.out.println(dp[m-1][n]);
        }
    }
}
/**
10 5
8 2 0
4 5 1
3 5 1
4 3 0
5 2 0
 **/

/**
 10 5
 3 5 0
 4 2 0
 3 5 2
 3 4 2
 6 4 0
 **/