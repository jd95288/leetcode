package medium;

import utils.Node;

/**
 * 填充每个节点的下一个右侧节点指针 II
 * <p>
 * 给定一个二叉树：
 * struct Node {
 * int val;
 * Node *left;
 * Node *right;
 * Node *next;
 * }
 * 填充它的每个 next 指针，让这个指针指向其下一个右侧节点。如果找不到下一个右侧节点，则将 next 指针设置为 NULL 。
 * 初始状态下，所有 next 指针都被设置为 NULL 。
 *
 * @author jd95288
 * @date 2024-12-15 0:40
 */
public class Connect117 {

    public Node[] prev = new Node[6001];

    public Node connect(Node root) {
        if (root == null) {
            return null;
        }
        dfs(root.left, 1);
        dfs(root.right, 1);
        return root;
    }

    public void dfs(Node node, int depth) {
        if (node == null) {
            return;
        }
        dfs(node.left, depth + 1);
        if (prev[depth] != null) {
            prev[depth].next = node;
        }
        prev[depth] = node;
        dfs(node.right, depth + 1);
    }

}
