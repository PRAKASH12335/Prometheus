package Trees.Easy;

// 110. Balanced Binary Tree
// Given a binary tree, determine if it is height-balanced.

public class L110 {
    public static int height(TreeNode root){
        if(root == null) return 0;
        return 1+Math.max(height(root.left), height(root.right));
    }

    public static boolean isBalanced(TreeNode root) {
        if(root == null) return true;
        int lh = height(root.left);
        int rh = height(root.right);
        if(Math.abs(lh-rh) <= 1 && isBalanced(root.left) && isBalanced(root.right))
            return true;
        return false;
    }
    // Time Complexity - O(NlogN)
    // Space Complexity - O(H)

    public static boolean ans = true;

    public static int maxDepth(TreeNode root) {
        if(root == null) return 0;
        int lh = maxDepth(root.left);
        int rh = maxDepth(root.right);
        if(lh == -1 || rh == -1)
            return -1;
        if(Math.abs(lh-rh) > 1)
            return -1;
        return Math.max(lh, rh)+1;
    }

    public static boolean isBalanced2(TreeNode root) {
        return maxDepth(root) != -1;
    }

    // Time Complexity - O(N)
    // Space Complexity - O(H)

    public static void main(String[] args) {
        TreeNode node = new TreeNode(1);
        node.left = new TreeNode(2);
        node.right = new TreeNode(3);
        node.left.left = new TreeNode(4);
        node.left.right = new TreeNode(5);
        node.right.left = new TreeNode(6);
        node.right.right = new TreeNode(7);

        System.out.println(isBalanced(node));
        System.out.println(isBalanced2(node));
    }
}

