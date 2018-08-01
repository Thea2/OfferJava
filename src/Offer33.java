/**
 * 题目描述：把只包含质因子2、3和5的数称作丑数（Ugly Number）。例如6、8都是丑数，但14不是，因为它包含质因子7。
 *         习惯上我们把1当做是第一个丑数。求按从小到大的顺序的第N个丑数。
 *
 * 解题思路：用数组result记录丑数，下标为i的数代表第i个丑数，p5、p2，p3记录5倍、2倍，3倍的在当前已知丑数中的最小值下标
 *          在找下一个丑数时，比较p2乘以2，p3乘以3，p5乘以5的大小，取最小值，并把当前p向后移一位。
 */

public class Offer33 {

    public int GetUglyNumber_Solution(int index) {
        if(index <= 0){
            return 0;
        }
        int[] result = new int[index];
        result[0] = 1;
        int p2 = 0;
        int p3 = 0;
        int p5 = 0;
        for(int count = 1; count < index; count++){
            int temp = Math.min(result[p2] * 2, Math.min(result[p3] * 3, result[p5] * 5));
            if(result[p2] * 2 == temp){
                p2++;
            }
            if(result[p3] * 3 == temp){
                p3++;
            }
            if(result[p5] * 5 == temp){
                p5++;
            }
            result[count] = temp;
        }

        return result[index - 1];
    }

}
