package Stack.Easy;

// 225. Implement Stack using Queues

import java.util.LinkedList;

public class L225 {
    static LinkedList<Integer> q1;

    public L225() {
        q1 = new LinkedList<>();
    }

    public static void push(int x) {
        q1.add(x);
        int size = q1.size();
        while(size>1){
            q1.add(q1.poll());
            size--;
        }
    }

    public static int pop() {
        return q1.poll();
    }

    public static int top() {
        return q1.peek();
    }

    public static boolean empty() {
        return q1.isEmpty();
    }


    public static void main(String[] args) {
        L225 myStack = new L225();
        myStack.push(1);
        myStack.push(2);
        System.out.println(myStack.top()); // return 2
        System.out.println(myStack.pop()); // return 2
        System.out.println(myStack.empty()); // return False
    }
}

// Time complexity - O(N)
// Space complexity - O(N)