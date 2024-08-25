package Trees.Easy;

// 993. Cousins in Binary Tree

import java.util.HashMap;
import java.util.Map;

public class L993 {

    static Map<Integer, Integer> parent = new HashMap<>();
    static Map<Integer, Integer> depth = new HashMap<>();
    public static boolean isCousins(TreeNode root, int x, int y) {
        preOrderParent(root, x);
        preOrderParent(root, y);
        preOrderDepth(root, x, 0);
        preOrderDepth(root, y, 0);

        Integer parentX = parent.get(x);
        Integer parentY = parent.get(y);
        Integer depthX = depth.get(x);
        Integer depthY = depth.get(y);

        if(parentX != null && parentY!= null && parentX != parentY && depthX == depthY){
            return true;
        }
        return false;
    }

    public static void preOrderParent(TreeNode root, int x){
        if(root == null) return;
        if(root.left != null && root.left.data == x || root.right != null && root.right.data == x ){
            parent.put(x, root.data);
            return;
        }
        preOrderParent(root.left, x);
        preOrderParent(root.right, x);
    }

    public static void preOrderDepth(TreeNode root, int x, int d){
        if(root == null) return;
        if(root.data == x){
            depth.put(x, d);
            return;
        }
        preOrderDepth(root.left, x, d+1);
        preOrderDepth(root.right, x, d+1);
    }

    public static void main(String[] args) {
        TreeNode t = new TreeNode(10);
        t.left = new TreeNode(5);
        t.right = new TreeNode(15);
        t.left.left = new TreeNode(3);
        t.right.right = new TreeNode(18);

        System.out.println(isCousins(t, 3, 18));
    }
}

// Time complexity: O(n)
// Space complexity: O(n)