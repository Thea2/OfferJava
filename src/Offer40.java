/**
 * 题目描述：一个整型数组里除了两个数字之外，其他的数字都出现了偶数次。请写程序找出这两个只出现一次的数字
 *
 * 解题思路：用一个字典存储数组中出现的数及其出现次数，最后再遍历字典得出结果
 */

import java.util.HashMap;
import java.util.Map;

public class Offer40 {
    //num1,num2分别为长度为1的数组。传出参数
    //将num1[0],num2[0]设置为返回结果
    public void FindNumsAppearOnce(int [] array,int num1[] , int num2[]) {
        if(array == null){
            return;
        }
        HashMap<Integer, Integer> tag = new HashMap<Integer,Integer>();
        for(int i=0; i<array.length; i++){
            if(tag.containsKey(array[i])){
                tag.put(array[i], tag.get(array[i])+1);
            }else{
                tag.put(array[i], 1);
            }
        }
        int index = 0;
        for(Map.Entry<Integer,Integer> entry: tag.entrySet()){
            if(entry.getValue() == 1){
                if(index == 0){
                    num1[0] = entry.getKey();
                    index++;
                }else{
                    num2[0] = entry.getKey();
                    break;
                }
            }
        }
    }
}
