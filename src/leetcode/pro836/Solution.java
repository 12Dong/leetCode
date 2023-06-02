package leetcode.pro836;

public class Solution {
    public boolean isRectangleOverlap(int[] rec1, int[] rec2) {
        int rec1Point1x = rec1[0];
        int rec1Point1y = rec1[1];
        int rec1Point2x = rec1[2];
        int rec1Point2y = rec1[3];

        int rec2Point1x = rec2[0];
        int rec2Point1y = rec2[1];
        int rec2Point2x = rec2[2];
        int rec2Point2y = rec2[3];

        boolean xx = !(rec1Point1x >= rec2Point2x || rec2Point1x >= rec1Point2x);
        boolean yy = !(rec1Point1y >= rec2Point2y || rec2Point1y >= rec1Point2y);
        return xx && yy;
    }
}
