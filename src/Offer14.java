/**
 * 题目描述：输入一个链表，输出该链表中倒数第k个结点。
 *
 * 解题思路：新建一个链表节点，并让其比头节点领先k个节点，
 *          然后让两个节点同时指向它们的下一个节点，直到新建节点为空，
 *          这时原来的头节点指向链表中倒数第k个节点。
 *        另外，当头节点为空，或k小于等于０，或链表长度小于k时，
 *        并不存在倒数第k个节点，所以返回null
 */

/*class ListNode {
    int val;
    ListNode next = null;

    ListNode(int val) {
        this.val = val;
    }
}*/

public class Offer14 {

    public ListNode FindKthToTail(ListNode head,int k) {
        if(head == null || k <= 0){
            return null;
        }

        ListNode node = head;
        while(k > 0 && node != null){
            k--;
            node = node.next;
        }
        //当链表长度小于k时，并不存在倒数第k个节点，所以返回null
        if(k != 0){
            return null;
        }

        while(node != null){
            node = node.next;
            head = head.next;
        }
        return head;
    }
}
