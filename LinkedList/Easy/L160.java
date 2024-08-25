package LinkedList.Easy;

// 160. Intersection of Two Linked Lists

public class L160 {

    private int length(ListNode head){
        int len = 0;
        while(head != null){
            len++;
            head = head.next;
        }
        return len;
    }

    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        int m = length(headA);
        int n = length(headB);
        if(n > m){
            return getIntersectionNode(headB, headA);
        }
        int d = m - n;
        for(int i=0;i<d;i++){
            headA = headA.next;
        }
        while(headA != null && headB != null){
            if(headA == headB)
                return headA;
            headA = headA.next;
            headB = headB.next;
        }
        return null;
    }

    public static void main(String[] args) {
        int intersectVal = 8;
        ListNode listA = new ListNode(4);
        listA.next = new ListNode(1);
        listA.next.next = new ListNode(8);
        listA.next.next.next = new ListNode(4);
        listA.next.next.next.next = new ListNode(5);

        ListNode listB = new ListNode(4);
        listB.next = new ListNode(2);
        listB.next.next = new ListNode(5);
        listB.next.next.next = listA.next.next;

        L160 obj = new L160();
        System.out.println(obj.getIntersectionNode(listA, listB));
    }
}

// Time Complexity - O(N)
// Space Complexity - O(1)