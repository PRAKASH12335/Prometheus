package Trees.Easy;

// 1022. Sum of Root To Leaf Binary Numbers

public class L1022 {

    static int sum = 0;

    public static void helper(TreeNode root, int mul) {
        if(root == null) return;
        mul = mul*2 + root.data;
        if(root.left == null && root.right == null){
            sum += mul;
            return;
        }
        helper(root.left, mul);
        helper(root.right, mul);
    }
    public static int sumRootToLeaf(TreeNode root) {
        helper(root, 0);
        return sum;
    }

    public static void main(String[] args) {
        TreeNode t = new TreeNode(1);
        t.left = new TreeNode(0);
        t.right = new TreeNode(1);
        t.left.left = new TreeNode(0);
        t.left.right = new TreeNode(1);
        t.right.left = new TreeNode(0);
        t.right.right = new TreeNode(1);
        System.out.println(sumRootToLeaf(t));
    }
}
