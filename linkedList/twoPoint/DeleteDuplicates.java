package dataStructure.linkedList.twoPoint;

/**
 * 83. 删除排序链表中的重复元素

 * 给定一个已排序的链表的头 head ， 删除所有重复的元素，使每个元素只出现一次 。返回 已排序的链表 。
 *
 */
public class DeleteDuplicates {
    public ListNode deleteDuplicates(ListNode head) {
        //使用快慢指针的方式，进行对比然后删除
        if (head == null) return  null;
        ListNode slow = head;
        ListNode fast = head;

        while (fast != null){
            if (fast.val == slow.val){
                slow.next = fast;
                slow = slow.next;
            }
            fast = fast.next;
        }
        //最后需要断开链接
        slow.next = null;
        return head;
    }
}
