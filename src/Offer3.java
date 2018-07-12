/**
 *题目描述：输入一个链表，按链表值从尾到头的顺序返回一个ArrayList。
 *解题思路：先把链表的值按顺序读出存放到某list中，后再从后往前读该list的值存到最终的list中
 */

import java.util.ArrayList;


class ListNode {
    int val;
    ListNode next = null;
    ListNode(int val) {
       this.val = val;
    }
}


public class Offer3 {

    public ArrayList<Integer> printListFromTailToHead(ListNode listNode) {
        ArrayList<Integer> resultTag = new ArrayList<Integer>();
        ArrayList<Integer> result = new ArrayList<Integer>();

        while(listNode != null){
            resultTag.add(listNode.val);
            listNode = listNode.next;
        }

        for(int i = resultTag.size() - 1; i >= 0; i--){
            result.add(resultTag.get(i));
        }

        return result;
    }
}
