package Trees.Medium;

// 2096. Step-By-Step Directions From a Binary Tree Node to Another

import java.util.ArrayList;
import java.util.List;

public class L2096 {

    static List<String> paths;

    public static TreeNode LCA(TreeNode root, int startValue, int destValue){
        if(root == null)
            return null;
        if(root.data == startValue || root.data == destValue)
            return root;
        TreeNode left = LCA(root.left, startValue, destValue);
        TreeNode right = LCA(root.right, startValue, destValue);
        if(left != null && right!=null)
            return root;
        return left != null ? left : right;
    }

    public static void find(TreeNode root, int value, StringBuilder path){
        if(root == null)
            return;
        if(root.data == value){
            paths.add(path.toString());
            return;
        }
        if(root.left != null)
            find(root.left, value, path.append("L"));
        if(root.right != null)
            find(root.right, value, path.append("R"));
        path.deleteCharAt(path.length()-1);
    }

    public static String getDirections(TreeNode root, int startValue, int destValue) {
        if(root == null)
            return "";
        paths = new ArrayList<>();
        TreeNode lca = LCA(root, startValue, destValue);
        find(lca, startValue, new StringBuilder());
        find(lca, destValue, new StringBuilder());

        StringBuilder result = new StringBuilder();
        for(int i=0;i<paths.get(0).length();i++){
            result.append("U");
        }
        result.append(paths.get(1));
        return result.toString();
    }

    public static void main(String[] args) {
        TreeNode t = new TreeNode(5);
        t.left = new TreeNode(1);
        t.right = new TreeNode(2);
        t.left.left = new TreeNode(3);
        t.right.left = new TreeNode(6);
        t.right.right = new TreeNode(4);

        System.out.println(getDirections(t, 2, 1));
    }
}

// Time Complexity - O(N)
// Space Complexity - O(N)