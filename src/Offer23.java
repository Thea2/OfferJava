/**
 * 题目描述：输入一个整数数组，判断该数组是不是某二叉搜索树的后序遍历的结果。如果是则输出Yes,否则输出No。
 *         假设输入的数组的任意两个数字都互不相同。
 *
 * 解题思路：二叉搜索树的后序遍历的结果最后一个元素为根，去掉根后的数组应该满足前一段数（左子树）小于根的值，
 *         后一段数（右子树）大于根的值，利用递归检查数组中每一段数是否满足以上要求，如果是则为正确的。
 */

public class Offer23 {

    public boolean VerifySquenceOfBST(int [] sequence) {
        if(sequence == null || sequence.length == 0){
            return false;
        }
        return isRight(sequence, 0, sequence.length-1);
    }

    //确定数组中的某一段数是否是二叉搜索树的后序遍历的结果
    public boolean isRight(int[] a, int start, int root){
        if(start >= root){
            return true;
        }
        int i = root - 1;
        while(a[i] > a[root] && start < i){
            i--;
        }
        for(int j=start; j<i; j++){
            if(a[j] > a[root]){
                return false;
            }
        }
        return isRight(a, start, i) && isRight(a, i+1, root-1);
    }
}
