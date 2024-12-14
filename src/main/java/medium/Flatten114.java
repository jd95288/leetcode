package medium;

import utils.TreeNode;

/**
 * 二叉树展开为链表
 * <p>
 * 将二叉树按先序展开为链表，`left` 置 `null`, `right` 指向下一个节点。
 *
 * @author jd95288
 * @date 2024-12-14 22:20
 */
public class Flatten114 {

    TreeNode prev = null;

    public void flatten(TreeNode root) {
        if (root == null){
            return;
        }
        flatten(root.right);
        flatten(root.left);
        root.right = prev;
        root.left = null;
        prev = root;
    }

}
