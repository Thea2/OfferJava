/**
 * 题目描述：定义栈的数据结构，请在该类型中实现一个能够得到栈中所含最小元素的min函数
 *          （时间复杂度应为O（1））。
 *
 * 解题思路：用迭代器遍历栈从而得出栈中最小元素
 */

import java.util.Iterator;
import java.util.Stack;

public class Offer20 {

    Stack<Integer> stack = new Stack<Integer>();
    public void push(int node) {
        stack.push(node);
    }

    public void pop() {
        stack.pop();
    }

    public int top() {
        return stack.peek();
    }

    public int min() {
        int min = stack.peek();
        int tmp = 0;
        Iterator<Integer> iterator = stack.iterator();
        while (iterator.hasNext()){
            tmp = iterator.next();
            if (min>tmp){
                min = tmp;
            }
        }
        return min;
    }

}
