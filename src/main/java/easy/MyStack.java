package easy;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 用队列实现栈
 * 请你仅使用两个队列实现一个后入先出（LIFO）的栈，并支持普通栈的全部四种操作（push、top、pop 和 empty）。
 * 实现 MyStack 类：
 * void push(int x) 将元素 x 压入栈顶。
 * int pop() 移除并返回栈顶元素。
 * int top() 返回栈顶元素。
 * boolean empty() 如果栈是空的，返回 true ；否则，返回 false 。
 *
 * @author jd95288
 * @date 2024-03-03 1:16
 */
public class MyStack {

    private final Queue<Integer> queue;

    public MyStack() {
        queue = new LinkedList<>();
    }

    public void push(int x) {
        int n = queue.size();
        queue.offer(x);
        for (int i = 0; i < n; i++) {
            queue.offer(queue.poll());
        }
    }

    public int pop() {
        if(queue.isEmpty()){
            throw new RuntimeException();
        }
        return queue.poll();
    }

    public int top() {
        if(queue.isEmpty()){
            throw new RuntimeException();
        }
        return queue.peek();
    }

    public boolean empty() {
        return queue.isEmpty();
    }

    public static void main(String[] args) {
        MyStack myStack = new MyStack();
        myStack.push(1);
        myStack.push(2);
        System.out.println(myStack.top()); // 2
        System.out.println(myStack.pop()); // 2
        System.out.println(myStack.empty());  // false
    }
}
