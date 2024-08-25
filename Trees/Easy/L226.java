package Trees.Easy;

// 226. Invert Binary Tree

public class L226 {

    public static TreeNode invertTree(TreeNode root) {
        if(root == null) return null;
        TreeNode left = invertTree(root.left);
        TreeNode right = invertTree(root.right);
        root.left = right;
        root.right = left;
        return root;
    }

    public static void main(String[] args) {
        TreeNode node = new TreeNode(1);
        node.left = new TreeNode(2);
        node.right = new TreeNode(3);
        node.left.right = new TreeNode(5);
        System.out.println(invertTree(node));
    }
}

// Time Complexity - O(N)
// Space Complexity - O(H)