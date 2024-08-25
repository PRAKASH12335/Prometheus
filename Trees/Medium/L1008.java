package Trees.Medium;

// 1008. Construct Binary Search Tree from Preorder Traversal

public class L1008 {

    private static void printTree(TreeNode root){
        if(root == null) return;
        printTree(root.left);
        System.out.println(root.data+ " ");
        printTree(root.right);
    }

    static int order = 0;
    public static TreeNode helper(int[] preorder, int minValue, int maxValue) {
        if (order >= preorder.length) return null;
        if (preorder[order] > maxValue || preorder[order] < minValue) return null;
        TreeNode node = new TreeNode(preorder[order++]);
        node.left = helper(preorder, minValue, node.data);
        node.right = helper(preorder, node.data, maxValue);
        return node;
    }

    public static TreeNode bstFromPreorder(int[] preorder) {
        return helper(preorder, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    public static void main(String[] args) {
        int[] preorder = new int[]{8,5,1,7,10,12};
        TreeNode root = bstFromPreorder(preorder);
        printTree(root);
    }
}
