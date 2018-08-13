/**
 * 题目描述：在一个排序的链表中，存在重复的结点，请删除该链表中重复的结点，重复的结点不保留，返回链表头指针。
 *          例如，链表1->2->3->3->4->4->5 处理后为 1->2->5
 *
 */
public class Offer56 {

    public ListNode deleteDuplication(ListNode pHead)
    {
        if(pHead == null){
            return null;
        }
        ListNode result;
        ListNode temp = pHead;
        ListNode index = new ListNode(1);
        index.next = pHead;
        result = index;
        while(temp != null){
            if(temp.next != null && temp.next.val == temp.val){
                while(temp.next != null && temp.next.val == temp.val){
                    temp = temp.next;
                }
                temp = temp.next;
                index.next = temp;
            }else{
                index = index.next;
                temp = temp.next;
            }
        }
        return result.next;
    }
}
