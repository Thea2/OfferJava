/**
 * 题目描述：数组中有一个数字出现的次数超过数组长度的一半，请找出这个数字。
 *          例如输入一个长度为9的数组{1,2,3,2,2,2,5,4,2}。由于数字2在数组中出现了5次，
 *          超过数组长度的一半，因此输出2。如果不存在则输出0。
 *
 * 解题思路：先将数组进行排序，然后获取数组中间的元素，统计该元素出现的次数，再比较其与数组长度的一半的大小
 */

import java.util.Arrays;

public class Offer28 {

    public int MoreThanHalfNum_Solution(int [] array) {
        if(array == null || array.length == 0){
            return 0;
        }

        int len = array.length;
        int sum = 0;
        Arrays.sort(array);
        int num = array[len / 2];
        for(int i = 0; i < len; i++){
            if(num == array[i]){
                sum++;
            }
        }
        return sum > len / 2 ? num : 0;
    }
}
