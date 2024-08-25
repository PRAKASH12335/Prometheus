package Trees.Medium;

// 230. Kth Smallest Element in a BST

import java.util.Stack;

public class L230 {

    public static int kthSmallest(TreeNode root, int k) {
        Stack<TreeNode> st = new Stack<>();
        while(!st.isEmpty() || root != null){
            while(root != null){
                st.push(root);
                root = root.left;
            }
            TreeNode node = st.pop();
            int value = node.data;
            k--;
            if(k==0) return value;
            root = node.right;
        }
        return -1;
    }

    public static void main(String[] args) {
        TreeNode t = new TreeNode(3);
        t.left = new TreeNode(1);
        t.right = new TreeNode(4);
        t.left.right = new TreeNode(2);

        System.out.println(kthSmallest(t, 2));
    }
}
