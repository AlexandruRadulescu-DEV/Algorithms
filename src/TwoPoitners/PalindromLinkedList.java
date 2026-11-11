package TwoPoitners;
//Given the head of a singly linked list, return true if it is a palindrome or false otherwise.
//
//
//
//Example 1:
//
//
//Input: head = [1,2,2,1]
//Output: true
//Example 2:
//
//
//Input: head = [1,2]
//Output: false
public class PalindromLinkedList {

    static void main() {
        PalindromLinkedList sol = new PalindromLinkedList();
        Object[][] teste = {
                // { lista, output așteptat }
                {new int[]{1, 2, 2, 1}, true},           // exemplul 1 (par)
                {new int[]{1, 2}, false},                // exemplul 2
                {new int[]{1}, true},                    // un singur nod
                {new int[]{1, 1}, true},
                {new int[]{1, 2, 1}, true},              // impar
                {new int[]{1, 2, 3}, false},
                {new int[]{1, 2, 3, 2, 1}, true},
                {new int[]{1, 2, 3, 3, 2, 1}, true},
                {new int[]{1, 2, 3, 4, 2, 1}, false},    // diferă doar la mijloc
                {new int[]{1, 2, 3, 2, 2}, false},       // diferă doar la capăt
                {new int[]{2, 2, 3, 2, 1}, false},       // diferă doar la început
                {new int[]{1, 1, 2, 1}, false},          // aproape palindrom
                {new int[]{7, 7, 7, 7, 7}, true},        // toate egale
                {new int[]{0, 9, 9, 0}, true},
                {new int[]{1, 0, 0}, false},
        };

        int ok = 0;
        for (Object[] t : teste) {
            int[] values = (int[]) t[0];
            boolean asteptat = (boolean) t[1];

            boolean rezultat = sol.isPalindrome(fromArray(values));
            boolean pass = rezultat == asteptat;
            if (pass) ok++;
            System.out.println((pass ? "PASS" : "FAIL") + "  " + java.util.Arrays.toString(values)
                    + " -> " + rezultat
                    + (pass ? "" : "  (așteptat " + asteptat + ")"));
        }
        System.out.println("\n" + ok + "/" + teste.length + " teste trecute");
    }

    // construiește o listă înlănțuită din array: {1,2,3} -> 1 -> 2 -> 3
    static ListNode fromArray(int[] values) {
        ListNode dummy = new ListNode();
        ListNode cur = dummy;
        for (int v : values) {
            cur.next = new ListNode(v);
            cur = cur.next;
        }
        return dummy.next;
    }

    public boolean isPalindrome(ListNode head) {
        ListNode aux = copyList(head);
        aux = reverseLinkedList(aux);
        while (head != null && head.next != null) {
            int val = head.val;
            int valReversed = aux.val;
            if (val != valReversed) {
                return false;
            } else {
                head = head.next;
                aux = aux.next;
            }
        }
        return true;
    }

    private ListNode reverseLinkedList(ListNode head) {
        ListNode previous = null;
        while (head != null) {
            ListNode next = head.next;
            head.next = previous;
            previous = head;
            head = next;
        }
        return previous;
    }

    private ListNode copyList(ListNode head) {
        ListNode dummy = new ListNode();   // fake start node, makes adding easier
        ListNode cur = dummy;
        while (head != null) {
            cur.next = new ListNode(head.val);  // new node, same value
            cur = cur.next;
            head = head.next;
        }
        return dummy.next;                 // skip the fake start node
    }
}

