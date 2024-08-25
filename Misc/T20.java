package Misc;

// L20. Boundary Traversal in Binary Tree

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class T20 {
    public static boolean isLeaf(TreeNode root){
        if(root == null) return false;
        if(root.left == null && root.right == null)
            return true;
        return false;
    }

    public static void addLeftTraversal(TreeNode root, List<Integer> ans){
        TreeNode curr = root.left;
        while(curr != null){
            if(!isLeaf(curr))
                ans.add(curr.data);
            if(curr.left != null)
                curr = curr.left;
            else
                curr = curr.right;
        }
    }

    public static void addRightTraversal(TreeNode root, List<Integer> ans){
        TreeNode curr = root.right;
        Stack<Integer> st = new Stack<>();
        while(curr != null){
            if(!isLeaf(curr))
                st.push(curr.data);
            if(curr.right != null)
                curr = curr.right;
            else
                curr = curr.left;
        }
        while(!st.isEmpty()){
            ans.add(st.pop());
        }
    }

    public static void addLeaves(TreeNode root, List<Integer> ans){
        if(isLeaf(root)){
            ans.add(root.data);
            return;
        }
        if(root.left != null) addLeaves(root.left, ans);
        if(root.right != null) addLeaves(root.right, ans);
    }

    public static List<Integer> printBoundary(TreeNode root){
        if(root == null) return new ArrayList<>();
        List<Integer> ans = new ArrayList<>();
        if(!isLeaf(root)){
            ans.add(root.data);
        }
        addLeftTraversal(root, ans);
        addLeaves(root, ans);
        addRightTraversal(root, ans);
        return ans;
    }

    public static void main(String[] args) {
        TreeNode tree = new TreeNode(20);
        tree.left = new TreeNode(8);
        tree.left.left = new TreeNode(4);
        tree.left.right = new TreeNode(12);
        tree.left.right.left = new TreeNode(10);
        tree.left.right.right = new TreeNode(14);
        tree.right = new TreeNode(22);
        tree.right.right = new TreeNode(25);
        //tree.left.right.right = new TreeNode(4);

        System.out.println(printBoundary(tree));
    }
}
