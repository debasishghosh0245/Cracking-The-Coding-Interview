package LeetCode;

public class RemoveNthNodeFromEndOfList_19 {
    public static void main(String[] args) {
        SinglyLinkedList linkedList = new SinglyLinkedList();
        linkedList.insertAtTail(1);
        linkedList.insertAtTail(2);
        linkedList.insertAtTail(3);
        linkedList.insertAtTail(4);
        linkedList.insertAtTail(5);
        SinglyLinkedListNode node = removeNthFromEnd(linkedList.head, 3);
        printLinkedList(node);
    }

    public static SinglyLinkedListNode removeNthFromEnd(SinglyLinkedListNode head, int n) {
        SinglyLinkedListNode dummyNode=new SinglyLinkedListNode(0);
        dummyNode.next=head;
        if (head == null || head.next==null) return null;
        SinglyLinkedListNode fastRunner = dummyNode;
        SinglyLinkedListNode slowRunner = dummyNode;
        while (fastRunner != null && n --> 0) {
            fastRunner = fastRunner.next;
        }
        while (fastRunner != null && fastRunner.next != null) {
            fastRunner = fastRunner.next;
            slowRunner = slowRunner.next;
        }
        slowRunner.next = slowRunner.next.next;
        return dummyNode.next;
    }

    public static SinglyLinkedListNode removeNthFromEndRecursion(SinglyLinkedListNode head, int n, IntegerValue count) {
        // SinglyLinkedListNode tempNode=null;
        if (head == null)   return null; // base case return null from call stack
        removeNthFromEndRecursion(head.next, n, count);
        count.count++;
        if (count.count == n + 1) {
            head.next = head.next.next;
        }
        return head;
    }

    public static void printLinkedList(SinglyLinkedListNode head) {
        SinglyLinkedListNode currentNode = head;
        while (currentNode != null) {
            System.out.println(currentNode.data);
            currentNode = currentNode.next;
        }
    }

}

class IntegerValue {
    int count;

    IntegerValue() {
        count = 0;
    }
}
