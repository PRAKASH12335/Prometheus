package LinkedList.Medium;

class RandomNode {
    int val;
    RandomNode next;
    RandomNode random;

    public RandomNode(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}

public class L138 {

    public static RandomNode copyRandomList(RandomNode head){
        if(head == null)
            return null;
        RandomNode A = head;
        while(head != null){
            RandomNode temp = head.next;
            head.next = new RandomNode(head.val);
            head.next.next = temp;
            head = head.next.next;
        }
        head = A;
        while(head != null){
            if(head.next != null){
                head.next.random = head.random != null ? head.random.next : head.random;
            }
            head = head.next != null ? head.next.next : head.next;
        }

        head = A;
        RandomNode copy = head.next;
        RandomNode original = head;
        RandomNode temp = copy;
        while(original != null && copy != null){
            original.next = original.next != null ? original.next.next : original.next;
            original = original.next;
            copy.next = copy.next != null ? copy.next.next : copy.next;
            copy = copy.next;
        }
        return temp;
    }

//Time Complexity - O(N)+O(N)+O(N)
//Reason: Each step takes O(N) of time complexity.
//Space Complexity - O(1)

    public static void printList(RandomNode node){
        while(node.next != null){
            System.out.print(node.val + " -> ");
            node = node.next;
        }
        System.out.print(node.val);
        System.out.println();
    }

    public static void main(String[] args) {
        RandomNode node1 = new RandomNode(1);
        RandomNode node2 = new RandomNode(2);
        RandomNode node3 = new RandomNode(3);
        RandomNode node4 = new RandomNode(4);
        RandomNode head = null;
        head = node1;
        head.next = node2;
        head.next.next = node3;
        head.next.next.next = node4;

        head.random = node4;
        head.next.random = node1;
        head.next.next.random = null;
        head.next.next.next.random = node2;

        System.out.println("Original list:(current node:node pointed by next pointer, node pointed by random pointer)");
        printList(head);

        System.out.println("Copy list:(current node:node pointed by next pointer,node pointed by random pointer)");
        RandomNode newHead = copyRandomList(head);
        printList(newHead);
    }
}
