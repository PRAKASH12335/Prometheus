package Trees.Medium;

// 113. Path Sum II

import java.util.ArrayList;
import java.util.List;

public class L113 {

    public static void pathSumHelper(TreeNode root, List<List<Integer>> ans, List<Integer> temp, int targetSum) {
        if(root == null) return;
        temp.add(root.data);
        if(targetSum == root.data && root.left == null && root.right == null ){
            ans.add(new ArrayList<>(temp));
            return;
        }
        pathSumHelper(root.left, ans, temp, targetSum-root.data);
        pathSumHelper(root.right, ans, temp, targetSum-root.data);
        temp.remove(temp.size()-1);
    }

    public static List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        List<List<Integer>> ans = new ArrayList<>();
        pathSumHelper(root, ans, new ArrayList<>(), targetSum);
        return ans;
    }

    public static void main(String[] args) {
        TreeNode node = new TreeNode(5);
        node.left = new TreeNode(4);
        node.right = new TreeNode(8);
        node.left.left = new TreeNode(11);
        node.left.left.left = new TreeNode(7);
        node.left.left.right = new TreeNode(2);
        node.right.left = new TreeNode(13);
        node.right.right = new TreeNode(4);
        node.right.right.left = new TreeNode(5);
        node.right.right.right = new TreeNode(1);
        int targetSum = 22;
        System.out.println(pathSum(node, targetSum));
    }
}

// Time Complexity - O(NlogN)
// Space Complexity - O(N)