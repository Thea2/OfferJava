/**
 * 题目描述：输入一棵二叉树，求该树的深度。从根结点到叶结点依次经过的结点（含根、叶结点）
 *          形成树的一条路径，最长路径的长度为树的深度。
 *
 * 解题思路：每棵树的深度为左子树和右子树中深度较大的再加一
 */

public class Offer38 {

    public int TreeDepth(TreeNode root) {
        if(root == null){
            return 0;
        }
        int left = TreeDepth(root.left);
        int right = TreeDepth(root.right);
        return left > right ? left+1 : right + 1;
    }
}
