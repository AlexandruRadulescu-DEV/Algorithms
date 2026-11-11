package TwoPoitners;

//Given head, the head of a linked list, determine if the linked list has a cycle in it.
//
//There is a cycle in a linked list if there is some node in the list that can be reached again by continuously following the next pointer. Internally, pos is used to denote the index of the node that tail's next pointer is connected to. Note that pos is not passed as a parameter.
//
//Return true if there is a cycle in the linked list. Otherwise, return false.
//
//
//
//Example 1:
//
//
//Input: head = [3,2,0,-4], pos = 1
//Output: true
//Explanation: There is a cycle in the linked list, where the tail connects to the 1st node (0-indexed).
//Example 2:
//
//
//Input: head = [1,2], pos = 0
//Output: true
//Explanation: There is a cycle in the linked list, where the tail connects to the 0th node.
//Example 3:
//
//
//Input: head = [1], pos = -1
//Output: false
//Explanation: There is no cycle in the linked list.
public class LinkedListCycle {

    static void main() {
        LinkedListCycle sol = new LinkedListCycle();
        Object[][] teste = {
                // { lista, pos, output așteptat }
                {new int[]{3, 2, 0, -4}, 1, true},         // exemplul 1
                {new int[]{1, 2}, 0, true},                // exemplul 2
                {new int[]{1}, -1, false},                 // exemplul 3
                {new int[]{}, -1, false},                  // listă goală (head = null)
                {new int[]{1}, 0, true},                   // un nod care arată spre el însuși
                {new int[]{1, 2}, -1, false},              // par, fără ciclu
                {new int[]{1, 2, 3}, -1, false},           // impar, fără ciclu
                {new int[]{1, 2, 3, 4}, -1, false},
                {new int[]{1, 2, 3, 4, 5}, 0, true},       // ciclul e toată lista
                {new int[]{1, 2, 3, 4, 5}, 4, true},       // ultimul nod arată spre el însuși
                {new int[]{1, 2, 3, 4, 5, 6}, 3, true},    // ciclu la mijloc
                {new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10}, 2, true},
                {new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10}, -1, false},
                {new int[]{5, 5, 5, 5}, -1, false},        // valori identice, fără ciclu
                {new int[]{5, 5, 5, 5}, 2, true},          // valori identice, cu ciclu
        };

        int ok = 0;
        for (Object[] t : teste) {
            int[] values = (int[]) t[0];
            int pos = (int) t[1];
            boolean asteptat = (boolean) t[2];

            boolean rezultat = sol.hasCycle(build(values, pos));
            boolean pass = rezultat == asteptat;
            if (pass) ok++;
            System.out.println((pass ? "PASS" : "FAIL") + "  " + java.util.Arrays.toString(values)
                    + ", pos=" + pos + " -> " + rezultat
                    + (pass ? "" : "  (așteptat " + asteptat + ")"));
        }
        System.out.println("\n" + ok + "/" + teste.length + " teste trecute");
    }

    // construiește lista și, dacă pos != -1, leagă ultimul nod de nodul de la indexul pos
    static ListNode build(int[] values, int pos) {
        if (values.length == 0) return null;
        ListNode[] nodes = new ListNode[values.length];
        for (int i = 0; i < values.length; i++) {
            nodes[i] = new ListNode(values[i]);
            if (i > 0) nodes[i - 1].next = nodes[i];
        }
        if (pos != -1) {
            nodes[values.length - 1].next = nodes[pos];
        }
        return nodes[0];
    }


    public boolean hasCycle(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {
                return true;
            }
        }
        return false;
    }
}
