/**
 * 题目描述：从上到下按层打印二叉树，同一层结点从左至右输出。每一层输出一行。
 */

import java.util.ArrayList;

public class Offer60 {

    ArrayList<ArrayList<Integer>> Print(TreeNode pRoot) {
        ArrayList<ArrayList<Integer> > result = new ArrayList<ArrayList<Integer> >();
        if(pRoot == null){
            return result;
        }
        //记录所有节点
        ArrayList<TreeNode> allNode = new ArrayList<TreeNode>();
        allNode.add(pRoot);
        //该层第一个节点的位置
        int first = 0;
        //该层最后一个节点的位置
        int last = 0;
        while(first < allNode.size()){
            last = allNode.size() - 1;
            ArrayList<Integer> line = new ArrayList<Integer>();
            while(first <= last){
                line.add(allNode.get(first).val);
                if(allNode.get(first).left != null){
                    allNode.add(allNode.get(first).left);
                }
                if(allNode.get(first).right != null){
                    allNode.add(allNode.get(first).right);
                }
                first++;
            }
            result.add(line);
        }
        return result;
    }
}
