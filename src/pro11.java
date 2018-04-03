public class pro11 {
    static public int maxArea(int[] height) {
            int l=0,r=height.length-1;
            int ans=0;
            while(l!=r){
                int w = r-l;
                int h = Math.min(height[l],height[r]);
                int v = w*h;
                ans = Math.max(ans,v);
                if(height[l]>height[r]) r--;
                else l++;
            }
            return ans;
    }
    static public void main(String argv[]){

    }
}
