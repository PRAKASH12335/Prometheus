package Trees.Medium;

// 1038. Binary Search Tree to Greater Sum Tree


public class L1038 {

    private static void printTree(TreeNode root){
        if(root == null) return;
        printTree(root.left);
        System.out.println(root.data+ " ");
        printTree(root.right);
    }

    static int sum = 0;
    public static TreeNode bstToGst(TreeNode root) {
        if(root == null)
            return null;
        bstToGst(root.right);
        sum += root.data;
        root.data = sum;
        bstToGst(root.left);
        return root;
    }

    public static void main(String[] args) {
        TreeNode node = new TreeNode(4);
        node.left = new TreeNode(1);
        node.right = new TreeNode(6);
        node.left.left = new TreeNode(0);
        node.left.right = new TreeNode(2);
        node.right.left = new TreeNode(5);
        node.right.right = new TreeNode(7);
        node.left.right.right = new TreeNode(3);
        node.right.right.right = new TreeNode(8);
        TreeNode root = bstToGst(node);
        printTree(root);
    }
}

// Time Complexity - O(N)
// Space Complexity - O(H)