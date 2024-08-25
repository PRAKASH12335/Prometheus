package Trees.Medium;

// 109. Convert Sorted List to Binary Search Tree

class ListNode{
    int val;
    ListNode next;
    ListNode(int val){
        this.val = val;
    }
}

public class L109 {

    public static TreeNode helper(ListNode head, ListNode tail){
        if(head == null) return null;
        if(head == tail) return null;
        ListNode slow = head;
        ListNode fast = head;
        while(fast != tail && fast.next != tail){
            slow = slow.next;
            fast = fast.next.next;
        }
        TreeNode root = new TreeNode(slow.val);
        root.left = helper(head, slow);
        root.right = helper(slow.next, tail);
        return root;
    }

    public static TreeNode sortedListToBST(ListNode head) {
        if(head == null) return null;
        return helper(head, null);
    }

    public static void main(String[] args) {
        ListNode node = new ListNode(-10);
        node.next = new ListNode(-3);
        node.next.next = new ListNode(0);
        node.next.next.next = new ListNode(5);
        node.next.next.next.next = new ListNode(9);

        sortedListToBST(node);
    }
}

// Time Complexity - O(NlogN)
// Space Complexity - O(logN)