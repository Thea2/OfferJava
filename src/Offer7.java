/**
 * 题目描述：现在要求输入一个整数n，请你输出斐波那契数列的第n项。
 *      F(1)=1，F(2)=1, F(n)=F(n-1)+F(n-2)（n>2，n∈N*）
 *
 * 解决思路：当ｎ为１或２的时候直接返回１，当n>2时，通过循环计算得出该值。
 */
public class Offer7 {

    public int Fibonacci(int n) {
        if(n <= 0){
            return 0;
        }
        if(n == 1 || n == 2){
            return 1;
        }
        int first = 1;
        int second = 1;
        int result = 0;
        for(int i = 3; i <= n; i++){
            result = first + second;
            first = second;
            second = result;
        }
        return result;
    }
}
