package Trees.Easy;


// 100. same tree
class TreeNode{
    int data;
    TreeNode left;
    TreeNode right;

    TreeNode(int data){
        this.data = data;
    }
}

public class L100 {

    public static boolean isSameTree(TreeNode p, TreeNode q) {
        if(p == null && q == null)
            return true;
        if(p == null || q == null)
            return false;
        if(p.data == q.data && isSameTree(p.left, q.left) && isSameTree(p.right, q.right))
            return true;
        return false;
    }

    // L101
    public static boolean isSymmetricUtil(TreeNode A, TreeNode B){
        if(A == null && B == null)
            return true;
        if(A == null || B == null)
            return false;
        if(A.data == B.data && isSymmetricUtil(A.left, B.right) && isSymmetricUtil(A.right, B.left))
            return true;
        return false;
    }

    public static void main(String[] args) {
        TreeNode p = new TreeNode(3);
        p.left = new TreeNode(4);
        p.right = new TreeNode(7);
        TreeNode q = new TreeNode(3);
        q.left = new TreeNode(4);
        q.right = new TreeNode(7);
        System.out.println(isSameTree(p, q));

        TreeNode node = new TreeNode(1);
        node.left = new TreeNode(2);
        node.right = new TreeNode(2);
        node.left.left = new TreeNode(3);
        node.right.right = new TreeNode(3);
        node.left.right = new TreeNode(4);
        node.right.left = new TreeNode(4);
        System.out.println(isSymmetricUtil(node.left, node.right));

    }
}

// Time Complexity - O(N)
// Space Complexity - O(1)
