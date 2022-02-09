package LeetCode;

import java.util.*;

public class PalindromeLinkedList_234 {
    public static void main(String[] args) {
        SinglyLinkedList linkedList = new SinglyLinkedList();
        linkedList.insertAtTail(1);
        linkedList.insertAtTail(2);
        linkedList.insertAtTail(3);
        linkedList.insertAtTail(2);
        linkedList.insertAtTail(1);
        linkedList.printLinkedList();
        System.out.println(isPalindrome(linkedList.head));
    }

    public static boolean isPalindrome(SinglyLinkedListNode head) {
        if (head == null || head.next==null) return true;
        SinglyLinkedListNode hare = head;
        SinglyLinkedListNode tortoise = head;
        Stack<Integer> stack = new Stack<>();
        while (hare != null && hare.next != null) {
            stack.push(tortoise.data);
            tortoise = tortoise.next;
            hare = hare.next.next;
        }
        if (hare != null) {
            tortoise = tortoise.next;
        }
        while (!stack.isEmpty()) {
            if (stack.pop() != tortoise.data) return false;
            tortoise = tortoise.next;
        }
        return true;
    }
}
