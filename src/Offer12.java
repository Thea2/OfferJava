/**
 * 题目描述：给定一个double类型的浮点数base和int类型的整数exponent。求base的exponent次方。
 *
 * 解题思路：１．任何数的次方数为０时结果为１；
 *         ２．当次方数大于０时，结果为base连续相乘exponent次；
 *         ３．当次方数小于０时，结果为base连续相乘exponent次的倒数；
 */
public class Offer12 {

    public double Power(double base, int exponent) {
        if(exponent == 0){
            return 1.0;
        }
        if(exponent > 0){
            double result = base;
            for(int i=1; i<exponent; i++){
                result *= base;
            }
            return result;
        }else{
            double tagResult = base;
            for(int i=1; i < -exponent; i++){
                tagResult *= base;
            }
            return 1/tagResult;
        }
    }
}
