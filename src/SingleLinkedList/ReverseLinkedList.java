package SingleLinkedList;

public class ReverseLinkedList {
    static void main() {
        ReverseLinkedList sol = new ReverseLinkedList();
        int[][][] teste = {
                // { lista, output așteptat }
                {{1, 2, 3, 4, 5}, {5, 4, 3, 2, 1}},          // exemplul 1
                {{1, 2}, {2, 1}},                            // exemplul 2
                {{}, {}},                                    // exemplul 3: listă goală
                {{1}, {1}},                                  // un singur nod
                {{1, 2, 3}, {3, 2, 1}},
                {{7, 7, 7}, {7, 7, 7}},                      // valori identice
                {{-5, 0, 5}, {5, 0, -5}},                    // valori negative
                {{1, 2, 3, 4, 5, 6}, {6, 5, 4, 3, 2, 1}},    // număr par de noduri
        };

        int ok = 0;
        for (int[][] t : teste) {
            int[] input = t[0];
            int[] asteptat = t[1];

            String rezultatStr;
            boolean pass;
            try {
                int[] rezultat = SinglyList.toArray(sol.reverseList(SinglyList.build(input)));
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

    public ListNode reverseList(ListNode head) {
        ListNode prev = null;
        ListNode cur = head;

        while (cur != null) {
            ListNode next = cur.next; // 1. salvez restul listei
            cur.next = prev;          // 2. întorc săgeata
            prev = cur;               // 3. prev avansează
            cur = next;               // 4. cur avansează pe nodul salvat
        }

        return prev; // cur e null, prev e pe ultimul nod original = noul head
    }

}
