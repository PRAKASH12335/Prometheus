package Trees.Easy;



public class L222 {

    public static int countNodes(TreeNode root) {
        if(root == null) return 0;
        return 1 + countNodes(root.left) + countNodes(root.right);
    }

    public static void main(String[] args) {
        TreeNode node = new TreeNode(1);
        node.left = new TreeNode(2);
        node.right = new TreeNode(3);
        node.left.left = new TreeNode(4);
        node.left.right = new TreeNode(5);
        node.right.left = new TreeNode(6);
        node.right.right = new TreeNode(7);
        System.out.println(countNodes(node));
    }
}

// Time Complexity - O(N)
// Space Complexity - O(H)