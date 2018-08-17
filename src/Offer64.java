/**
 * 题目描述：给定一个数组和滑动窗口的大小，找出所有滑动窗口里数值的最大值。
 *          例如，如果输入数组{2,3,4,2,6,2,5,1}及滑动窗口的大小3，那么一共存在6个滑动窗口，
 *          他们的最大值分别为{4,4,6,6,6,5}； 针对数组{2,3,4,2,6,2,5,1}的滑动窗口有以下6个：
 *          {[2,3,4],2,6,2,5,1}， {2,[3,4,2],6,2,5,1}， {2,3,[4,2,6],2,5,1}，
 *          {2,3,4,[2,6,2],5,1}， {2,3,4,2,[6,2,5],1}， {2,3,4,2,6,[2,5,1]}。
 */

import java.util.ArrayList;

public class Offer64 {

    public ArrayList<Integer> maxInWindows(int [] num, int size)
    {
        ArrayList<Integer> result = new ArrayList<Integer>();
        if(num == null || num.length == 0 || size < 1 || num.length < size){
            return result;
        }

        for(int i = 0; i + size - 1 < num.length; i++){
            int max = num[i];
            for(int j = 1; j < size; j++){
                if(max < num[i + j]){
                    max = num[i + j];
                }
            }
            result.add(max);
        }

        return result;
    }
}
