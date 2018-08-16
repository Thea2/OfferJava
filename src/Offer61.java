/**
 * 题目描述：请实现两个函数，分别用来序列化和反序列化二叉树。
 *
 * 解题思路：序列化和反序列化都按照二叉树先序遍历的顺序
 */

public class Offer61 {
    //记录反序列化时遍历到哪个位置
    private int index = -1;

    String Serialize(TreeNode root) {
        if(root == null){
            return "";
        }
        StringBuilder sb = new StringBuilder();
        Serialize2(root, sb);
        return sb.toString();
    }

    //用逗号分割各节点
    void Serialize2(TreeNode node, StringBuilder sb){
        //如果节点为空，用井号代替节点值
        if(node == null){
            sb.append("#,");
            return;
        }
        sb.append(node.val);
        sb.append(",");
        Serialize2(node.left, sb);
        Serialize2(node.right, sb);
    }

    TreeNode Deserialize(String str) {
        if(str.length() == 0){
            return null;
        }
        String[] nodes = str.split(",");
        return Deserialize2(nodes);
    }

    TreeNode Deserialize2(String[] nodes){
        index++;
        if(!nodes[index].equals("#")){
            TreeNode node = new TreeNode(Integer.parseInt(nodes[index]));
            node.left = Deserialize2(nodes);
            node.right = Deserialize2(nodes);
            return node;
        }
        return null;
    }
}
