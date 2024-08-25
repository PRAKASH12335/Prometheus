package Trees.Easy;

// 543. Diameter of Binary Tree

public class L543 {

    public static int diameter = 0;
    public static int diameter1 = 0;

    public static int height(TreeNode root){
        if(root == null) return 0;
        return 1+Math.max(height(root.left), height(root.right));
    }

    public static int diameterOfBinaryTree1(TreeNode root) {
        if(root == null) return 0;
        int lh = height(root.left);
        int rh = height(root.right);
        diameter1 = Math.max(diameter1, lh+rh);
        diameterOfBinaryTree1(root.left);
        diameterOfBinaryTree1(root.right);
        return diameter1;
    }


    public static int diameterHelper(TreeNode root) {
        if(root == null) return 0;
        int left = diameterHelper(root.left);
        int right = diameterHelper(root.right);
        diameter = Math.max(diameter, left+right);
        return Math.max(left, right)+1;
    }

    public static int diameterOfBinaryTree2(TreeNode root) {
        diameterHelper(root);
        return diameter;
    }

    public static void main(String[] args) {
        TreeNode node = new TreeNode(1);
        node.left = new TreeNode(2);
        node.right = new TreeNode(3);
        node.left.left = new TreeNode(4);
        node.left.right = new TreeNode(5);
        node.right.left = new TreeNode(6);
        node.right.right = new TreeNode(7);
        System.out.println(diameterOfBinaryTree1(node));
        System.out.println(diameterOfBinaryTree2(node));
    }
}

// Time Complexity - O(N)
// Space Complexity - O(H)