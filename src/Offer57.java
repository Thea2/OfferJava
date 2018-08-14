/**
 * 题目描述：给定一个二叉树和其中的一个结点，请找出中序遍历顺序的下一个结点并且返回。
 *          注意，树中的结点不仅包含左右子结点，同时包含指向父结点的指针。
 *
 * 解题思路：如果该结点有右子结点，则返回右子结点的中序遍历的第一个结点。
 *          否则层次向上查找父节点，直到当该结点所在树枝为父节点的左子树时或至父节点为空时，返回父节点。
 */
class TreeLinkNode {
    int val;
    TreeLinkNode left = null;
    TreeLinkNode right = null;
    TreeLinkNode next = null;

    TreeLinkNode(int val) {
        this.val = val;
    }
}

public class Offer57 {
    public TreeLinkNode GetNext(TreeLinkNode pNode)
    {
        if(pNode == null){
            return null;
        }
        if(pNode.right != null){
            TreeLinkNode temp = pNode.right;
            while(temp.left != null){
                temp = temp.left;
            }
            return temp;
        }
        TreeLinkNode temp = pNode;
        while(temp.next != null && temp != temp.next.left){
            temp = temp.next;
        }
        return temp.next;
    }
}
