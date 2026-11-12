package TwoPoitners;
//Given the head of a linked list, remove the nth node from the end of the list and return its head.
//
//
//
//Example 1:
//
//
//Input: head = [1,2,3,4,5], n = 2
//Output: [1,2,3,5]
//Example 2:
//
//Input: head = [1], n = 1
//Output: []
//Example 3:
//
//Input: head = [1,2], n = 1
//Output: [1]
public class RemoveNthNodeFromEndOfList {

    static void main() {
        RemoveNthNodeFromEndOfList sol = new RemoveNthNodeFromEndOfList();
        Object[][] teste = {
                // { lista, n, output așteptat }
                {new int[]{1, 2, 3, 4, 5}, 2, new int[]{1, 2, 3, 5}},     // exemplul 1
                {new int[]{1}, 1, new int[]{}},                           // exemplul 2
                {new int[]{1, 2}, 1, new int[]{1}},                       // exemplul 3
                {new int[]{1, 2}, 2, new int[]{2}},                       // se șterge head-ul
                {new int[]{1, 2, 3, 4, 5}, 5, new int[]{2, 3, 4, 5}},     // n = lungimea -> se șterge head-ul
                {new int[]{1, 2, 3, 4, 5}, 1, new int[]{1, 2, 3, 4}},     // se șterge ultimul nod
                {new int[]{1, 2, 3, 4, 5}, 3, new int[]{1, 2, 4, 5}},     // nodul din mijloc
                {new int[]{1, 2, 3, 4, 5}, 4, new int[]{1, 3, 4, 5}},     // al doilea nod
                {new int[]{1, 2, 3}, 2, new int[]{1, 3}},
                {new int[]{1, 2, 3, 4, 5, 6}, 3, new int[]{1, 2, 3, 5, 6}}, // listă pară
                {new int[]{7, 7, 7, 7}, 2, new int[]{7, 7, 7}},           // valori identice
                {new int[]{0, -1, -2, -3}, 4, new int[]{-1, -2, -3}},     // valori negative / zero
                {new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10}, 7, new int[]{1, 2, 3, 5, 6, 7, 8, 9, 10}},
                {new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10}, 10, new int[]{2, 3, 4, 5, 6, 7, 8, 9, 10}},
        };

        int ok = 0;
        for (Object[] t : teste) {
            int[] input = (int[]) t[0];
            int n = (int) t[1];
            int[] asteptat = (int[]) t[2];

            String rezultatText;
            boolean pass;
            try {
                int[] rezultat = toArray(sol.removeNthFromEnd(fromArray(input), n));
                pass = java.util.Arrays.equals(rezultat, asteptat);
                rezultatText = java.util.Arrays.toString(rezultat);
            } catch (Exception e) {
                pass = false;
                rezultatText = e.getClass().getSimpleName();
            }
            if (pass) ok++;
            System.out.println((pass ? "PASS" : "FAIL") + "  " + java.util.Arrays.toString(input)
                    + ", n=" + n + " -> " + rezultatText
                    + (pass ? "" : "  (așteptat " + java.util.Arrays.toString(asteptat) + ")"));
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

    // transformă lista înapoi în array, ca să o putem compara și afișa
    static int[] toArray(ListNode head) {
        java.util.List<Integer> list = new java.util.ArrayList<>();
        while (head != null) {
            list.add(head.val);
            head = head.next;
        }
        return list.stream().mapToInt(Integer::intValue).toArray();
    }

    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummy = new ListNode(0, head);
        ListNode fast = dummy;
        ListNode slow = dummy;

        for (int i = 0; i < n; i++) {
            fast = fast.next;
        }

        while (fast.next != null) {
            fast = fast.next;
            slow = slow.next;
        }

        slow.next = slow.next.next;
        return dummy.next;

    }
}
