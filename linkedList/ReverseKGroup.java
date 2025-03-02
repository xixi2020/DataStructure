package dataStructure.linkedList;

import java.util.List;

/**
 * 25. K 个一组翻转链表
 * 困难
 * 给你链表的头节点 head ，每 k 个节点一组进行翻转，请你返回修改后的链表。
 * k 是一个正整数，它的值小于或等于链表的长度。如果节点总数不是 k 的整数倍，那么请将最后剩余的节点保持原有顺序。
 * 你不能只是单纯的改变节点内部的值，而是需要实际进行节点交换。
 *
 * 输入：head = [1,2,3,4,5], k = 2
 * 输出：[2,1,4,3,5]
 *
 * 输入：head = [1,2,3,4,5], k = 3
 * 输出：[3,2,1,4,5]
 *
 */
public class ReverseKGroup {
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode cur = head;
        //链表长度
        int n = 0;
        //首先获得链表长度，防止k> length
        //注意这里是cur而不是cur.next
        while (cur != null) {
            cur = cur.next;
            n += 1;
        }

        ListNode dummy = new ListNode(0, head);
        ListNode p = dummy;
        //每次反转前判断剩下的数够不够k个
        while (n >= k) {
            n -= k;
            ListNode pre = null;
            cur = p.next;
            for (int i = 0; i < k; i++) {
                ListNode nxt = cur.next;
                cur.next = pre;
                pre = cur;
                //这时候的cur在反转后的链表下一个结点
                cur = nxt;
            }
            //临时变量保存反转之前前一个结点指向反转之后的最后一个结点
            ListNode temp = p.next;
            p.next.next = cur;
            p.next = pre;
            p = temp;
        }
        return dummy.next;
    }
}
