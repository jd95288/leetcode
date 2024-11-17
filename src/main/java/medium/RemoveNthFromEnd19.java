package medium;

import utils.ListNode;

import java.util.ArrayList;
import java.util.List;

/**
 * 删除链表的倒数第 N 个结点
 * <p>
 * 给你一个链表，删除链表的倒数第 n 个结点，并且返回链表的头结点。
 *
 * @author jd95288
 * @date 2024-11-17 16:23
 */
public class RemoveNthFromEnd19 {
    
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode res = new ListNode(0, head);
        ListNode r = res;
        for (int i = 0; i < n; i++) {
            r = r.next;
        }
        ListNode l = res;
        while (r.next != null) {
            r = r.next;
            l = l.next;
        }
        l.next = l.next.next;
        return res.next;
    }

}
