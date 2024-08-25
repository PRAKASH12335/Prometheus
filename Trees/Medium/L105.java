package Trees.Medium;

// 105. Construct Binary Tree from Preorder and Inorder Traversal

public class L105 {

    private static void printTree(TreeNode root){
        if(root == null) return;
        printTree(root.left);
        System.out.println(root.data+ " ");
        printTree(root.right);
    }

    static int p;

    public static int findIndex(int[] inorder, int start, int end, int value){
        for(int i=start;i<=end;i++){
            if(value == inorder[i])
                return i;
        }
        return -1;
    }

    public static TreeNode buildTreeHelper(int[] preorder, int[] inorder, int start, int end) {
        if(start > end) return null;
        TreeNode node = new TreeNode(preorder[p++]);
        if(start == end)
            return node;
        int index = findIndex(inorder, start, end, node.data);
        node.left = buildTreeHelper(preorder, inorder, start, index-1);
        node.right = buildTreeHelper(preorder, inorder, index+1, end);
        return node;
    }

    public static TreeNode buildTree(int[] preorder, int[] inorder) {
        p=0;
        return buildTreeHelper(preorder, inorder, 0, inorder.length-1);
    }

    public static void main(String[] args) {
        int[] preorder = {3,9,20,15,7};
        int[] inorder = {9,3,15,20,7};
        TreeNode root = buildTree(preorder, inorder);
        printTree(root);
    }
}

// Time Complexity - O(N)
// Space Complexity - O(N)