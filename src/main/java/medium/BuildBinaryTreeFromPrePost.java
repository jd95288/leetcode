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

    public static int preCursor = 1;

    public static void main(String[] args) {
        BuildBinaryTreeFromPrePost main = new BuildBinaryTreeFromPrePost();
//        int[] preorder = new int[]{1,2,4,5,3,6,7};
//        int[] preorder = new int[]{3, 9, 20, 15, 7};
//        int[] preorder = new int[]{1,2};
//        int[] preorder = new int[]{2,1,3};
//        int[] preorder = new int[]{4,2,1,3};
        int[] preorder = new int[]{3,4,2,1};
//        int[] preorder = new int[]{1};
//        int[] postorder = new int[]{4,5,2,6,7,3,1};
//        int[] postorder = new int[]{1};
//        int[] postorder = new int[]{9, 15, 7, 20, 3};
//        int[] postorder = new int[]{2,1};
//        int[] postorder = new int[]{3,1,2};
//        int[] postorder = new int[]{3,1,2,4};
        int[] postorder = new int[]{2,1,4,3};
        System.out.println(main.constructFromPrePost(preorder, postorder));
    }

    public TreeNode constructFromPrePost(int[] preorder, int[] postorder) {
        TreeNode root = new TreeNode(preorder[0]);
        if (preorder.length == 1) {
            return root;
        }
        int rightRootPreIndex = 0;
        for (int i = 0; i < preorder.length; i++) {
            if (postorder[postorder.length - 2] == preorder[i]){
                rightRootPreIndex = i;
                break;
            }
        }
        // 注意当start == end时，搜索长度应扩展到整个数组长度，否则会导致查询不到当前节点的右子树根节点。
        root.left = buildSubTree(preorder, postorder, preCursor, rightRootPreIndex == preCursor ? preorder.length:rightRootPreIndex);
        if (preCursor >= rightRootPreIndex && preCursor < preorder.length) {
            root.right = buildSubTree(preorder, postorder, rightRootPreIndex, preorder.length);
        }
        return root;
    }


    public TreeNode buildSubTree(int[] preorder, int[] postorder, int start, int end){
        TreeNode root = new TreeNode(preorder[preCursor]);
        int rightRootPostIndex = 0;
        int rightRootPreIndex = 0;
        for (int i = 0; i < postorder.length; i++) {
            if (root.val == postorder[i]){
                rightRootPostIndex = i;
                preCursor++;
                break;
            }
        }
        if (rightRootPostIndex > 0) {
            for (int i = start; i < end; i++) {
                if (postorder[rightRootPostIndex - 1] == preorder[i]) {
                    rightRootPreIndex = i;
                    break;
                }
            }
            if (preCursor < rightRootPreIndex || start == end) {
                root.left = buildSubTree(preorder, postorder, preCursor, rightRootPreIndex == 0 ? preorder.length : rightRootPreIndex);
            }
            if (preCursor >= rightRootPreIndex && preCursor < end && rightRootPreIndex !=0) {
                root.right = buildSubTree(preorder, postorder, rightRootPreIndex, end);
            }
        }
        return root;
    }


}
