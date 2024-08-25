package Trees.Easy;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

// 94. Binary Tree Inorder Traversal

public class L94 {

    // Recursion
    public static void tree(TreeNode root, List<Integer> l){
        if(root==null) return;
        tree(root.left, l);
        l.add(root.data);
        tree(root.right, l);
    }

    public static List<Integer> inorder(TreeNode root) {
        List<Integer>l=new ArrayList<>();
        tree(root,l);
        return l;
    }

    // Iterative
    public static List<Integer> inorderTraversal(TreeNode root) {
        if(root == null)
            return new ArrayList<>();
        List<Integer> ans = new ArrayList<>();
        Stack<TreeNode> st = new Stack<>();
        while(true){
            if(root != null){
                st.push(root);
                root = root.left;
            }else{
                if(st.isEmpty())
                    break;
                else{
                    root = st.pop();
                    ans.add(root.data);
                    root = root.right;
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
        System.out.println(inorderTraversal(node));

        System.out.println(inorder(node));
    }
}


// Time Complexity - O(N)
// Space Complexity - O(N)