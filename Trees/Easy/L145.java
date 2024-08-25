package Trees.Easy;

// 145. Binary Tree Postorder Traversal

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class L145 {

    // Recursion
    public static void tree(TreeNode root, List<Integer> l){
        if(root==null) return;
        tree(root.left, l);
        tree(root.right, l);
        l.add(root.data);
    }

    public static List<Integer> postorder(TreeNode root) {
        List<Integer>l=new ArrayList<>();
        tree(root,l);
        return l;
    }

    // Iterative
    public static List<Integer> postorderTraversal(TreeNode root) {
        if(root == null)
            return new ArrayList<>();
        List<Integer> ans = new ArrayList<>();
        Stack<TreeNode> st = new Stack<>();
        Stack<TreeNode> out = new Stack<>();
        st.push(root);
        while(!st.isEmpty()){
            TreeNode node = st.pop();
            out.push(node);
            if(node.left != null)
                st.push(node.left);
            if(node.right != null)
                st.push(node.right);
        }
        while(!out.isEmpty()){
            ans.add(out.pop().data);
        }
        return ans;
    }

    // Iterative - Another method
    public static List<Integer> postorderTraversal2(TreeNode root) {
        if(root == null)
            return new ArrayList<>();
        TreeNode curr = root;
        List<Integer> ans = new ArrayList<>();
        Stack<TreeNode> st = new Stack<>();
        while(curr != null || !st.isEmpty()){
            if(curr != null){
                st.push(curr);
                curr = curr.left;
            }else{
                TreeNode temp = st.peek().right;
                if(temp == null){
                    temp = st.pop();
                    ans.add(temp.data);
                    while(!st.isEmpty() && temp == st.peek().right){
                        temp = st.pop();
                        ans.add(temp.data);
                    }
                }else{
                    curr = temp;
                }
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        TreeNode node = new TreeNode(1);
        node.left = new TreeNode(2);
        node.right = new TreeNode(3);
        node.left.left = new TreeNode(4);
        node.left.right = new TreeNode(5);
        node.right.left = new TreeNode(6);
        node.right.right = new TreeNode(7);
        System.out.println(postorderTraversal(node));
        System.out.println(postorderTraversal2(node));

        System.out.println(postorder(node));
    }
}

// Time Complexity - O(N)
// Space Complexity - O(N)