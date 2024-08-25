package Trees.Easy;

import java.util.ArrayList;
import java.util.List;

// 872. Leaf-Similar Trees

public class L872 {

    public static void buildLeaves(TreeNode root, List<Integer> lis){
        if(root == null) return;
        if(root.left == null && root.right == null){
            lis.add(root.data);
            return;
        }
        buildLeaves(root.left, lis);
        buildLeaves(root.right, lis);
    }

    public static boolean leafSimilar(TreeNode root1, TreeNode root2) {
        List<Integer> l1 = new ArrayList<>();
        List<Integer> l2 = new ArrayList<>();
        buildLeaves(root1, l1);
        buildLeaves(root2, l2);
        System.out.println(l1);
        System.out.println(l2);
        return l1.equals(l2);
    }

    public static void main(String[] args) {
        TreeNode t1 = new TreeNode(3);
        t1.left = new TreeNode(5);
        t1.right = new TreeNode(1);
        t1.left.left = new TreeNode(6);
        t1.left.right = new TreeNode(2);
        t1.right.left = new TreeNode(9);
        t1.right.right = new TreeNode(8);
        t1.left.right.left = new TreeNode(7);
        t1.left.right.right = new TreeNode(4);

        TreeNode t2 = new TreeNode(3);
        t2.left = new TreeNode(5);
        t2.right = new TreeNode(1);
        t2.left.left = new TreeNode(6);
        t2.left.right = new TreeNode(7);
        t2.right.left = new TreeNode(4);
        t2.right.right = new TreeNode(2);
        t2.right.right.left = new TreeNode(9);
        t2.right.right.right = new TreeNode(8);

        System.out.println(leafSimilar(t1, t2));

    }
}

// Time complexity: O(M+N)
// Space complexity: O(M+N)