package medium;

import utils.TreeNode;

/**
 * 感染二叉树需要的总时间
 * <p>
 * 给你一棵二叉树的根节点 root ，二叉树中节点的值 互不相同 。另给你一个整数 start 。在第 0 分钟，感染 将会从值为 start 的节点开始爆发。
 * 每分钟，如果节点满足以下全部条件，就会被感染：
 * 节点此前还没有感染。
 * 节点与一个已感染节点相邻。
 * 返回感染整棵树需要的分钟数。
 *
 * @author jd95288
 * @date 2024-04-24 8:56
 */
public class AmountOfTime2385 {

    int startToParentToLeaf = 0;
    int startToLeaf = 0;
    int cnt = 0;

    public int amountOfTime(TreeNode root, int start) {
        dfs(root, start, 0);
        return Math.max(startToLeaf, startToParentToLeaf);
    }

    public int[] dfs(TreeNode root, int start, int depth) {
        if (root == null) {
            return new int[]{depth - 1, 0};
        }

        int[] l = dfs(root.left, start, depth + 1);
        int[] r = dfs(root.right, start, depth + 1);
        boolean lfind = l[1] == 1;
        boolean rfind = r[1] == 1;
        int max = Math.max(r[0], l[0]);
        if (lfind) {
            cnt++;
            startToParentToLeaf = Math.max(r[0] - depth + cnt, startToParentToLeaf);
        }
        if (rfind) {
            cnt++;
            startToParentToLeaf = Math.max(l[0] - depth + cnt, startToParentToLeaf);
        }
        if (root.val == start) {
            startToLeaf = max - depth;
            return new int[]{max, 1};
        }
        return new int[]{max, l[1] + r[1]};
    }

}
