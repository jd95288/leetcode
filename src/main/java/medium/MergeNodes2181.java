package medium;

import utils.ListNode;

/**
 * 合并零之间的节点
 * <p>
 * 给你一个链表的头节点 head ，该链表包含由 0 分隔开的一连串整数。链表的 开端 和 末尾 的节点都满足 Node.val == 0 。
 * 对于每两个相邻的 0 ，请你将它们之间的所有节点合并成一个节点，其值是所有已合并节点的值之和。
 * 然后将所有 0 移除，修改后的链表不应该含有任何 0 。
 * 返回修改后链表的头节点 head 。
 *
 * @author jd95288
 * @date 2024-09-09 9:09
 */
public class MergeNodes2181 {


    public ListNode mergeNodes(ListNode head) {
        ListNode zeroNode = new ListNode();
        ListNode res = head;
        while (head.next != null) {
            if (head.val == 0) {
                zeroNode.next = head;
                zeroNode = head;
            } else {
                zeroNode.val += head.val;
            }
            head = head.next;
        }
        zeroNode.next = null;
        return res;
    }

}
