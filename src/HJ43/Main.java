package HJ43;

import java.util.Scanner;
import java.util.*;
import java.util.stream.Collectors;


// 注意类名必须为 Main, 不要有任何 package xxx 信息
public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        // 注意 hasNext 和 hasNextLine 的区别
        while (in.hasNextInt()) { // 注意 while 处理多个 case
            int n = in.nextInt();
            int m = in.nextInt();
            int[][] map = new int[n][m];
            boolean[][] v = new boolean[n][m];
            Queue<Path> q = new LinkedList<>();
            for(int i = 0; i < n;i++) {
                for(int j = 0; j <m;j++){
                    map[i][j] = in.nextInt();
                    v[i][j] = false;
                }
            }
            Point p = new Point(0,0);
            List<Point> l = new LinkedList<>();
            l.add(p);
            Path path = new Path(0, 0, l);
            q.add(path);
            List<Point> ans = null;
            v[0][0] = true;
            while(!q.isEmpty()) {
                Path cp = q.poll();
                int cx = cp.cx;
                int cy = cp.cy;
                List<Point> cl = cp.list;
                if(cx == n - 1 && cy == m - 1) {
                    ans = cl;
                    break;
                }
                for(int i = 0; i < 4; i++) {
                    int nx = cx + dir[i][0];
                    int ny = cy + dir[i][1];
                    if(nx < 0 || nx >= n || ny < 0 || ny >= m ||
                            map[nx][ny] == 1 || v[nx][ny]
                    ) {
                        continue;
                    } else {
                        List<Point> nl = new LinkedList<>(cl);
                        Point np = new Point(nx, ny);
                        nl.add(np);
                        Path nPath = new Path(nx, ny, nl);
                        v[nx][ny] = true;
                        q.add(nPath);
                    }
                }
            }
            for(Point point : ans) {
                System.out.println("("+point.x+","+point.y+")");
            }

        }
    }

    public static int[][] dir = new int[][]{{1,0}, {-1, 0}, {0, 1},
            {0, -1}};

    public static class Path{
        int cx;
        int cy;
        List<Point> list;
        Path(int cx, int cy, List<Point> list){
            this.cx = cx;
            this.cy = cy;
            this.list = list;
        }
    }

    public static class Point{
        int x;
        int y;
        Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}