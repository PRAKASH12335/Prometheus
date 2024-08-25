package Trees.Medium;

// 129. Sum Root to Leaf Numbers

public class L129 {

    static int sum = 0;
    public static void helper(TreeNode root, int mul) {
        if(root == null) return;
        mul = mul * 10 + root.data;

        if(root.left != null) helper(root.left, mul);
        if(root.left == null && root.right == null){
            sum += mul;
            return;
        }
        if(root.right != null) helper(root.right, mul);
    }

    public static int sumNumbers(TreeNode root) {
        helper(root, 0);
        return sum;
    }

    public static void main(String[] args) {
        TreeNode t = new TreeNode(4);
        t.left = new TreeNode(9);
        t.right = new TreeNode(0);
        t.left.left = new TreeNode(5);
        t.left.right = new TreeNode(1);

        System.out.println(sumNumbers(t));
    }
}

// Time Complexity - O(N)
// Space Complexity - O(H)
