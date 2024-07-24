package dataStructure.linkedList.twoPoint;

/**
 * 定义公共的链表节点方便测试
 */
public class ListNode {
    int val;
    ListNode next;

    public ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }

    public ListNode(int val) {
        this.val = val;
    }

    public ListNode() {
    }
}
