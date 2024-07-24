package dataStructure.linkedList.twoPoint;

/**
 * 142. 环形链表 II
 * 中等
 * 相关标签
 * 相关企业
 * 给定一个链表的头节点  head ，返回链表开始入环的第一个节点。 如果链表无环，则返回 null。
 *
 * 如果链表中有某个节点，可以通过连续跟踪 next 指针再次到达，则链表中存在环。 为了表示给定链表中的环，评测系统内部使用整数 pos 来表示链表尾连接到链表中的位置（索引从 0 开始）。如果 pos 是 -1，则在该链表中没有环。注意：pos 不作为参数进行传递，仅仅是为了标识链表的实际情况。
 *
 * 不允许修改 链表。
 *
 * 输入：head = [1,2], pos = 0
 * 输出：返回索引为 0 的链表节点
 * 解释：链表中有一个环，其尾部连接到第一个节点。
 */
public class DetectCycle {
    public ListNode detectCycle(ListNode head) {
        //多了个确定相遇点：第一个相遇点就是环的开始，当相遇了
        //快指针走了2k步，满指针k步，慢指针和快指针相遇，一定是到头结点的距离加一个环长，所以k=一圈加头到开始环的距离

        ListNode slow = head;
        ListNode fast = head;

        //跳出循环，让快指针和慢指针走一样的步数，再次相遇就是环的节点
        while (fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast){
                break;
            }
        }
        //如果没有break出来，代表没有环
        if (fast == null || fast.next == null){
            return null;
        }
        fast = head;
        while (fast != slow){
            fast = fast.next;
            slow = slow.next;
        }
        return slow;


    }
}
