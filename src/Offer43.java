/**
 * 题目描述：汇编语言中有一种移位指令叫做循环左移（ROL），
 *          现在有个简单的任务，就是用字符串模拟这个指令的运算结果。对于一个给定的字符序列S，
 *          请你把其循环左移K位后的序列输出。例如，字符序列S=”abcXYZdef”,要求输出循环左移3位后的结果，
 *          即“XYZdefabc”。是不是很简单？OK，搞定它！
 *
 * 解题思路：先把字符串转为字符数组再将字符按顺序左移，最后再把数组转为字符串。
 */

public class Offer43 {

    public String LeftRotateString(String str,int n) {
        if(str == null){
            return null;
        }
        if(n == 0 || str.length() == 0){
            return str;
        }
        char[] array = str.toCharArray();
        int len = n % array.length;
        char[] result = new char[array.length];
        for(int i = 0; i < array.length - len; i++){
            result[i] = array[i + len];
        }
        for(int i = array.length - len; i < array.length; i++){
            result[i] = array[i + len - array.length];
        }
        return new String(result);
    }
}
