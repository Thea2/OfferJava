/**
 * 题目描述：一只青蛙一次可以跳上1级台阶，也可以跳上2级。
 *      求该青蛙跳上一个n级的台阶总共有多少种跳法（先后次序不同算不同的结果）。
 *
 * 解题思路：
 *      a.如果两种跳法，1阶或者2阶，那么假定第一次跳的是一阶，那么剩下的是n-1个台阶，跳法是f(n-1);
 *      b.假定第一次跳的是2阶，那么剩下的是n-2个台阶，跳法是f(n-2)
 *      c.由a\b假设可以得出总跳法为: f(n) = f(n-1) + f(n-2)
 *      d.只有一阶的时候 f(1) = 1 ,只有两阶的时候可以有 f(2) = 2
 *   得出F(1)=1，F(2)=2, F(n)=F(n-1)+F(n-2)（n>2，n∈N*）
 */

public class Offer8 {

    public int JumpFloor(int target) {
        if(target <= 0){
            return 0;
        }
        if(target == 1 || target == 2){
            return target;
        }

        int first = 1;
        int second = 2;
        int result = 0;
        for(int i = 3; i <= target; i++){
            result = first + second;
            first = second;
            second = result;
        }
        return result;
    }
}
