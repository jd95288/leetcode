package _legacy;


/**
 * @author liyang
 * @date 2021-11-29 10:21
 */
public class addTwoNumbers {

    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if (l1 == null || l2 == null) {
            return l1 == null ? l2 : l1;
        }
        //这里如果指定了next，输入0，0时会有多余的0，
        //ListNode head = new ListNode(0, new ListNode(0));
        //但是如果不指定，在没有进位会报空指针
        ListNode head = new ListNode(0);
        ListNode current = head;
        while (l1 != null || l2 != null) {
            int v1 = (l1 == null ? 0 : l1.val);
            int v2 = (l2 == null ? 0 : l2.val);
            //current可能是null
            current.val = v1 + v2 + current.val;
            if (current.val > 9) {
                current.val = current.val - 10;
                current.next = new ListNode(1);
                //如果提前指定了next，这样写会有尾部（即最高位）的0
                //current.next.val = 1;
            }
            //如果不进位，next为null，这样连接就断了
            //current = current.next;
            //提前指定next，这样写会有尾部（即最高位）的0
            //current.next = new ListNode(0);
            l1 = (l1 == null ? null : l1.next);
            l2 = (l2 == null ? null : l2.next);
            //最终需要在这里再次判断，需要有next时再加节点
            if (l1 != null || l2 != null) {
                current.next = current.next == null ? new ListNode(0) : current.next;
                current = current.next;
            }
        }
        return head;
    }

    public static void main(String[] args) {
        //ListNode l1 = new ListNode(0);
        ListNode l1 = new ListNode(2);
        l1.append(new ListNode(4)).append(new ListNode(3));
        //ListNode l2 = new ListNode(0);
        ListNode l2 = new ListNode(5);
        l2.append(new ListNode(6)).append(new ListNode(4));
        System.out.println("l1:" + l1.toString());
        System.out.println("l2:" + l2.toString());
        System.out.println(addTwoNumbers(l1, l2));
    }

    private static class ListNode {

        int val;

        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }

        ListNode append(ListNode next) {
            this.next = next;
            return next;
        }

        @Override
        public String toString() {
            //易错点：使用了固定的引用
            ListNode listNode = this;
            StringBuilder sb = new StringBuilder();
            sb.append("[");
            while (listNode != null) {
                sb.append(listNode.val).append(",");
                listNode = listNode.next;
            }
            sb.deleteCharAt(sb.lastIndexOf(","));
            sb.append("]");
            return sb.toString();
        }
    }
}
