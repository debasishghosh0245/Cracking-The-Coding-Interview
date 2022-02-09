package LeetCode;


public class SwapNodesInPairs_24 {
    public static void main(String[] args) {
        SinglyLinkedList linkedList = new SinglyLinkedList();
        linkedList.insertAtTail(1);
        linkedList.insertAtTail(2);
        linkedList.insertAtTail(3);
        linkedList.insertAtTail(4);
        linkedList.insertAtTail(5);
        linkedList.insertAtTail(6);
        linkedList.insertAtTail(7);
        linkedList.insertAtTail(8);
        System.out.println("Print LinkedList before Pair Reverse");
        linkedList.printLinkedList();
        SinglyLinkedListNode newHead = swapPairs(linkedList.head);
        System.out.println("Print LinkedList After Pair Reversed.....");
        printLinkedList(newHead);
    }

    public static SinglyLinkedListNode swapPairs(SinglyLinkedListNode head) {
        // recurssive call//
        if (head == null || head.next == null) return head;
        else {
            SinglyLinkedListNode temp = head.next; // 2
            head.next = temp.next; // 1>3
            temp.next = head; //
            head = temp;
            head.next.next= swapPairs(head.next.next);
            return head;
        }
       
    }

    public static void printLinkedList(SinglyLinkedListNode node) {
        SinglyLinkedListNode currentNode = node;
        while (currentNode != null) {
            System.out.print(currentNode.data + "  ");
            currentNode = currentNode.next;
        }
    }
}
