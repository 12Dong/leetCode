package bytedance;

public class SMatrix {

    public static int[][] example = {{1, 2, 3 ,4}, {5,6,7,8}, {9, 10, 11, 12}};

    public static void main(String[] argv) {
        new SMatrix().soultion(example);
    }

    public static int[][] fangxiang = {{1, -1}, {-1, 1}};

    public void soultion(int[][] matrix) {
        int h = matrix.length;
        int l = matrix[0].length;
        int curX = 0;
        int curY = 0;
        int dir = 0;
        while(curX != (h-1) || curY !=(l -1)) {
            System.out.println(matrix[curX][curY]);
            int nextX = curX + fangxiang[dir][0];
            int nextY = curY + fangxiang[dir][1];
            if(nextX < 0 || nextX >= h || nextY < 0 || nextY >= l) {
                if(dir == 0) {
                    nextX = curX + 1;
                    nextY = curY;
                    if(nextX < 0 || nextX >= h || nextY < 0 || nextY >= l) {
                        nextX = curX;
                        nextY = curY + 1;
                    }
            } else{
                    nextX = curX;
                    nextY = curY + 1;
                    if(nextX < 0 || nextX >= h || nextY < 0 || nextY >= l) {
                        nextX = curX+1;
                        nextY = curY;
                    }

                }
                dir = (dir + 1) %2;
        }
            curX = nextX;
            curY = nextY;

    }
        System.out.println(matrix[curX][curY]);
    }
}
