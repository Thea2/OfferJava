/**
 * 题目描述：求1+2+3+...+n，要求不能使用乘除法、for、while、if、else、switch、case等关键字及条件判断语句（A?B:C）。
 *
 * 解题思路：利用Java中短路与&& 将1-n累加起来
 */

public class Offer47 {

    public int Sum_Solution(int n) {
        int sum = n;
        boolean tag = (sum > 0) && ((sum += Sum_Solution(n - 1))>0);
        return sum;
    }
}
