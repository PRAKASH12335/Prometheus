package Stack.Easy;

// 590. N-ary Tree Postorder Traversal
// 589. N-ary Tree Preorder Traversal

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Stack;

class Node{
    int data;
    List<Node> children;

    public Node(int data){
        this.data = data;
    }
    public Node(int data, List<Node> children) {
        this.data = data;
        this.children = children;
    }
}

public class L590 {

    public static List<Integer> preorder(Node root) {
        if(root == null) return new ArrayList<>();
        Stack<Node> st = new Stack<>();
        st.push(root);
        List<Integer> ans = new ArrayList<>();
        while(!st.isEmpty()){
            Node temp = st.pop();
            ans.add(temp.data);
            if(temp.children == null)
                continue;
            for(int i=temp.children.size()-1;i>=0;i--){
                st.push(temp.children.get(i));
            }
        }
        return ans;
    }

    public static List<Integer> postorder(Node root) {
        if(root == null) return new ArrayList<>();
        Stack<Node> st = new Stack<>();
        st.push(root);
        List<Integer> ans = new ArrayList<>();
        while(!st.isEmpty()){
            Node temp = st.pop();
            ans.add(temp.data);
            if(temp.children == null)
                continue;
            for(Node child : temp.children){
                st.push(child);
            }
        }
        Collections.reverse(ans);
        return ans;
    }

    public static void main(String[] args) {
        List<Node> children2 = new ArrayList<>();
        children2.add(new Node(5));
        children2.add(new Node(6));
        List<Node> children1 = new ArrayList<>();
        children1.add(new Node(3, children2));
        children1.add(new Node(2));
        children1.add(new Node(4));
        Node node = new Node(1, children1);

        System.out.println(postorder(node));
        System.out.println(preorder(node));
    }
}

// Time complexity - O(N)
// Space complexity - O(N)
