package LeetCode;

public class MergeTwoSortedLists_21 {

    public static void main(String[] args) {

        SinglyLinkedList singlyLinkedList1 = new SinglyLinkedList();
        singlyLinkedList1.insertAtTail(1);
        singlyLinkedList1.insertAtTail(2);
        singlyLinkedList1.insertAtTail(4);

        SinglyLinkedList singlyLinkedList2 = new SinglyLinkedList();
        singlyLinkedList2.insertAtTail(1);
        singlyLinkedList2.insertAtTail(3);
        singlyLinkedList2.insertAtTail(4);

        SinglyLinkedListNode mergeNode = mergeTwoListsII(singlyLinkedList1.head, singlyLinkedList2.head);
        // Print SinglyLinkedList
        printLinkedList(mergeNode);

    }

    public static SinglyLinkedListNode mergeTwoLists(SinglyLinkedListNode l1, SinglyLinkedListNode l2) {
        SinglyLinkedListNode head = new SinglyLinkedListNode(0);
        if (l1 == null) {
            return l2;
        }
        if (l2 == null) {
            return l1;
        }
        if (l1.data < l2.data) {
            head = l1;
            head.next = mergeTwoLists(l1.next, l2);
        } else {
            head = l2;
            head.next = mergeTwoLists(l1, l2.next);
        }
        return head;
    }

    public static SinglyLinkedListNode mergeTwoListsII(SinglyLinkedListNode l1, SinglyLinkedListNode l2) {
        SinglyLinkedListNode newList = new SinglyLinkedListNode(0);
        SinglyLinkedListNode tempList = newList;
        while (l1 != null && l2 != null) {
            if (l1.data < l2.data) {
                tempList.next = new SinglyLinkedListNode(l1.data);
                l1 = l1.next;
            } else {
                tempList.next = new SinglyLinkedListNode(l2.data);
                l2 = l2.next;
            }
            tempList = tempList.next;
        }
        if (l1 == null)   tempList.next = l2;
        if (l2 == null)   tempList.next = l1;
        return newList.next;
    }

    public static void printLinkedList(SinglyLinkedListNode head) {
        SinglyLinkedListNode currentNode = head;
        while (currentNode != null) {
            System.out.print(currentNode.data + "  ");
            currentNode = currentNode.next;
        }
        System.out.println(" ");
    }

}
