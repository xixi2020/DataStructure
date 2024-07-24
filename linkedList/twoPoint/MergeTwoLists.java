package dataStructure.linkedList.twoPoint;

/**
 *
 * 21. 合并两个有序链表

 * 将两个升序链表合并为一个新的 升序 链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的。
 *
 * 提示：
 *
 * 两个链表的节点数目范围是 [0, 50]
 * -100 <= Node.val <= 100
 * l1 和 l2 均按 非递减顺序 排列
 */
public class MergeTwoLists {


    //使用双指针进行算法实现：两个指针在头结点进行比较，比较小的加进新的链表
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {

        //创建两个指针，分别指向两个链表
        ListNode p1 = list1;
        ListNode p2 = list2;
        //新的头结点，用来接收新节点
        ListNode newList = new ListNode(-1);
        ListNode p = newList;

        while (p1 != null && p2 != null){
            //比较两个链表的值，比较小的连在链表后面
            if (p1.val < p2.val){
                p.next = p1;
                p1 = p1.next;
            }else {
                p.next = p2;
                p2 = p2.next;
            }
            p = p.next;
        }
        //这里是某一条链表遍历完成的情况
        if (p1 != null){
            p.next = p1;
        }
        if (p2 != null){
            p.next = p2;
        }
        return newList.next;
    }
}
