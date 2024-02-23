package medium;

/**
 * @author jd95288
 * @date 2024-02-23 10:05
 */
public class BuildBinaryTreeFromPrePost {
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
    public TreeNode constructFromPrePost(int[] preorder, int[] postorder) {
        return null;
    }
}
