/**
 * 题目描述：输入n个整数，找出其中最小的K个数。例如输入4,5,1,6,2,7,3,8这8个数字，则最小的4个数字是1,2,3,4,。
 *
 * 解题思路：将n个整数进行升序排序，再取前k个数
 */

import java.util.ArrayList;

public class Offer29 {

    public ArrayList<Integer> GetLeastNumbers_Solution(int [] input, int k) {
        ArrayList<Integer> result = new ArrayList<Integer>();
        if(input == null || input.length == 0 || k > input.length){
            return result;
        }
        sort(input, 0, input.length-1);
        for(int i = 0; i < k; i++){
            result.add(input[i]);
        }
        return result;
    }

    //快速排序
    public void sort(int[] array, int start, int end){
        if(start >= end){
            return;
        }
        int key = array[start];
        int s = start;
        int e = end;
        while(s < e){
            while(s < e && array[e] > key){
                e--;
            }
            array[s] = array[e];
            while(s < e && array[s] <= key){
                s++;
            }
            array[e] = array[s];
        }
        array[s] = key;
        sort(array, start, e-1);
        sort(array, e+1, end);
    }
}
