package medium;

import utils.ListNode;

/**
 * 删除排序链表中的重复元素 II
 * <p>
 * 给定一个已排序的链表的头 head ， 删除原始链表中所有重复数字的节点，只留下不同的数字 。返回 已排序的链表 。
 *
 * @author jd95288
 * @date 2024-11-23 15:56
 */
public class DeleteDuplicates82 {

    public ListNode deleteDuplicates(ListNode head) {
        ListNode dummy = new ListNode(-101, head);
        if (head == null) {
            return head;
        }
        ListNode tail = head;
        ListNode prev = dummy;
        boolean equal = false;
        while (tail.next != null) {
            if (tail.val != tail.next.val) {
                if (!equal) {
                    prev.next = tail;
                    prev = tail;
                } else {
                    equal = false;
                }
            } else {
                equal = true;
            }
            tail = tail.next;
        }
        if (prev.val != tail.val) {
            if (!equal) {
                prev.next = tail;
            } else {
                prev.next = null;
            }
        }
        return dummy.next;
    }
}
