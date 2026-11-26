package SingleLinkedList;

public class SwapNodesInPairs {


    public ListNode swapPairs(ListNode head) {
        ListNode dummy = new ListNode(0,head);
        ListNode before = dummy;

        while(before.next!=null && before.next.next !=null){
            ListNode first = before.next;
            ListNode second = first.next;

            first.next = second.next;
            second.next = first;
            before.next = second;

            before = first;
        }

        return dummy.next;
}
}
