package Trees.Hard;

import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;


// 297. Serialize and Deserialize Binary Tree

public class L297 {

    public static String serialise(TreeNode root){
        if(root == null){
            return "";
        }
        StringBuilder sb = new StringBuilder();
        serialiseHelper(root, sb);
        return sb.toString();
    }

    public static void serialiseHelper(TreeNode root, StringBuilder sb){
        if(root == null){
            sb.append("#,");
            return;
        }
        sb.append(root.data).append(",");
        serialiseHelper(root.left, sb);
        serialiseHelper(root.right, sb);
    }

    public static TreeNode deserialise(String data){
        if(data.length() == 0)
            return null;

        String[] strs = data.split(",");
        Deque<String> dq = new LinkedList<>(Arrays.asList(strs));
        return deserialiseHelper(dq);
    }

    public static TreeNode deserialiseHelper(Deque<String> dq){
        if(dq.isEmpty())
            return null;

        String node = dq.removeFirst();
        if(node.equals("#")){
            return null;
        }

        TreeNode root = new TreeNode(Integer.parseInt(node));
        root.left = deserialiseHelper(dq);
        root.right = deserialiseHelper(dq);
        return root;
    }

    public static void main(String[] args) {
        TreeNode t = new TreeNode(3);
        t.left = new TreeNode(9);
        t.right = new TreeNode(20);
        t.right.left = new TreeNode(15);
        t.right.right = new TreeNode(7);
        String stree = serialise(t);
        System.out.println(stree);
        TreeNode dtree = deserialise(stree);
        System.out.println(dtree.data);
    }
}

// Time complexity - O(N)
// Space complexity - O(N)