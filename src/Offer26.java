/**
 * 题目描述：输入一棵二叉搜索树，将该二叉搜索树转换成一个排序的双向链表。
 *          要求不能创建任何新的结点，只能调整树中结点指针的指向。
 *
 * 解题思路：即将二叉搜索树按中序遍历的结果连接成双向链表
 */

/*
class TreeNode {
    int val = 0;
    TreeNode left = null;
    TreeNode right = null;
    public TreeNode(int val) {
        this.val = val;
    }
}
*/
public class Offer26 {

    public TreeNode Convert(TreeNode pRootOfTree) {
        //根节点为空，则链表部分也为空
        if(pRootOfTree == null){
            return null;
        }
        //如果左右子节点为空，则直接返回根节点
        if(pRootOfTree.left==null && pRootOfTree.right==null){
            return pRootOfTree;
        }

        TreeNode left = Convert(pRootOfTree.left);//将根节点的左子树进行转换
        TreeNode p = left;
        //找出左子树的最右节点，即左子树中最大的值
        while (p != null && p.right != null) {
            p = p.right;
        }
        //将左子树中最大的节点的右子节点指向根节点
        if (left != null) {
            p.right = pRootOfTree;
            pRootOfTree.left = p;
        }

        TreeNode right = Convert(pRootOfTree.right);//将根节点的右子树进行转换
        //将右子树中最小的节点的左子节点指向根节点
        if (right != null) {
            right.left = pRootOfTree;
            pRootOfTree.right = right;
        }
        
        return left != null ? left : pRootOfTree;
    }
}
