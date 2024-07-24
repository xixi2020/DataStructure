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
        ListNode newHead = new ListNode(-1);
        newHead.next = head;

        //这里必须要指向虚拟节点，因为要考虑到删除的是头结点的情况
        ListNode p = head;
        ListNode p1 = head;
        //先走k+1步
        for (int i = 0; i < n ; i++) {
            p = p.next;
        }
        //p和P1同时走,这时候由于是走到k签名的一个节点，所以不能到最后一个
        while (p.next != null) {
            p = p.next;
            p1 = p1.next;
        }
        //删除节点
        p1.next = p1.next.next;

        return newHead.next;
    }

}
