/**
 * 题目描述：输入一个链表，反转链表后，输出新链表的表头
 *
 * 解题思路：１．如果输入的链表为空，则返回空链表。
 *         ２．先将输入链表的节点的下一节点赋值给用来记录节点next,
 *            当next不为空时，将next的下一节点赋值给新节点tag,
 *            再将next的下一节点改为原来的父节点head后，将next赋值为
 *            原来的下一节点即tag。执行循环直到next为空即原输入链表遍历完成为止。
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
public class Offer15 {

    public ListNode ReverseList(ListNode head) {
        if(head == null){
            return null;
        }
        ListNode next = head.next;
        head.next = null;
        while(next != null){
            ListNode tag = next.next;
            next.next = head;
            head = next;
            next = tag;
        }
        return head;
    }
}
