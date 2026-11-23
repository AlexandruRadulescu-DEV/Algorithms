package SingleLinkedList;
//Given the head of a singly linked list and two integers left and right where left <= right, reverse the nodes of the list from position left to position right, and return the reversed list.
//
//
//
//Example 1:
//
//
//Input: head = [1,2,3,4,5], left = 2, right = 4
//Output: [1,4,3,2,5]
//Example 2:
//
//Input: head = [5], left = 1, right = 1
//Output: [5]
public class ReverseLinkedListII {

    static void main() {

    }

    public ListNode reverseBetween(ListNode head, int left, int right) {
    ListNode dummy = new ListNode(0,head);
    ListNode before = dummy;
    for(int i = 0; i< left -1; i++){
        before = before.next;
    }
    ListNode first = before.next;


    ListNode prev = null;
    ListNode current = first;
    for(int i = 0;i<right - left + 1 ; i++){
        ListNode next = current.next;
        current.next = prev;
        prev = current;
        current = next;

    }
    before.next = prev;
    first.next = current;


    return dummy.next;

    }
}
