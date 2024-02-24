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
    // 没必要维护树的结构，按顺序存即可
//    public int[] treeArray = new int[MAX];
    public int[] values = new int[MAX];
    public int i = 0;


    public List<List<Integer>> closestNodes(TreeNode root, List<Integer> queries) {
        Arrays.fill(values, -1);
        traverseSubTree(root);
        // 这里去掉排序出错的原因是填充了-1之后又设置值，导致前面的有序，后面未填充的则都是-1，不符合有序数组条件
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

    /** 二叉搜索树的中序遍历本身就是有序的*/
    public void traverseSubTree(TreeNode subTree) {
        if (subTree.left != null) {
            traverseSubTree(subTree.left);
        }
        values[i++] = subTree.val;
        if (subTree.right != null) {
            traverseSubTree(subTree.right);
        }
    }

    public static void main(String[] args) {
        // 测试二分查找返回的index
        Integer[] a = new Integer[]{7,6,2,3,4,5,9};
        Arrays.sort(a);
        System.out.println(Arrays.toString(a));
        System.out.println(Arrays.binarySearch(a, 1));

        // 测试生产树
        TreeNode root = generateTree(new Integer[]{6, 2, 13, 1, 4, 9, 15, null, null, null, null, null, null, 14}, 0, 0);
        System.out.println(root.toString());

        // 测试树值填充到数组，这里需要注意i应设为公共属性，如果还是向
        ClosestNodes main = new ClosestNodes();
        System.out.println(main.closestNodes(root, Arrays.asList(2, 5, 16)));
    }

    /**
     * 根据二叉树数组创建TreeNode,TODO:写一个生产树文本图像的方法
     */
    public static TreeNode generateTree(Integer[] tree, int index, int level){
        if (tree[index] == null){
            return null;
        }
        TreeNode root = new TreeNode(tree[index]);
        int li = 2 * index + 1;
        int ri = 2 * index + 2;
        if( li < tree.length){
            root.left = generateTree(tree, li, level + 1);
        }
        if( ri < tree.length){
            root.right = generateTree(tree, ri, level + 1);
        }
        return root;
    }

    /** 这个是不对的，因为++index从下层返回时，右子树的index还是当前工作区间的值*/
    @Deprecated
    public void traverseSubTreeError(TreeNode subTree, int index) {
        values[index] = subTree.val;
        if (subTree.left != null) {
            traverseSubTreeError(subTree.left, ++index);
        }
        if (subTree.right != null) {
            traverseSubTreeError(subTree.right, ++index);
        }
    }
}
