package dataStructure.linkedList;

/**
 * 206. 反转链表
 * 简单
 * 给你单链表的头节点 head ，请你反转链表，并返回反转后的链表。
 * 输入：head = [1,2,3,4,5]
 * 输出：[5,4,3,2,1]
 *
 * 输入：head = [1,2]
 * 输出：[2,1]
 *
 * 输入：head = []
 * 输出：[]
 */
public class ReverseList {
    public ListNode reverseList(ListNode head) {
        //当前结点的前一个结点
        ListNode pre = null;
        //当前结点
        ListNode cur = head;
        //记录反转前的下一个值作为保存
        ListNode nxt = null;
        //到最后一个结点的情况
        while(cur != null){
            nxt = cur.next;
            cur.next = pre;
            pre = cur;
            cur = nxt;
        }
        //cur = null,pre.next = cur即反转之后的头结点
        return pre;
    }
}
