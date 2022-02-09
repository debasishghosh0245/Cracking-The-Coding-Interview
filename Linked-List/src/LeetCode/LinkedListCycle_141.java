package LeetCode;

public class LinkedListCycle_141 {

    public static void main(String[] args) {
        SinglyLinkedList linkedList = new SinglyLinkedList();
        SinglyLinkedListNode node1=new SinglyLinkedListNode(1);
        SinglyLinkedListNode node2=new SinglyLinkedListNode(2);
        SinglyLinkedListNode node3=new SinglyLinkedListNode(3);
        SinglyLinkedListNode node4=new SinglyLinkedListNode(4);

        linkedList.insertAtTail(node1);
        linkedList.insertAtTail(node2);
        linkedList.insertAtTail(node3);
        linkedList.insertAtTail(node4);
        linkedList.insertAtTail(node2);
        System.out.println(hasCycle(linkedList.head));
    }

    public static boolean hasCycle(SinglyLinkedListNode head) {
        if (head == null)
            return false;
        SinglyLinkedListNode fast = head;
        SinglyLinkedListNode slow = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (fast == slow)  return true;
        }
        return false;
    }
}
