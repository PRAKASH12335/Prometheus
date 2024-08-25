package Trees.Medium;

// 99. Recover Binary Search Tree

public class L99 {

    public static void printTree(TreeNode root){
        if(root == null) return;
        printTree(root.left);
        System.out.print(root.data + " ");
        printTree(root.right);
    }

    static TreeNode first, middle, last, prev;
    public static void recoverTreeUtil(TreeNode root) {
        if(root != null){
            recoverTreeUtil(root.left);
            if(prev != null && prev.data > root.data){
                if(first == null){
                    first = prev;
                    middle = root;
                }else
                    last = root;
            }else
                prev = root;
            recoverTreeUtil(root.right);
        }
    }

    public static void recoverTree(TreeNode root) {
        first = middle = last = prev = null;
        recoverTreeUtil(root);
        int temp;
        if(first != null && last != null){
            temp = first.data;
            first.data = last.data;
            last.data = temp;
        } else if (first != null && middle != null){
            temp = first.data;
            first.data = middle.data;
            middle.data = temp;
        }
    }

    public static void main(String[] args) {
        TreeNode t = new TreeNode(1);
        t.left = new TreeNode(3);
        t.left.right = new TreeNode(2);
        printTree(t);
        recoverTree(t);
        System.out.println();
        printTree(t);
    }
}
