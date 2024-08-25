package Trees.Easy;

import java.util.ArrayList;
import java.util.List;

// 257. Binary Tree Paths
public class L257 {

    public static void helper(TreeNode root, List<String> ans, String path){
        if(root == null) return;
        if(root.left == null && root.right == null){
            ans.add(path+root.data);
            return;
        }
        path += root.data+"->";
        helper(root.left, ans, path);
        helper(root.right, ans, path);
    }

    public static List<String> binaryTreePaths(TreeNode root) {
        if(root == null) return new ArrayList<>();
        List<String> ans = new ArrayList<>();
        helper(root, ans, "");
        return ans;
    }

    public static void main(String[] args) {
        TreeNode node = new TreeNode(1);
        node.left = new TreeNode(2);
        node.right = new TreeNode(3);
        node.left.right = new TreeNode(5);
        System.out.println(binaryTreePaths(node));
    }
}

// Time Complexity - O(N)
// Space Complexity - O(H)