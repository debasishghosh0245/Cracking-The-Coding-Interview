package LeetCode;

public class LinkedListCycleII_142 {
    public static void main(String[] args) {
        SinglyLinkedList linkedList = new SinglyLinkedList();
        SinglyLinkedListNode commonNode = new SinglyLinkedListNode(5);
        linkedList.insertAtTail(new SinglyLinkedListNode(1));
        linkedList.insertAtTail(new SinglyLinkedListNode(2));
        linkedList.insertAtTail(new SinglyLinkedListNode(3));
        linkedList.insertAtTail(new SinglyLinkedListNode(4));
        linkedList.insertAtTail(commonNode);
        linkedList.insertAtTail(new SinglyLinkedListNode(6));
        linkedList.insertAtTail(new SinglyLinkedListNode(7));
        linkedList.insertAtTail(commonNode);
        System.out.println("Cycle in the LinkedList " + detectCycle(linkedList.head).data);
    }

    public static SinglyLinkedListNode detectCycle(SinglyLinkedListNode head) {
        SinglyLinkedListNode hareNode = head;
        SinglyLinkedListNode tortoiseNode = head;
        while (hareNode != null && hareNode.next != null) {
            tortoiseNode = tortoiseNode.next;
            hareNode = hareNode.next.next;
            if (tortoiseNode == hareNode) {
                break;
            }
        }
        if (hareNode == null || hareNode.next == null || tortoiseNode == null) {
            return null;
        }
        tortoiseNode = head;
        while (tortoiseNode != null && hareNode != null && tortoiseNode != hareNode) {
            tortoiseNode = tortoiseNode.next;
            hareNode = hareNode.next;
        }
        return tortoiseNode;
    }
}
