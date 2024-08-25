package Trees.Medium;

// 114. Flatten Binary Tree to Linked List

import java.util.Stack;

public class L114 {
    public static void flatten(TreeNode root) {
        if(root == null) return;
        Stack<TreeNode> st = new Stack<>();
        st.push(root);

        while(!st.isEmpty()){
            TreeNode node = st.pop();
            if(node.right != null)
                st.push(node.right);
            if(node.left != null)
                st.push(node.left);
            if(!st.isEmpty())
                node.right = st.peek();
            node.left = null;
        }
    }

    public static void main(String[] args) {
        TreeNode node = new TreeNode(5);
        node.left = new TreeNode(4);
        node.right = new TreeNode(8);
        node.left.left = new TreeNode(11);
        node.left.left.left = new TreeNode(7);
        node.left.left.right = new TreeNode(2);
        flatten(node);
    }
}

// Time Complexity - O(N)
// Space Complexity - O(N)