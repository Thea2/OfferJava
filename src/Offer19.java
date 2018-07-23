/**
 * 题目描述：输入一个矩阵，按照从外向里以顺时针的顺序依次打印出每一个数字，
 *      例如，如果输入如下4 X 4矩阵： 1 2 3 4 5 6 7 8 9 10 11 12 13 14 15 16
 *          则依次打印出数字1,2,3,4,8,12,16,15,14,13,9,5,6,7,11,10.
 *
 * 解题思路：用四个数记录上下左右的边界值，每完成一次遍历后将边界值缩小直到对称的边界值相等。
 */

import java.util.ArrayList;

public class Offer19 {

    public ArrayList<Integer> printMatrix(int [][] matrix) {
        if(matrix == null){
            return null;
        }

        int length = matrix.length;
        int width = matrix[0].length;
        int left = 0, right = width - 1, top = 0, bottom = length - 1;
        ArrayList<Integer> result = new ArrayList<Integer>();

        while(left <= right && top <= bottom){
            //从左往右
            for(int i=left; i<= right; i++){
                result.add(matrix[top][i]);
            }
            //从上往下
            for(int i=top+1; i<=bottom; i++){
                result.add(matrix[i][right]);
            }
            //如果上下边界不重合，则从右往左，避免与上面从左往右的重复
            if(top != bottom){
                for(int i=right-1; i>=left; i--){
                    result.add(matrix[bottom][i]);
                }
            }
            //如果左右边界不重合，则从下往上，避免与上面从上往下的重复
            if(left != right){
                for(int i=bottom-1; i>top; i--){
                    result.add(matrix[i][left]);
                }
            }

            //缩小边界
            left++;
            right--;
            top++;
            bottom--;
        }
        return result;
    }
}
