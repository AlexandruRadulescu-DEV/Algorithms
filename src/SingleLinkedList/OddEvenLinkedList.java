package SingleLinkedList;

public class OddEvenLinkedList {

    static void main() {

    }

    public ListNode oddEvenList(ListNode head) {

        ListNode oddDummy = new ListNode(0), evenDummy = new ListNode(0);
        ListNode oddTail = oddDummy, evenTail = evenDummy;
        ListNode curr = head;
        int index = 1;

        while (curr != null) {
            if (index % 2 == 1) {
                oddTail.next = curr;
                oddTail = curr;
            } else {
                evenTail.next = curr;
                evenTail = curr;
            }
            curr = curr.next;
            index++;
        }

        evenTail.next = null;
        oddTail.next = evenDummy.next;
        return oddDummy.next;




    }
}
