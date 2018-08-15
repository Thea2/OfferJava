/**
 * 题目描述：请实现一个函数按照之字形打印二叉树，即第一行按照从左到右的顺序打印，第二层按照从右至左的顺序打印，
 *          第三行按照从左到右的顺序打印，其他行以此类推。
 *
 * 解题思路：用一个列表记录按照层次遍历根节点的所有节点，然后根据每一层的层数奇偶不同，
 *          把该层的节点值按照从左到右或从右到左的顺序加入该层的结果列表，再把该层的结果列表加入总的结果表里。
 */

import java.util.ArrayList;

public class Offer59 {

    public ArrayList<ArrayList<Integer> > Print(TreeNode pRoot) {
        ArrayList<ArrayList<Integer> > result = new ArrayList<ArrayList<Integer> >();
        if(pRoot == null){
            return result;
        }
        //记录按照层次遍历根节点的所有节点
        ArrayList<TreeNode> allNode = new ArrayList<TreeNode>();
        allNode.add(pRoot);
        //记录第几层
        int mark = 0;
        //记录该层第一个节点的位置
        int first = 0;
        //记录该层最后一个节点的位置
        int last = 0;
        while(first < allNode.size()){
            ArrayList<Integer> line = new ArrayList<Integer>();
            last = allNode.size() - 1;
            int start = first;
            int end = last;
            //按层数奇偶来决定把该层节点值加入结果列表的顺序
            if(mark % 2 == 0){
                while(start <= end){
                    line.add(allNode.get(start).val);
                    start++;
                }
            }else{
                while(start <= end){
                    line.add(allNode.get(end).val);
                    end--;
                }
            }
            //把下一层节点加入所有节点列表中
            while(first <= last){
                if(allNode.get(first).left != null){
                    allNode.add(allNode.get(first).left);
                }
                if(allNode.get(first).right != null){
                    allNode.add(allNode.get(first).right);
                }
                first++;
            }
            //将该层节点结果列表加入总结果列表中
            result.add(line);
            mark = result.size();
        }
        return result;
    }

}
