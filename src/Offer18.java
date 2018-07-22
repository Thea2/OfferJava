import java.util.Stack;

/**
 * 题目描述：操作给定的二叉树，将其变换为源二叉树的镜像。
 *
 * 解题思路：把每个节点的左右子节点交换。可使用栈来存储未交换左右子节点的节点
 */

public class Offer18 {

    public void Mirror(TreeNode root) {
        if(root == null){
            return ;
        }
        Stack<TreeNode> stack = new Stack<TreeNode>();
        stack.push(root);
        while(!stack.empty()){
            TreeNode node = stack.pop();
            TreeNode tag = node.left;
            node.left = node.right;
            node.right = tag;
            if(node.left != null){
                stack.push(node.left);
            }
            if(node.right != null){
                stack.push(node.right);
            }
        }
    }
}
