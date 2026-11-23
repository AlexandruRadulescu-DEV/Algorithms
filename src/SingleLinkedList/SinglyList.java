package SingleLinkedList;

/**
 * Singly linked list with a head and a tail pointer.
 *
 *   head                     tail
 *    |                        |
 *   [1] -> [2] -> [3] -> [4] -> null
 *
 * - head: first node (null when the list is empty)
 * - tail: last node, so addLast is O(1) instead of walking the whole list
 * - size: number of nodes
 *
 * LeetCode methods receive / return a ListNode head, so use:
 *   SinglyList.build(1, 2, 3)   -> ListNode head ready to pass to a solution
 *   SinglyList.toArray(head)    -> int[] to compare with the expected result
 *   SinglyList.print(head)      -> "1 -> 2 -> 3"
 */
public class SinglyList {
    ListNode head;
    ListNode tail;
    int size;

    SinglyList() {
    }

    static SinglyList fromArray(int... values) {
        SinglyList list = new SinglyList();
        for (int v : values) {
            list.addLast(v);
        }
        return list;
    }

    boolean isEmpty() {
        return size == 0;
    }

    // O(1)
    void addFirst(int val) {
        ListNode node = new ListNode(val, head);
        head = node;
        if (tail == null) {        // list was empty -> the new node is also the last
            tail = node;
        }
        size++;
    }

    // O(1) thanks to tail
    void addLast(int val) {
        ListNode node = new ListNode(val);
        if (tail == null) {        // list was empty
            head = node;
        } else {
            tail.next = node;
        }
        tail = node;
        size++;
    }

    // O(1)
    int removeFirst() {
        if (head == null) {
            throw new IllegalStateException("list is empty");
        }
        int val = head.val;
        head = head.next;
        if (head == null) {        // removed the only node
            tail = null;
        }
        size--;
        return val;
    }

    // O(n): singly list has no prev, so we must find the node before tail
    int removeLast() {
        if (head == null) {
            throw new IllegalStateException("list is empty");
        }
        int val = tail.val;
        if (head == tail) {        // only one node
            head = null;
            tail = null;
        } else {
            ListNode cur = head;
            while (cur.next != tail) {
                cur = cur.next;
            }
            cur.next = null;
            tail = cur;
        }
        size--;
        return val;
    }

    int[] toArray() {
        return toArray(head);
    }

    @Override
    public String toString() {
        return print(head);
    }

    // ---------- helpers for LeetCode-style solutions (work on a bare ListNode head) ----------

    // {1, 2, 3} -> 1 -> 2 -> 3, returns the head
    static ListNode build(int... values) {
        return fromArray(values).head;
    }

    static int[] toArray(ListNode head) {
        int n = 0;
        for (ListNode cur = head; cur != null; cur = cur.next) n++;
        int[] result = new int[n];
        int i = 0;
        for (ListNode cur = head; cur != null; cur = cur.next) result[i++] = cur.val;
        return result;
    }

    static String print(ListNode head) {
        if (head == null) return "null";
        StringBuilder sb = new StringBuilder();
        for (ListNode cur = head; cur != null; cur = cur.next) {
            sb.append(cur.val);
            if (cur.next != null) sb.append(" -> ");
        }
        return sb.toString();
    }

    static void main() {
        SinglyList list = SinglyList.fromArray(2, 3);
        list.addFirst(1);
        list.addLast(4);
        System.out.println(list + "   (head=" + list.head.val + ", tail=" + list.tail.val + ", size=" + list.size + ")");

        list.removeFirst();
        list.removeLast();
        System.out.println(list + "   (head=" + list.head.val + ", tail=" + list.tail.val + ", size=" + list.size + ")");

        ListNode head = SinglyList.build(5, 6, 7);
        System.out.println(SinglyList.print(head) + "   " + java.util.Arrays.toString(SinglyList.toArray(head)));
    }
}
