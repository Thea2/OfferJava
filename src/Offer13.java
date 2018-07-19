/**
 * 题目描述：输入一个整数数组，实现一个函数来调整该数组中数字的顺序，
 *          使得所有的奇数位于数组的前半部分，所有的偶数位于位于数组的后半部分，
 *          并保证奇数和奇数，偶数和偶数之间的相对位置不变。
 *
 * 解题思路：将数组中的所有奇数按顺序进入新建的奇数列表，所有的偶数按顺序进入新建的偶数列表，
 *          最后重新对数组赋值，按序先奇数列表后偶数列表。
 */

import java.util.LinkedList;
import java.util.List;

public class Offer13 {

    public void reOrderArray(int [] array) {
        List<Integer> odd = new LinkedList<Integer>();
        List<Integer> even = new LinkedList<Integer>();

        for(int i=0; i<array.length; i++){
            if(array[i] % 2 == 0){
                even.add(array[i]);
            }else{
                odd.add(array[i]);
            }
        }

        int num = 0;
        for(int i=0; i<odd.size(); i++){
            array[num] = odd.get(i);
            num++;
        }
        for(int i=0; i<even.size();i++){
            array[num] = even.get(i);
            num++;
        }
    }

}
