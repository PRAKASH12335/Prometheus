package Stack.Easy;

// 232. Implement Queue using Stacks

import java.util.Stack;

public class L232 {
    static Stack<Integer> st1;
    static Stack<Integer> st2;

    public L232() {
        st1 = new Stack<>();
        st2 = new Stack<>();
    }

    public static void push(int x) {
        while(!st1.isEmpty()){
            st2.push(st1.pop());
        }
        st1.push(x);
        while(!st2.isEmpty()){
            st1.push(st2.pop());
        }
    }

    public static int pop() {
        return st1.pop();
    }

    public static int peek() {
        return st1.peek();
    }

    public static boolean empty() {
        return st1.isEmpty();
    }

    public static void main(String[] args) {
        L232 myQueue = new L232();
        myQueue.push(1); // queue is: [1]
        myQueue.push(2); // queue is: [1, 2] (leftmost is front of the queue)
        System.out.println(myQueue.peek()); // return 1
        System.out.println(myQueue.pop()); // return 1, queue is [2]
        System.out.println(myQueue.empty()); // return false
    }
}

// Time complexity - O(N)
// Space complexity - O(N)