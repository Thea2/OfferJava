/**
 * 题目描述：输入某二叉树的前序遍历和中序遍历的结果，请重建出该二叉树。假设输入的前序遍历和中序遍历的结果中都不含重复的数字。
 * 例如输入前序遍历序列{1,2,4,7,3,5,6,8}和中序遍历序列{4,7,2,1,5,3,8,6}，则重建二叉树并返回。
 *
 * 解题思路：在前序遍历中的第一个数为当前序列的根节点，
 *  然后在中序遍历序列中找到根节点，则在中序遍历序列中根节点左边的子序列为根节点的左子树，右边的子序列为右子树。
 *  如此循环来重建原来的二叉树
 */

//Definition for binary tree
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) {
        val = x;
    }
}

public class Offer4 {

    public TreeNode reConstructBinaryTree(int [] pre,int [] in) {
        return reConstructBinaryTreeSub(pre, 0, pre.length, in, 0, in.length);
    }

    public TreeNode reConstructBinaryTreeSub(int[] pre, int pStart, int pEnd,
                                             int[] in, int iStart, int iEnd){
        if(pStart >= pEnd || iStart >= iEnd){
            return null;
        }
        TreeNode node = new TreeNode(pre[pStart]);
        for(int i = iStart; i < iEnd; i++){
            if(pre[pStart] == in[i]){
                node.left = reConstructBinaryTreeSub(pre, pStart + 1, pStart + i - iStart + 1, in, iStart, i);
                node.right = reConstructBinaryTreeSub(pre, pStart + i - iStart + 1, pEnd, in, i + 1, iEnd);
                break;
            }
        }
        return node;
    }
}
