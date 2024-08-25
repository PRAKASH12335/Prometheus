package Trees.Medium;

import java.util.LinkedList;
import java.util.Queue;

class Node{
    int data;
    Node next;
    Node left;
    Node right;
    Node(int data){
        this.data = data;
    }
}

public class L116 {
    public static Node connect(Node root){
        if(root == null)
            return null;
        Queue<Node> q = new LinkedList<>();
        q.add(root);
        while(!q.isEmpty()){
            int size = q.size();
            int index = 0;
            for(int i=0;i<size;i++){
                index++;
                Node temp = q.poll();
                if(index < size)
                    temp.next = q.peek();
                else
                    temp.next = null;
                if(temp.left != null)
                    q.add(temp.left);
                if(temp.right != null)
                    q.add(temp.right);
            }
        }
        return root;
    }

    public static void main(String[] args) {
        Node t = new Node(1);
        t.left = new Node(2);
        t.right = new Node(3);
        t.left.left = new Node(4);
        t.left.right = new Node(5);
        t.right.left = new Node(6);
        t.right.right = new Node(7);

        Node node = connect(t);
    }
}

// Time Complexity - O(N)
// Space Complexity - O(N)