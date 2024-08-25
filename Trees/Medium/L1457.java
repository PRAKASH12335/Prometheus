package Trees.Medium;

// 1457. Pseudo-palindromic path in Binary tree

import java.util.HashSet;
import java.util.Set;

public class L1457 {

    int result = 0;

    public void dfs(TreeNode root, Set<Integer> set){
        if(root == null)
            return;
        else if(set.contains(root.data)){
            set.remove(root.data);
        }else
            set.add(root.data);

        if(root.left == null && root.right == null){
            if(set.size() <= 1)
                result++;
        }

        dfs(root.left, new HashSet<>(set));
        dfs(root.right, new HashSet<>(set));
    }
    public int pseudoPalindromic(TreeNode root){
        Set<Integer> set = new HashSet<>();
        dfs(root, set);
        return result;
    }

    public static void main(String[] args) {
        TreeNode t = new TreeNode(2);
        t.left = new TreeNode(3);
        t.right = new TreeNode(1);
        t.left.left = new TreeNode(3);
        t.left.right = new TreeNode(1);
        t.right.right = new TreeNode(1);

        L1457 obj = new L1457();
        System.out.println(obj.pseudoPalindromic(t));
    }
}
