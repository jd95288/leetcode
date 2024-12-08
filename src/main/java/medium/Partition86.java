package medium;

import utils.ListNode;

/**
 * 分隔链表
 * <p>
 * 将链表中小于 x 的节点都放到大于等于 x 的节点之前，两个分区的每个节点保留初始的相对位置。
 *
 * @author jd95288
 * @date 2024-12-08 17:13
 */
public class Partition86 {

    public ListNode partition(ListNode head, int x) {
        ListNode l = new ListNode(0);
        ListNode ge = new ListNode(0);
        ListNode lTail = l;
        ListNode geTail = ge;
        while (head != null) {
            if (head.val < x) {
                lTail.next = head;
                lTail = head;
            } else {
                geTail.next = head;
                geTail = head;
            }
            head = head.next;
        }
        geTail.next = null;
        lTail.next = ge.next;
        return l.next;
    }
}
