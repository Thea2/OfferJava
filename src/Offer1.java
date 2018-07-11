/**
 * 题目描述：
 * 在一个二维数组中，每一行都按照从左到右递增的顺序排序，每一列都按照从上到下递增的顺序排序。
 * 请完成一个函数，输入这样的一个二维数组和一个整数，判断数组中是否含有该整数。
 *
 * 解题思路：
 * 根据数组特点，先选择边界的一个数，如右上角array[0][col-1]或左下角array[row-1][0]，
 * 再根据target与边界值的对比来移动边界数
 */
public class Offer1 {


    public boolean Find(int target, int [][] array) {
        if(array == null){
            return false;
        }

        int row = array.length;
        int col = array[row - 1].length;
        /*
        int i = 0;
        int j = col - 1;
        while(i < row && j >= 0){
            if(array[i][j] == target){
                return true;
            }else if(array[i][j] > target){
                j--;
            }else{
                i++;
            }
        }
        */

        int i = row - 1;
        int j = 0;
        while(i >= 0 && j < col){
            if(target == array[i][j]){
                return true;
            }else if(target > array[i][j]){
                j++;
            }else{
                i--;
            }
        }

        return false;
    }
}
