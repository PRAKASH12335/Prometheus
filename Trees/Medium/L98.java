package Trees.Medium;

// 98. Validate Binary Search Tree

public class L98 {

    public static boolean helper(TreeNode root, int minValue, int maxValue) {
        if(root == null) return true;
        if(root.data > minValue && root.data < maxValue && helper(root.left, minValue, root.data) && helper(root.right, root.data, maxValue))
            return true;
        return false;
    }

    public static boolean isValidBST(TreeNode root) {
        return helper(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    public static void main(String[] args) {
        TreeNode t = new TreeNode(2);
        t.left = new TreeNode(1);
        t.right = new TreeNode(3);
        System.out.println(isValidBST(t));
    }
}


// Time Complexity - O(N)
// Space Complexity - O(H)