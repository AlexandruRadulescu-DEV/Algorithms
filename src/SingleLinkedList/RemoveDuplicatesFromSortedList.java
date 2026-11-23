package SingleLinkedList;

import java.util.HashSet;
import java.util.Set;

public class RemoveDuplicatesFromSortedList {
    static void main() {
        RemoveDuplicatesFromSortedList sol = new RemoveDuplicatesFromSortedList();
        int[][][] teste = {
                // { lista sortată, output așteptat }
                {{1, 1, 2}, {1, 2}},                         // exemplul 1
                {{1, 1, 2, 3, 3}, {1, 2, 3}},                // exemplul 2
                {{}, {}},                                    // listă goală
                {{1}, {1}},                                  // un singur nod
                {{1, 2, 3}, {1, 2, 3}},                      // fără duplicate
                {{5, 5, 5, 5}, {5}},                         // toate identice
                {{1, 1, 1, 2, 3}, {1, 2, 3}},                // duplicate la început
                {{1, 2, 3, 3, 3}, {1, 2, 3}},                // duplicate la final
                {{1, 2, 2, 2, 3}, {1, 2, 3}},                // duplicate la mijloc
                {{1, 1, 2, 2, 3, 3}, {1, 2, 3}},             // perechi peste tot
                {{-3, -3, -1, 0, 0, 2}, {-3, -1, 0, 2}},     // valori negative și 0
                {{-100, -100, 100, 100}, {-100, 100}},       // valori la limită
                {{0, 0}, {0}},
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
        ListNode dummy = new ListNode(0,head);
        ListNode current = dummy;
        Set<Integer> container = new HashSet<>();
        while(current.next!=null){
            if(container.contains(current.next.val)){
                current.next=current.next.next;
            }else{
                container.add(current.next.val);
                current = current.next;
            }
        }

        return dummy.next;

    }
}
