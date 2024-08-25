package Trees.Medium;

// 106. Construct Binary Tree from Inorder and Postorder Traversal

public class L106 {

    private static void printTree(TreeNode root){
        if(root == null) return;
        System.out.println(root.data+ " ");
        printTree(root.left);

        printTree(root.right);
    }

    public static int findIndex(int[] inorder, int start, int end, int value){
        for(int i=start;i<=end;i++){
            if(value == inorder[i])
                return i;
        }
        return -1;
    }
    static int p;
    public static TreeNode helper(int[] inorder, int[] postorder, int start, int end) {
        if(start > end) return null;
        TreeNode node = new TreeNode(postorder[p--]);
        if(start == end) return node;
        int index = findIndex(inorder, start, end, node.data);
        node.right = helper(inorder, postorder, index+1, end);
        node.left = helper(inorder, postorder, start, index-1);
        return node;
    }

    public static TreeNode buildTree(int[] inorder, int[] postorder) {
        p = postorder.length-1;
        return helper(inorder, postorder, 0, postorder.length-1);
    }

    public static void main(String[] args) {
        int[] inorder = {9,3,15,20,7};
        int[] postorder = {9,15,7,20,3};
        TreeNode root = buildTree(inorder, postorder);
        printTree(root);
    }
}

// Time Complexity - O(N)
// Space Complexity - O(N)