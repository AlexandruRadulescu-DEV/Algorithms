package SingleLinkedList;


// Remove Linked List Elements
//Easy
//Topics
//premium lock icon
//Companies
//Given the head of a linked list and an integer val, remove all the nodes of the linked list that has Node.val == val, and return the new head.
//
//
//
//Example 1:
//
//
//Input: head = [1,2,6,3,4,5,6], val = 6
//Output: [1,2,3,4,5]
//Example 2:
//
//Input: head = [], val = 1
//Output: []
//Example 3:
//
//Input: head = [7,7,7,7], val = 7
//Output: []
public class RemoveLinkedListElements {

    static void main() {
        RemoveLinkedListElements sol = new RemoveLinkedListElements();
        int[][][] teste = {
                // { lista, {val}, output așteptat }
                {{1, 2, 6, 3, 4, 5, 6}, {6}, {1, 2, 3, 4, 5}},   // exemplul 1
                {{}, {1}, {}},                                   // exemplul 2: listă goală
                {{7, 7, 7, 7}, {7}, {}},                         // exemplul 3: toate se șterg
                {{1, 2, 3}, {4}, {1, 2, 3}},                     // val nu există
                {{1}, {1}, {}},                                  // un singur nod, se șterge
                {{1}, {2}, {1}},                                 // un singur nod, rămâne
                {{6, 1, 2}, {6}, {1, 2}},                        // șterge head-ul
                {{6, 6, 1, 2}, {6}, {1, 2}},                     // mai multe la început
                {{1, 2, 6}, {6}, {1, 2}},                        // șterge ultimul nod
                {{1, 6, 6, 6, 2}, {6}, {1, 2}},                  // consecutive la mijloc
                {{6, 1, 6, 2, 6}, {6}, {1, 2}},                  // alternante
                {{0, 1, 0}, {0}, {1}},                           // val = 0
                {{1, 2, 2, 1}, {2}, {1, 1}},
                {{50, 1, 50}, {50}, {1}},                        // val maxim (Node.val <= 50)
        };

        int ok = 0;
        for (int[][] t : teste) {
            int[] input = t[0];
            int val = t[1][0];
            int[] asteptat = t[2];

            String rezultatStr;
            boolean pass;
            try {
                int[] rezultat = SinglyList.toArray(sol.removeElements(SinglyList.build(input), val));
                pass = java.util.Arrays.equals(rezultat, asteptat);
                rezultatStr = java.util.Arrays.toString(rezultat);
            } catch (Exception e) {
                pass = false;
                rezultatStr = e.getClass().getSimpleName();
            }
            if (pass) ok++;
            System.out.println((pass ? "PASS" : "FAIL") + "  " + java.util.Arrays.toString(input)
                    + ", val=" + val + " -> " + rezultatStr
                    + (pass ? "" : "  (așteptat " + java.util.Arrays.toString(asteptat) + ")"));
        }
        System.out.println("\n" + ok + "/" + teste.length + " teste trecute");
    }


    public ListNode removeElements(ListNode head, int val) {

        ListNode dummy = new ListNode(0,head);
        ListNode current = dummy;

        while(current.next!=null){
            if(current.next.val == val){
                current.next=current.next.next;
            }
            else{
                current=current.next;
            }
        }
        return dummy.next;
    }

}
