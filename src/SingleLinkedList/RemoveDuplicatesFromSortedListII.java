package SingleLinkedList;

import java.util.HashSet;
import java.util.Set;

public class RemoveDuplicatesFromSortedListII {
    static void main() {
        RemoveDuplicatesFromSortedListII sol = new RemoveDuplicatesFromSortedListII();
        int[][][] teste = {
                // { lista sortată, output așteptat (rămân doar valorile care apar o singură dată) }
                {{1, 2, 3, 3, 4, 4, 5}, {1, 2, 5}},          // exemplul 1
                {{1, 1, 1, 2, 3}, {2, 3}},                   // exemplul 2: se șterge head-ul
                {{}, {}},                                    // listă goală
                {{1}, {1}},                                  // un singur nod
                {{1, 1}, {}},                                // o pereche -> nu rămâne nimic
                {{5, 5, 5, 5}, {}},                          // toate identice
                {{1, 2, 3}, {1, 2, 3}},                      // fără duplicate
                {{1, 2, 3, 3}, {1, 2}},                      // duplicate la final
                {{1, 2, 2, 3}, {1, 3}},                      // duplicate la mijloc
                {{1, 1, 2, 2, 3, 3}, {}},                    // doar perechi
                {{1, 1, 2, 3, 3}, {2}},                      // rămâne doar mijlocul
                {{1, 2, 2, 3, 3, 4}, {1, 4}},                // grupuri consecutive de duplicate
                {{-3, -3, -1, 0, 0, 2}, {-1, 2}},            // valori negative și 0
                {{-100, -100, 0, 100, 100}, {0}},            // valori la limită
                {{0, 0, 0, 1}, {1}},
        };

        int ok = 0;
        for (int[][] t : teste) {
            int[] input = t[0];
            int[] asteptat = t[1];

            String rezultatStr;
            boolean pass;
            try {
                int[] rezultat = SinglyList.toArray(sol.deleteDuplicates(SinglyList.build(input)));
                pass = java.util.Arrays.equals(rezultat, asteptat);
                rezultatStr = java.util.Arrays.toString(rezultat);
            } catch (Exception e) {
                pass = false;
                rezultatStr = e.getClass().getSimpleName();
            }
            if (pass) ok++;
            System.out.println((pass ? "PASS" : "FAIL") + "  " + java.util.Arrays.toString(input)
                    + " -> " + rezultatStr
                    + (pass ? "" : "  (așteptat " + java.util.Arrays.toString(asteptat) + ")"));
        }
        System.out.println("\n" + ok + "/" + teste.length + " teste trecute");
    }
    public ListNode deleteDuplicates(ListNode head) {

        ListNode dummy = new ListNode(0, head);
        ListNode current = dummy;

        while (current.next != null && current.next.next != null) {
            if (current.next.val == current.next.next.val) {
                int dup = current.next.val;
                while (current.next != null && current.next.val == dup) {
                    current.next = current.next.next;
                }
            } else {
                current = current.next;
            }
        }

        return dummy.next;
    }
}
