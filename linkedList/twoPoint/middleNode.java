package dataStructure.linkedList.twoPoint;

/**
 * 876. 链表的中间结点
 * 简单
 * 相关标签
 * 相关企业
 * 给你单链表的头结点 head ，请你找出并返回链表的中间结点。
 *
 * 如果有两个中间结点，则返回第二个中间结点
 */
public class middleNode {
    public ListNode middleNode(ListNode head) {
        //使用两个指针，一个快指针，一个慢指针，一个走两步一个走一步
        ListNode p1 = head;
        ListNode p2 = head;
        //这里注意如果是基数，最后fast走不到最后
        while (p2 != null && p2.next != null){
            p1 = p1.next;
            p2 = p2.next.next;
        }
        return p1;
    }
}
