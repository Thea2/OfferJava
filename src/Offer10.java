/**
 * 题目描述：我们可以用2*1的小矩形横着或者竖着去覆盖更大的矩形。
 *      请问用n个2*1的小矩形无重叠地覆盖一个2*n的大矩形，总共有多少种方法？
 *
 * 解题思路：摘抄
 *      target = 1 大矩形为2*1，只有一种摆放方法，return 1；
 *      target = 2 大矩形为2*2，有两种摆放方法，return2；
 *      target = n 分为两步考虑：
 *              第一次摆放一块 2*1 的小矩阵，则摆放方法总共为f(target - 1)
 *              第一次摆放一块1*2的小矩阵，则摆放方法总共为f(target-2)
 *      得出结论F(1)=1，F(2)=2, F(n)=F(n-1)+F(n-2)（n>2，n∈N*）
 *
 */
public class Offer10 {
    public int RectCover(int target) {
        if(target <= 0){
            return 0;
        }
        if(target == 1 || target == 2){
            return target;
        }
        int first = 1;
        int second = 2;
        int result = 0;
        for(int i = 2; i < target; i++){
            result = first + second;
            first = second;
            second = result;
        }
        return result;
    }
}
