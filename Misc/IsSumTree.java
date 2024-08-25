package Misc;

// Check if given binary tree is sum tree

public class IsSumTree {

    // Naive approach
    public static int  sum(TreeNode root){
        if(root == null)
            return 0;
        return sum(root.left) + root.data + sum(root.right);
    }

    public static int isSumTree(TreeNode root){
        if(root == null || root.left == null && root.right == null)
            return 1;
        int left = sum(root.left);
        int right = sum(root.right);

        if((root.data == left + right) && isSumTree(root.left) == 1 && isSumTree(root.right) == 1){
            return 1;
        }
        return 0;
    }

    // Time Complexity - O(N2)
    // Space Complexity - O(N) -> Recursion stack space

    public static int isLeaf(TreeNode root){
        if(root == null)
            return 0;
        if(root.left == null && root.right == null)
            return 1;
        return 0;
    }

    public static int isSumTreeUtil(TreeNode root){
        int left, right;
        if(root == null || isLeaf(root) == 1)
            return 1;

        if(isSumTreeUtil(root.left) == 1 && isSumTreeUtil(root.right) == 1){
            if(root.left == null)
                left = 0;
            else if(isLeaf(root.left) == 1)
                left = root.left.data;
            else
                left = 2*root.left.data;

            if(root.right == null)
                right = 0;
            else if(isLeaf(root.right) == 1)
                right = root.right.data;
            else
                right = 2*root.right.data;

            if(root.data == left + right)
                return 1;
            else
                return 0;
        }
        return 0;
    }

    // Time Complexity - O(N)
    // Space Complexity - O(N) -> Recursion stack space

    public static void main(String[] args) {
        TreeNode t = new TreeNode(26);
        t.left = new TreeNode(10);
        t.right = new TreeNode(3);
        t.left.left = new TreeNode(4);
        t.left.right = new TreeNode(6);
        t.right.right = new TreeNode(3);

        System.out.println(isSumTree(t));
    }
}