/**
 * 题目描述：给定一棵二叉搜索树，请找出其中的第k小的结点。例如，（5，3，7，2，4，6，8）中，
 *          按结点数值大小顺序第三小结点的值为4。
 *
 * 解题思路：将二叉搜索树进行中序遍历，同时用一个整型变量来记录当前值为第几个遍历节点，当为第k个时返回该节点
 */

public class Offer62 {

    private int index = 0;
    TreeNode KthNode(TreeNode pRoot, int k)
    {
        if(pRoot == null || k == 0){
            return null;
        }
        TreeNode node = KthNode(pRoot.left, k);
        if(node != null){
            return node;
        }
        if(++index == k){
            return pRoot;
        }
        node = KthNode(pRoot.right, k);
        if(node != null){
            return node;
        }
        return null;
    }
}
