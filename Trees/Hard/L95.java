package Trees.Hard;

import java.util.ArrayList;
import java.util.List;

class TreeNode{
    int data;
    TreeNode left;
    TreeNode right;
    TreeNode(int data){
        this.data = data;
    }
}

public class L95 {

    public static List<TreeNode> helper(int m, int n) {
        List<TreeNode> ans = new ArrayList<>();
        if(m>n) {
            ans.add(null);
            return ans;
        }
        for(int i=m;i<=n;i++) {
            List<TreeNode> ls = helper(m, i - 1);
            List<TreeNode> rs = helper(i+1, n);
            for(TreeNode l : ls){
                for(TreeNode r : rs){
                    TreeNode newNode = new TreeNode(i);
                    newNode.left = l;
                    newNode.right = r;
                    ans.add(newNode);
                }
            }
        }
        return ans;
    }
    public static List<TreeNode> generateTrees(int n) {
        if(n == 0){
            return new ArrayList<>();
        }
        return helper(1, n);
    }

    public static void main(String[] args) {
        int n = 3;
        List<TreeNode> ans = generateTrees(n);
        System.out.println(ans);
    }
}

// Time Complexity - O(4^n/n^1/2)
// Time Complexity - O(4^n/n^1/2)