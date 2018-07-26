/**
 * 题目描述：输入一颗二叉树的跟节点和一个整数，打印出二叉树中结点值的和为输入整数的所有路径。
 *         路径定义为从树的根结点开始往下一直到叶结点所经过的结点形成一条路径。
 *         (注意: 在返回值的list中，数组长度大的数组靠前)
 *
 * 解题思路：用递归的方法将节点值累加，把路径用list记录下来，最后把符合要求的加入最终结果。
 */

import java.util.ArrayList;

public class Offer24 {

    public ArrayList<ArrayList<Integer>> FindPath(TreeNode root,int target) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
        if(root == null || target <= 0){
            return result;
        }
        ArrayList<Integer> subList = new ArrayList<Integer>();
        path(result,subList,root,target,0);
        return result;
    }


    public void path(ArrayList<ArrayList<Integer>> result, ArrayList<Integer> subList,
                     TreeNode root, int target, int sum){
        if(root == null || (sum + root.val) > target){
            return;
        }
        sum += root.val;
        if(root.left == null && root.right == null){
            if(sum == target){
                subList.add(root.val);
                result.add(new ArrayList<Integer>(subList));
                subList.remove(subList.size()-1);//移除节点是为了避免影响别的路径
            }
            return;
        }
        subList.add(root.val);
        path(result, subList, root.left, target, sum);
        path(result, subList, root.right, target, sum);
        subList.remove(subList.size()-1);//移除节点是为了避免影响别的路径
    }
}
