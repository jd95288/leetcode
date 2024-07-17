package medium;

import utils.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * 二叉树的右视图
 * <p>
 * 给定一个二叉树的 根节点 root，想象自己站在它的右侧，按照从顶部到底部的顺序，返回从右侧所能看到的节点值。
 *
 * @author jd95288
 * @date 2024-07-13 22:56
 */
public class RightSideView199 {

    List<Integer> res = new ArrayList<>();

    /**
     * 题目的意思是求二叉树每层最右侧的节点值
     * 执行通过
     */
    public List<Integer> rightSideView(TreeNode root) {
        if (root != null) {
            dfs(root, 1);
        }
        return res;
    }

    public void dfs(TreeNode node, int level) {
        if (res.size() < level) {
            res.add(node.val);
        }
        if (node.right != null) {
            dfs(node.right, level + 1);
        }
        if (node.left != null) {
            dfs(node.left, level + 1);
        }
    }

}
