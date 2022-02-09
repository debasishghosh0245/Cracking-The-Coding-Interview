package LeetCode;

public class IntersectionOfTwoLinkedLists160 {
    public static void main(String[] args) {
        // listA = [4,1,8,4,5], listB = [5,6,1,8,4,5]
        SinglyLinkedList singlyLinkedListA = new SinglyLinkedList();
        SinglyLinkedList singlyLinkedListB = new SinglyLinkedList();
        SinglyLinkedListNode node8 = new SinglyLinkedListNode(8);

        singlyLinkedListA.insertAtTail(1);
        singlyLinkedListA.insertAtTail(2);
        singlyLinkedListA.insertAtTail(3);
        singlyLinkedListA.insertAtTail(node8);
        singlyLinkedListA.insertAtTail(7);
        singlyLinkedListA.insertAtTail(8);

        singlyLinkedListB.insertAtTail(4);
        singlyLinkedListB.insertAtTail(5);
        singlyLinkedListB.insertAtTail(6);
        singlyLinkedListB.insertAtTail(node8);
        singlyLinkedListA.insertAtTail(9);

        System.out.println(getIntersectionNode(singlyLinkedListA.head, singlyLinkedListB.head).data);
    }

    private static SinglyLinkedListNode getIntersectionNode(SinglyLinkedListNode head1, SinglyLinkedListNode head2) {
        SinglyLinkedListNode fastPointer = head1;
        SinglyLinkedListNode slowPointer = head2;
        if(head1==null || head2==null) return null ;
        while (fastPointer != slowPointer) {
            fastPointer = fastPointer == null ? fastPointer = head2 : fastPointer.next;
            slowPointer = slowPointer == null ? slowPointer = head1 : slowPointer.next;
        }
        return fastPointer;
    }
}
