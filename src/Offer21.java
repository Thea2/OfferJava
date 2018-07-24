/**
 * 题目描述：输入两个整数序列，第一个序列表示栈的压入顺序，请判断第二个序列是否可能为该栈的弹出顺序。
 *         假设压入栈的所有数字均不相等。例如序列1,2,3,4,5是某栈的压入顺序，序列4,5,3,2,1是该压栈序列对应的一个弹出序列，
 *         但4,3,5,1,2就不可能是该压栈序列的弹出序列。（注意：这两个序列的长度是相等的)
 *
 * 解题思路：根据压入顺序遍历所有元素，如果当前压入元素与下一个弹出元素相等，则不对压入元素进行任何操作，弹出元素后移，
 *         并判断栈顶元素是否与下一个弹出元素相等，如果相等就把栈顶元素弹出，并把弹出元素后移，直到栈顶元素与下一个弹出元素不相等或栈空。
 *         如果当前压入元素与下一个弹出元素不相等，则将其压入栈内。
 *         遍历完成后，如果栈为空，那么说明弹出顺序是正确的，否则说明弹出顺序是错误的、
 */

import java.util.ArrayList;

public class Offer21 {

    public boolean IsPopOrder(int [] pushA,int [] popA) {
        ArrayList<Integer> index = new ArrayList<Integer>();//压入栈内元素在pushA中的下标列表
        int j = 0;//下一个弹出元素在popA中的下标
        int k = 0;//index列表长度

        //按压入顺序遍历所有元素
        for(int i = 0; i < pushA.length; i++){
            if(pushA[i] == popA[j]){//如果当前压入元素与下一个弹出元素相等
                j++;//弹出元素后移
                while(k > 0 && pushA[index.get(k-1)] == popA[j]){//如果栈顶元素与下一个弹出元素相等
                    index.remove(k-1);//把栈顶元素弹出
                    j++;//弹出元素后移
                    k--;
                }
            }else{
                //把元素压入栈内，元素下标加入列表
                index.add(i);
                k++;
            }
        }
        if(index.size() == 0){
            return true;
        }
        return false;
    }
}
