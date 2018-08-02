/**
 * 题目描述：输入两个链表，找出它们的第一个公共结点。
 *
 * 解题思路：链表第一个公共节点后的节点也为公共节点，分别获取两链表的长度，利用长度差找到第一个公共节点
 */
public class Offer36 {

    public ListNode FindFirstCommonNode(ListNode pHead1, ListNode pHead2) {
        if(pHead1 == null || pHead2 == null){
            return null;
        }
        int len1 = getNodeLength(pHead1);
        int len2 = getNodeLength(pHead2);
        if(len1 > len2){
            for(int i=0; i<(len1-len2); i++){
                pHead1 = pHead1.next;
            }
        }else{
            for(int i=0; i<(len2-len1); i++){
                pHead2 = pHead2.next;
            }
        }
        while(pHead1 != pHead2){
            pHead1 = pHead1.next;
            pHead2 = pHead2.next;
        }
        return pHead1;
    }

    public int getNodeLength(ListNode root){
        ListNode node = root;
        int len = 0;
        while(node != null){
            len++;
            node = node.next;
        }
        return len;
    }
}
