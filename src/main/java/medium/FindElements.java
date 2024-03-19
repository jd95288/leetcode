package medium;

import utils.TreeNode;

import java.util.HashSet;
import java.util.Set;

/**
 * 在受污染的二叉树中查找元素
 * 给出一个满足下述规则的二叉树：
 * <p>
 * root.val == 0
 * 如果 treeNode.val == x 且 treeNode.left != null，那么 treeNode.left.val == 2 * x + 1
 * 如果 treeNode.val == x 且 treeNode.right != null，那么 treeNode.right.val == 2 * x + 2
 * 现在这个二叉树受到「污染」，所有的 treeNode.val 都变成了 -1。
 * <p>
 * 请你先还原二叉树，然后实现 FindElements 类：
 * <p>
 * FindElements(TreeNode* root) 用受污染的二叉树初始化对象，你需要先把它还原。
 * bool find(int target) 判断目标值 target 是否存在于还原后的二叉树中并返回结果。
 *
 * @author jd95288
 * @date 2024-03-12 2:41
 */
public class FindElements {

    Set<Integer> elements = new HashSet<>();

    public FindElements(TreeNode root) {
        root.val = 0;
        elements.add(0);
        if (root.left != null) {
            recover(root.left, 1);
        }
        if (root.right != null) {
            recover(root.right, 2);
        }
    }

    public void recover(TreeNode root, int value) {
        root.val = value;
        elements.add(value);
        if (root.left != null) {
            recover(root.left, 2 * value + 1);
        }
        if (root.right != null) {
            recover(root.right, 2 * value + 2);
        }
    }

    public boolean find(int target) {
        return elements.contains(target);
    }
}
