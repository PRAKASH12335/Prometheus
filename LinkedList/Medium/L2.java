package LinkedList.Medium;

// 2. Add Two Numbers

class ListNode{
    int data;
    ListNode next;
    ListNode(int data){
        this.data = data;
    }
}

public class L2 {

    public static ListNode addTwoNumbers(ListNode l1, ListNode l2){
        if(l1 == null) return l2;
        if(l2 == null) return l1;
        int carry = 0, sum = 0;
        ListNode start = new ListNode(0);
        ListNode dummy = start;
        while(l1 != null || l2 != null){
            sum = carry;
            if(l1 != null){
                sum += l1.data;
                l1 = l1.next;
            }
            if(l2 != null){
                sum += l2.data;
                l2 = l2.next;
            }
            dummy.next = new ListNode(sum%10);
            dummy = dummy.next;
            carry = sum/10;
        }
        if(carry == 1){
            dummy.next = new ListNode(1);
        }
        return start.next;
    }

    public static void main(String[] args) {
        ListNode l1 = new ListNode(2);
        l1.next = new ListNode(4);
        l1.next.next = new ListNode(3);
        ListNode l2 = new ListNode(5);
        l2.next = new ListNode(6);

        // 342 + 65 = 407

        ListNode result = addTwoNumbers(l1, l2);
        while(result != null){
            System.out.print(result.data);
            result = result.next;
        }
    }
}

// Time Complexity - O(N)
// Space Complexity - O(N)