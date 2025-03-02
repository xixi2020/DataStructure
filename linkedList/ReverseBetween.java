package dataStructure.linkedList;

/**
 * 92. 反转链表 II
 * 中等
 * 给你单链表的头指针 head 和两个整数 left 和 right ，其中 left <= right 。请你反转从位置 left 到位置 right 的链表节点，返回 反转后的链表 。
 *输入：head = [1,2,3,4,5], left = 2, right = 4
 * 输出：[1,4,3,2,5]
 * 示例 2：
 *
 * 输入：head = [5], left = 1, right = 1
 * 输出：[5]
 * 链表中节点数目为 n
 * 1 <= n <= 500
 * -500 <= Node.val <= 500
 * 1 <= left <= right <= n
 */
public class ReverseBetween {
    public ListNode reverseBetween(ListNode head, int left, int right) {
        //辅助哨兵结点
        ListNode dummy = null;
        dummy.next = head;
        //指向left的前一个结点
        ListNode p = dummy;
        for (int i = 0; i < left - 1 ; i++) {
            p = p.next;
        }
        ListNode cur = p.next;
        ListNode pre = null;

        //cur指向结束反转链表的后一个结点
        for (int j = left; j < right + 1 ; j++) {
            ListNode nxt = cur.next;
            cur.next = pre;
            pre = cur;
            cur = nxt;

        }
        p.next.next = cur;
        p.next = pre;
        return dummy.next;
    }

}
