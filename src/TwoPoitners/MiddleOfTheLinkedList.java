package TwoPoitners;

public class MiddleOfTheLinkedList {
    static void main() {
        MiddleOfTheLinkedList sol = new MiddleOfTheLinkedList();
        int[][][] teste = {
                // { lista, output așteptat (lista de la mijloc până la final) }
                {{1, 2, 3, 4, 5}, {3, 4, 5}},          // impar
                {{1, 2, 3, 4, 5, 6}, {4, 5, 6}},       // par -> al doilea mijloc
                {{1}, {1}},                            // un singur nod
                {{1, 2}, {2}},                         // două noduri
                {{1, 2, 3}, {2, 3}},
                {{1, 2, 3, 4}, {3, 4}},
                {{7, 7, 7, 7}, {7, 7}},                // valori identice
                {{-5, 0, 5}, {0, 5}},                  // valori negative
                {{1, 2, 3, 4, 5, 6, 7, 8, 9, 10}, {6, 7, 8, 9, 10}},
                {{1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11}, {6, 7, 8, 9, 10, 11}},
        };

        int ok = 0;
        for (int[][] t : teste) {
            int[] input = t[0];
            int[] asteptat = t[1];

            int[] rezultat = toArray(sol.middleNode(fromArray(input)));
            boolean pass = java.util.Arrays.equals(rezultat, asteptat);
            if (pass) ok++;
            System.out.println((pass ? "PASS" : "FAIL") + "  " + java.util.Arrays.toString(input)
                    + " -> " + java.util.Arrays.toString(rezultat)
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

    public ListNode middleNode(ListNode head) {

        ListNode aux = head;
        int counter = 0;
        while(aux!=null){
            aux = aux.next;
            counter++;
        }

        counter = counter / 2;
        while (counter > 0) {
            head = head.next;
            counter--;
        }
        return head;

    }


}
