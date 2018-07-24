/**
 * 题目描述：从上往下打印出二叉树的每个节点，同层节点从左至右打印。
 *
 * 解题思路：用队列来存储未遍历的节点,取出节点后，读取节点值，
 *      然后把非空的左子节点加入队列，再把非空的右子节点加入队列。
 *      重复以上操作直到队列为空。
 */

import java.util.ArrayList;
import java.util.LinkedList;
/*
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) {
        val = x;
    }
}*/

public class Offer22 {

    public ArrayList<Integer> PrintFromTopToBottom(TreeNode root) {
        ArrayList<Integer> result = new ArrayList<Integer>();
        if(root == null){
            return result;
        }
        //此处用列表来代替队列
        LinkedList<TreeNode> tag = new LinkedList<TreeNode>();
        tag.add(root);
        for(int i=0; i<tag.size(); i++){
            TreeNode node = tag.get(i);
            result.add(node.val);
            if(node.left != null){
                tag.add(node.left);
            }
            if(node.right != null){
                tag.add(node.right);
            }
        }
        return result;
    }
}
