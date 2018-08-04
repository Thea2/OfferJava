/**
 * 题目描述：输入一棵二叉树，判断该二叉树是否是平衡二叉树。
 *
 * 解题思路：若某个节点的左右子树深度差大于1，则该树不是平衡二叉树
 */

public class Offer39 {

    public boolean IsBalanced_Solution(TreeNode root) {
        if(root == null){
            return true;
        }
        if(Math.abs(getHeight(root.left) - getHeight(root.right)) > 1){
            return false;
        }
        return IsBalanced_Solution(root.left) && IsBalanced_Solution(root.right);
    }

    public int getHeight(TreeNode root){
        if(root == null){
            return 0;
        }
        return Math.max(getHeight(root.left), getHeight(root.right)) + 1;
    }

}
