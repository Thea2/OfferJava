/**
 * 题目描述：把一个数组最开始的若干个元素搬到数组的末尾，我们称之为数组的旋转。
 * 输入一个非减排序的数组的一个旋转，输出旋转数组的最小元素。
 * 例如数组{3,4,5,1,2}为{1,2,3,4,5}的一个旋转，该数组的最小值为1。
 * NOTE：给出的所有元素都大于0，若数组大小为0，请返回0。
 *
 * 解题思路：输入的数组为非减排序的旋转，只要找出数组中比其前面的数要小的数，即为数组中的最小元素。
 *      先假定最小元素为数组中的第一个元素，以免出现最小元素被安排到第一位的情况。
 */

public class Offer6 {

    public int minNumberInRotateArray(int [] array) {
        if(array == null || array.length == 0){
            return 0;
        }

        int i = 0;
        int j = i + 1;

        int min = array[0];
        while(j < array.length){
            if(array[j] < array[i]){
                min = array[j];
                break;
            }
            j++;
            i++;
        }
        return min;
    }
}
