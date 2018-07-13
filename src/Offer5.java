/**
 * 题目描述：用两个栈来实现一个队列，完成队列的Push和Pop操作。 队列中的元素为int类型。
 *
 * 解题思路：在第一个栈保持元素进入队列的顺序，如果有元素进入队列，直接压入第一个栈即可。
 *  如果要将队头弹出，先将第一个栈中的所有元素依次弹出并压入第二个栈，
 *  然后再将队头即第二个栈栈尾弹出，最后把第二个栈中的所有元素依次弹出并压入第一个栈即可保持队列顺序。
 */

import java.util.Stack;

public class Offer5 {

    Stack<Integer> stack1 = new Stack<Integer>();
    Stack<Integer> stack2 = new Stack<Integer>();

    public void push(int node) {
        stack1.push(node);
    }

    public int pop() {
        while(!stack1.isEmpty()){
            stack2.push(stack1.pop());
        }
        int first = stack2.pop();
        while(!stack2.isEmpty()){
            stack1.push(stack2.pop());
        }
        return first;
    }
}
