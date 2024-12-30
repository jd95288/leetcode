package medium;

import utils.ListNode;
import utils.TreeNode;

/**
 * 二叉树中的链表
 * <p>
 * 给你一棵以 root 为根的二叉树和一个 head 为第一个节点的链表。
 * 如果在二叉树中，存在一条一直向下的路径，且每个点的数值恰好一一对应以 head 为首的链表中每个节点的值，
 * 那么请你返回 True ，否则返回 False 。
 * 一直向下的路径的意思是：从树中某个节点开始，一直连续向下的路径。
 *
 * @author jd95288
 * @date 2024-12-30 8:56
 */
public class IsSubPath1367 {

    public ListNode head;

    public boolean isSubPath(ListNode head, TreeNode root) {
        this.head = head;
        return dfs(root, head);
    }

    public boolean dfs(TreeNode cur, ListNode node) {
        if (node == null) {
            return true;
        }
        if (cur == null) {
            return false;
        }
        return cur.val == node.val && (dfs(cur.left, node.next) || dfs(cur.right, node.next))
                || node == head && (dfs(cur.left, head) || dfs(cur.right, head));
    }

}
