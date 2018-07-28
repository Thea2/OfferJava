/**
 * 题目描述：输入一个字符串,按字典序打印出该字符串中字符的所有排列。
 *          例如输入字符串abc,则打印出由字符a,b,c所能排列出来的所有字符串abc,acb,bac,bca,cab和cba。
 *
 * 解题思路：将不同的字符重新排序
 */

import java.util.ArrayList;
import java.util.Collections;

public class Offer27 {

    public ArrayList<String> Permutation(String str) {
        ArrayList<String> result = new ArrayList<String>();
        if(str == null || str.length() == 0){
            return result;
        }
        helper(result,str.toCharArray(),0);
        Collections.sort(result);
        return result;
    }

    /**
     * 对数组array中的每个元素进行重新排序并把排序完后的结果加入列表result
     * @param result
     * @param array
     * @param start　对数组array从下标为start的元素到数组末尾元素进行重新排序
     */
    public void helper(ArrayList<String> result, char[] array, int start){
        if(start == array.length){//如果start为数组长度，则说明数组排序完成
            result.add(String.valueOf(array));
        }else{
            for(int i=start; i<array.length; i++){
                //更换下标为start的元素，并对后面的元素也进行重新排序
                if(i == start || array[i] != array[start]){
                    swap(array,start,i);
                    helper(result,array, start+1);
                    swap(array,start,i);
                }
            }
        }
    }

    /**
     * 交换数组a中下标为i和下标为j的两个元素
     * @param a
     * @param i
     * @param j
     */
    public void swap(char[] a, int i, int j){
        char temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }
}
