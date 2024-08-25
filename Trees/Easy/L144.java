package Trees.Easy;

// 144. Binary Tree Preorder Traversal

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class L144 {

    // Recursion
    public static void tree(TreeNode root, List<Integer> l){
        if(root==null) return;
        l.add(root.data);
        tree(root.left, l);
        tree(root.right, l);
    }

    public static List<Integer> preorder(TreeNode root) {
        List<Integer>l=new ArrayList<>();
        tree(root,l);
        return l;
    }

    // Iterative
    public static List<Integer> preorderTraversal(TreeNode root) {
        if(root == null)
            return new ArrayList<>();
        List<Integer> ans = new ArrayList<>();
        Stack<TreeNode> st = new Stack<>();
        st.push(root);
        while(!st.isEmpty()){
            TreeNode node = st.pop();
            ans.add(node.data);
            if(node.right != null)
                st.push(node.right);
            if(node.left != null)
                st.push(node.left);
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
        System.out.println(preorderTraversal(node));

        System.out.println(preorder(node));
    }
}

// Time Complexity - O(N)
// Space Complexity - O(N)