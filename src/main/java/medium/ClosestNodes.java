package medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 二叉搜索树最近节点查询
 * 给你一个 二叉搜索树 的根节点 root ，和一个由正整数组成、长度为 n 的数组 queries 。
 * 请你找出一个长度为 n 的 二维 答案数组 answer ，其中 answer[i] = [mini, maxi] ：
 * mini 是树中小于等于 queries[i] 的 最大值 。如果不存在这样的值，则使用 -1 代替。
 * maxi 是树中大于等于 queries[i] 的 最小值 。如果不存在这样的值，则使用 -1 代替。
 * 返回数组 answer 。
 *
 * @author jd95288
 * @date 2024-02-24 18:57
 */
public class ClosestNodes {
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

    public final int MAX = 100000;
    public int[] values = new int[MAX];
    public int i = 0;

    public List<List<Integer>> closestNodes(TreeNode root, List<Integer> queries) {
        Arrays.fill(values, -1);
        traverseSubTree(root);
        // 遍历之后values并非有序
        Arrays.sort(values);
        List<List<Integer>> res = new ArrayList<>(queries.size());
        for (Integer query : queries) {
            List<Integer> tmp = new ArrayList<>(2);
            int ri = Arrays.binarySearch(values, query);
            if (ri < 0) {
                ri = -ri - 1;
                if (ri == values.length) {
                    tmp.add(values[values.length -1]);
                    tmp.add(-1);
                } else if(ri == 0){
                    tmp.add(-1);
                    tmp.add(values[0]);
                } else {
                    tmp.add(values[ri - 1]);
                    tmp.add(values[ri]);
                }
            } else {
                // 如果存在
                tmp.add(values[ri]);
                tmp.add(values[ri]);
            }
            res.add(tmp);
        }
        return res;
    }

    public void traverseSubTree(TreeNode subTree) {
        if (subTree.left != null) {
            traverseSubTree(subTree.left);
        }
        values[i++] = subTree.val;
        if (subTree.right != null) {
            traverseSubTree(subTree.right);
        }
    }
}
