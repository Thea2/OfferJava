/**
 * 题目描述：输入两个单调递增的链表，输出两个链表合成后的链表，
 *          当然我们需要合成后的链表满足单调不减规则。
 *
 * 解题思路：１．当输入的链表其中有一个空链表，直接返回另一个链表即可。
 *        　２．当两个链表都不为空时，将两个链表从头开始遍历，比较两个链表节点的值，
 *        　节点值小的链表节点先加入结果链表，然后链表节点指向其下一节点，直到其中一个链表为空。
 *        　最后把未为空链表的节点按序加入结果链表即可。
 */

/*
class ListNode {
    int val;
    ListNode next = null;

    ListNode(int val) {
        this.val = val;
    }
}
*/

public class Offer16 {

    public ListNode Merge(ListNode list1,ListNode list2) {
        if(list1 == null){
            return list2;
        }
        if(list2 == null){
            return list1;
        }

        ListNode result = new ListNode(0);
        ListNode head = result;
        while(list1 != null && list2 != null){
            if(list1.val > list2.val){
                result.next = new ListNode(list2.val);
                result = result.next;
                list2 = list2.next;
            }else{
                result.next = new ListNode(list1.val);
                result = result.next;
                list1 = list1.next;
            }
        }

        while(list1 != null){
            result.next = new ListNode(list1.val);
            result = result.next;
            list1 = list1.next;
        }
        while(list2 != null){
            result.next = new ListNode(list2.val);
            result = result.next;
            list2 = list2.next;
        }

        return head.next;
    }
}
