package utils;

/**
 * @author jd95288
 * @date 2024-12-15 0:37
 */
public class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {
    }

    public Node(int val) {
        this.val = val;
    }

    public Node(int val, Node left, Node right, Node next) {
        this.val = val;
        this.left = left;
        this.right = right;
        this.next = next;
    }

    @Override
    public String toString() {
        return "Node{" +
                "val=" + val +
                ", left=" + left +
                ", right=" + right +
                ", next=" + next +
                '}';
    }

    public static Node generateTree(Integer[] arr, int i) {
        int n = arr.length;
        if (i < n && arr[i] != null) {
            return new Node(arr[i], generateTree(arr, 2 * i + 1), generateTree(arr, 2 * i + 2), null);
        } else {
            return null;
        }
    }
}
