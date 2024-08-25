package Trees.Medium;

// 450. Delete Node in a BST


public class L450 {

    public static void printTree(TreeNode root){
        if(root == null) return;
        System.out.print(root.data + " ");
        printTree(root.left);
        printTree(root.right);
    }

    public static int successor(TreeNode root){
        root = root.right;
        while(root.left != null){
            root = root.left;
        }
        return root.data;
    }

    public static int predessor(TreeNode root){
        root = root.left;
        while(root.right != null){
            root = root.right;
        }
        return root.data;
    }

    public static TreeNode deleteNode(TreeNode root, int key) {
        if(root == null)
            return null;
        if(root.data > key){
            root.left = deleteNode(root.left, key);
        }else if (root.data < key){
            root.right = deleteNode(root.right, key);
        }else{
            if(root.left == null && root.right == null){
                root = null;
            }else if(root.right != null){
                root.data = successor(root);
                root.right = deleteNode(root.right, root.data);
            }else{
                root.data = predessor(root);
                root.left = deleteNode(root.left, root.data);
            }
        }
        return root;
    }

    public static void main(String[] args) {
        TreeNode t = new TreeNode(3);
        t.left = new TreeNode(5);
        t.right = new TreeNode(1);
        t.left.left = new TreeNode(6);
        t.left.right = new TreeNode(2);
        t.right.left = new TreeNode(0);
        t.right.right = new TreeNode(8);
        t.left.right.left = new TreeNode(7);
        t.left.right.right = new TreeNode(4);
        printTree(t);
        System.out.println();
        deleteNode(t, 5);
        printTree(t);
    }
}

// Time Complexity - O(n)
// Space Complexity - O(h)