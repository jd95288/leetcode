package medium;

import java.util.*;

/**
 * @author jd95288
 * @date 2024-02-23 16:06
 */
public class KthLargestLevelSum {
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }

        @Override
        public String toString() {
            return "TreeNode{" +
                    "val=" + val +
                    ", left=" + left +
                    ", right=" + right +
                    '}';
        }
    }

    public static void main(String[] args) {
        KthLargestLevelSum main = new KthLargestLevelSum();
        long res = main.kthLargestLevelSum(new TreeNode(1, new TreeNode(2), new TreeNode(3)), 2);
        System.out.println(res);
    }

    public final int MAX = 100000;

    public long[] lacc = new long[MAX];

    public long kthLargestLevelSum(TreeNode root, int k) {
        traverseSubTree(root, 0);
        Arrays.sort(lacc);
        if (lacc[MAX-k] == 0) {
            return -1;
        }
        return lacc[MAX-k];
    }
    public void traverseSubTree(TreeNode subTree, int level) {
        lacc[level] += subTree.val;
        if (subTree.left != null) {
            traverseSubTree(subTree.left, level + 1);
        }
        if (subTree.right != null) {
            traverseSubTree(subTree.right, level + 1);
        }
    }

}
