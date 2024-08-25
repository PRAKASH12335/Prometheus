package LinkedList.Easy;

// 141. Linked List Cycle

public class L141 {
    public boolean hasCycle(ListNode head) {
        ListNode slow = head, fast = head;
        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
            if(slow == fast)
                return true;
        }
        return false;
    }

    public static void main(String[] args) {
        ListNode l1 = new ListNode(1);
        l1.next = new ListNode(2);
        l1.next.next = new ListNode(3);
        l1.next.next.next = new ListNode(4);
        l1.next.next.next.next = new ListNode(5);
        l1.next.next.next.next.next= l1.next.next;
        L141 obj = new L141();
        System.out.println(obj.hasCycle(l1));
    }
}

// Time Complexity - O(N)
// Space Complexity - O(1)