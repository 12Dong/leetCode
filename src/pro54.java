import java.util.ArrayList;
import java.util.List;

public class pro54 {
    public List<Integer> spiralOrder(int[][] matrix) {
        if(matrix.length==0) return null;
        if(matrix[0].length==0) return null;
        int rows = matrix.length;
        int cols = matrix[0].length;
        boolean vis[][] = new boolean[rows][cols];
        int curx = 0;
        int cury = 0;
        int cur = 0;
        int dir = 0;
        // 0 右 1 下 2 左 3 上
        List<Integer> list = new ArrayList<>();
        while(cur<rows*cols){
            if(vis[curx][cury]==true) break;
            list.add(matrix[curx][cury]);
            vis[curx][cury]=true;

            cur++;
            if(dir==0){
                if(cury==cols-1 || vis[curx][cury+1]==true){
                    dir = 1;
                    curx++;
                }
                else cury++;
            }else if(dir==1){
                if(curx==rows-1 || vis[curx+1][cury]==true){
                    dir = 2;
                    cury--;
                }
                else curx++;

            }else if(dir==2){
                if(cury==0 || vis[curx][cury-1]==true){
                    dir =3;
                    curx--;
                }else{
                    cury--;
                }
            }else if(dir==3){
                if(curx==0 || vis[curx-1][cury]==true){
                    dir=0;
                    cury++;
                }else{
                    curx--;
                }

            }
        }
        return list;
    }
    static public void main(String argv[]){
        int matrix[][] = {{1}};
        System.out.println(new pro54().spiralOrder(matrix));
    }
}
