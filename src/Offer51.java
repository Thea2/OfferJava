/**
 * 题目描述：给定一个数组A[0,1,...,n-1],请构建一个数组B[0,1,...,n-1],
 *          其中B中的元素B[i]=A[0]*A[1]*...*A[i-1]*A[i+1]*...*A[n-1]。
 *          不能使用除法
 *
 * 解题思路：直接用双重循环跳过A[i]，其余数相乘
 */

public class Offer51 {

    public int[] multiply(int[] A) {
        if(A == null){
            return null;
        }
        int[] B = new int[A.length];
        for(int i=0; i < A.length; i++){
            int sum = 1;
            for(int j=0; j < A.length; j++){
                if(i == j){
                    continue;
                }
                sum *= A[j];
            }
            B[i] = sum;
        }
        return B;
    }
}
