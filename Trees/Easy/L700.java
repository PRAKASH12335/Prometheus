package Trees.Easy;

public class L700 {

    public static TreeNode searchBST(TreeNode root, int val) {
        if(root == null)
            return null;

        while(root != null){
            if(root.data > val)
                root = root.left;
            else if(root.data < val)
                root = root.right;
            else if(root.data == val)
                return root;
        }
        return null;
    }

    public static void main(String[] args) {
        TreeNode t = new TreeNode(4);
        t.left = new TreeNode(4);
        t.right = new TreeNode(7);
        t.left.left = new TreeNode(1);
        t.left.right = new TreeNode(3);

        System.out.println(searchBST(t, 2).data);
    }
}
