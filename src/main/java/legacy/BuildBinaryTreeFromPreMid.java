package com.test.leetcode;


/**
 * @author liyang
 * @date 2024-02-20 11:43
 */
public class BuildBinaryTreeFromPreMid {

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

    static int[] preorder = new int[]{3, 9, 20, 15, 7};
//    static int[] preorder = new int[]{1,2,3};
//    static int[] preorder = new int[]{-1};

    static int[] inorder = new int[]{9, 3, 15, 20, 7};
//    static int[] inorder = new int[]{2,3,1};
//    static int[] inorder = new int[]{-1};

    static int preCursor = 0;

    public static void main(String[] args) {
        int rootIndex = 0;
        TreeNode root = new TreeNode(preorder[preCursor]);
        for (int i = 0; i < inorder.length; i++) {
            if (inorder[i] == preorder[preCursor]) {
                rootIndex = i;
                // 一定能够找到
                preCursor++;
                break;
            }
        }
        int leftEndIndex = rootIndex - 1;
        int rightStartIndex = rootIndex + 1;
        if (leftEndIndex >= 0) {
            root.left = traverseSubTree(inorder, 0, leftEndIndex);
        }
        // 注意这个preCursor应该是共享变量，原先是想以参数传递的，但是发现递归的时候还要将它传回来，改成了共享变量
        if (rightStartIndex < inorder.length) {
            root.right = traverseSubTree(inorder, rightStartIndex, inorder.length);
        }
        System.out.println(root);
    }

    public static TreeNode traverseSubTree(int[] inorder, int start, int end) {
        TreeNode subRoot = new TreeNode(preorder[preCursor]);
        int rootIndex = start;
        for (int i = start; i <= end; i++) {
            if (inorder[i] == preorder[preCursor]) {
                rootIndex = i;
                preCursor++;
                break;
            }
        }
        int leftEndIndex = rootIndex - 1;
        int rightStartIndex = rootIndex + 1;
        if (leftEndIndex >= start) {
            subRoot.left = traverseSubTree(inorder, start, leftEndIndex);
        }
        // 临界条件判断，这里应该是<=，并且排除掉inorder.length
        if (rightStartIndex <= end && rightStartIndex != inorder.length) {
            // 这里的结束条件传end
            subRoot.right = traverseSubTree(inorder, rightStartIndex, end);
        }
        return subRoot;
    }
}
