package dataStructure.linkedList;

/**
 *
 * 19. 删除链表的倒数第 N 个结点
 * 给你一个链表，删除链表的倒数第 n 个结点，并且返回链表的头结点。
 *
 * 输入：head = [1,2,3,4,5], n = 2
 * 输出：[1,2,3,5]
 * 示例 2：
 *
 * 输入：head = [1], n = 1
 * 输出：[]
 * 示例 3：
 *
 * 输入：head = [1,2], n = 1
 * 输出：[1]
 */
public class RemoveNthFromEnd {

    public ListNode removeNthFromEnd(ListNode head, int n) {

        ListNode p = head;
        ListNode p1 = head;
        //先走k+1步
        for (int i = 0; i < n + 1; i++) {
            p = p.next;
        }
        //p和P1同时走,这时候p1刚好走到倒数第k+1个节点,也就是要删的值的前一个节点
        while (p != null) {
            p = p.next;
            p1 = p1.next;
        }
        p1.next = p1.next.next;

        return head;
    }

}
