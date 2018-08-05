/**
 * 题目描述：输入一个递增排序的数组和一个数字S，在数组中查找两个数，使得他们的和正好是S，
 *          如果有多对数字的和等于S，输出两个数的乘积最小的。
 *
 * 解题思路：先用一个二维的列表来记录所有满足和等于S的两个数，再遍历列表找出乘积最小的
 */

import java.util.ArrayList;

public class Offer42 {

    public ArrayList<Integer> FindNumbersWithSum(int [] array,int sum) {
        if(array == null || array.length < 2){
            return new ArrayList<Integer>();
        }

        ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
        int start = 0;
        int end = array.length - 1;
        while(start < end){
            int count = array[start] + array[end];
            if(count > sum){
                end--;
            }else if(count < sum){
                start++;
            }else{
                ArrayList<Integer> tag = new ArrayList<Integer>();
                tag.add(array[start]);
                tag.add(array[end]);
                result.add(tag);
                end--;
            }
        }

        ArrayList<Integer> min = new ArrayList<Integer>();
        if(result.size() != 0){
            int num = result.get(0).get(0) * result.get(0).get(1);
            min = result.get(0);
            for(int i=1; i<result.size(); i++){
                if(num > result.get(i).get(0) * result.get(i).get(1)){
                    num = result.get(i).get(0) * result.get(i).get(1);
                    min = result.get(i);
                }
            }
        }
        return min;
    }
}
