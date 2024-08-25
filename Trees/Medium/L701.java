package Trees.Medium;

// 701. Insert into a Binary Search Tree

public class L701 {

    public static void printTree(TreeNode root){
        if(root == null) return;
        printTree(root.left);
        System.out.print(root.data + " ");
        printTree(root.right);
    }

    public static TreeNode insertIntoBST(TreeNode root, int val) {
        if(root == null) return new TreeNode(val);

        if(root.data > val)
            root.left = insertIntoBST(root.left, val);
        else if(root.data < val)
            root.right = insertIntoBST(root.right, val);
        return root;
    }

    public static void main(String[] args) {
        TreeNode t = new TreeNode(4);
        t.left = new TreeNode(2);
        t.right = new TreeNode(7);
        t.left.left = new TreeNode(1);
        t.left.right = new TreeNode(3);
        printTree(t);
        insertIntoBST(t, 5);
        System.out.println();
        printTree(t);
    }
}

// Time Complexity - O(logN)
// Space Complexity - O(1)