# Singly Linked List

Java solutions to Singly Linked List problems from LeetCode.

> **Order: start here.** Do this folder first, then move on to [Doubly Linked List](../DoublyLinkedList/README.md).

**Progress: 0 / 15**

Status: ✅ solved · 🟡 in progress · ⏳ to do

> Already solved in [Two Pointers](../TwoPoitners/README.md) (fast & slow): 876 Middle of the Linked List, 141 Linked List Cycle, 142 Linked List Cycle II, 234 Palindrome Linked List, 19 Remove Nth Node From End of List.

## Structure

| File | What it is |
|------|------------|
| [ListNode.java](ListNode.java) | The node LeetCode uses: `val`, `next` |
| [SinglyList.java](SinglyList.java) | A list with `head`, `tail` and `size`: `addFirst`, `addLast`, `removeFirst`, `removeLast`, `toArray`, `toString` |

```
head                     tail
 |                        |
[1] -> [2] -> [3] -> [4] -> null
```

- `head` is the first node, `tail` the last one; both are `null` when the list is empty.
- Thanks to `tail`, `addLast` is O(1). `removeLast` is still O(n): there is no `prev`, so you have to walk to the node before `tail`.
- When the list goes from 0 → 1 node or 1 → 0 nodes, update **both** `head` and `tail`.

LeetCode solutions receive a bare `ListNode head`, so in your tests use the static helpers:

```java
ListNode head = SinglyList.build(1, 2, 3, 4, 5);   // 1 -> 2 -> 3 -> 4 -> 5
ListNode result = sol.reverseList(head);
int[] actual = SinglyList.toArray(result);        // compare with Arrays.equals
System.out.println(SinglyList.print(result));      // "5 -> 4 -> 3 -> 2 -> 1"
```

## 0. Build the structure

| # | Problem | Difficulty | File | Status |
|---|---------|------------|------|--------|
| 707 | [Design Linked List](https://leetcode.com/problems/design-linked-list/) (write it yourself with `head`/`tail`, then compare with `SinglyList`) | Medium | – | ⏳ |

## 1. Traversal & deletion (dummy node)

Walk the list with a `cur` pointer. When the head itself might be removed, put a `dummy` node before it and return `dummy.next`.

| # | Problem | Difficulty | File | Status |
|---|---------|------------|------|--------|
| 203 | [Remove Linked List Elements](https://leetcode.com/problems/remove-linked-list-elements/) | Easy | – | ⏳ |
| 83 | [Remove Duplicates from Sorted List](https://leetcode.com/problems/remove-duplicates-from-sorted-list/) | Easy | – | ⏳ |
| 82 | [Remove Duplicates from Sorted List II](https://leetcode.com/problems/remove-duplicates-from-sorted-list-ii/) | Medium | – | ⏳ |

## 2. Reversal

Three pointers `prev`, `cur`, `next`: save `cur.next`, point `cur.next` back to `prev`, then move both forward. Learn 206 by heart — most problems below reuse it.

| # | Problem | Difficulty | File | Status |
|---|---------|------------|------|--------|
| 206 | [Reverse Linked List](https://leetcode.com/problems/reverse-linked-list/) (iterative **and** recursive) | Easy | – | ⏳ |
| 92 | [Reverse Linked List II](https://leetcode.com/problems/reverse-linked-list-ii/) | Medium | – | ⏳ |
| 24 | [Swap Nodes in Pairs](https://leetcode.com/problems/swap-nodes-in-pairs/) | Medium | – | ⏳ |
| 25 | [Reverse Nodes in k-Group](https://leetcode.com/problems/reverse-nodes-in-k-group/) | Hard | – | ⏳ |

## 3. Merging & combining two lists

One pointer per list, plus a `tail` pointer that builds the result after a `dummy` node (same idea as `SinglyList.addLast`).

| # | Problem | Difficulty | File | Status |
|---|---------|------------|------|--------|
| 21 | [Merge Two Sorted Lists](https://leetcode.com/problems/merge-two-sorted-lists/) | Easy | – | ⏳ |
| 160 | [Intersection of Two Linked Lists](https://leetcode.com/problems/intersection-of-two-linked-lists/) | Easy | – | ⏳ |
| 2 | [Add Two Numbers](https://leetcode.com/problems/add-two-numbers/) (carry) | Medium | – | ⏳ |
| 23 | [Merge k Sorted Lists](https://leetcode.com/problems/merge-k-sorted-lists/) (heap or divide & conquer) | Hard | – | ⏳ |

## 4. Rearranging (split, reorder, sort)

Split the list into parts with separate `dummy` heads, then reconnect them.

| # | Problem | Difficulty | File | Status |
|---|---------|------------|------|--------|
| 328 | [Odd Even Linked List](https://leetcode.com/problems/odd-even-linked-list/) | Medium | – | ⏳ |
| 143 | [Reorder List](https://leetcode.com/problems/reorder-list/) (middle + reverse + merge) | Medium | – | ⏳ |
| 148 | [Sort List](https://leetcode.com/problems/sort-list/) (merge sort, O(n log n)) | Medium | – | ⏳ |

## Notes

Notes are added here as each problem is solved (idea, complexity, pitfalls).

## Running

Each problem class has its own `main` method with test cases that print the result for each case (`PASS`/`FAIL` and a final score, or expected vs. actual). Run it from IntelliJ IDEA, or from the project root:

```bash
javac -d out src/SingleLinkedList/*.java
java -cp out SingleLinkedList.SinglyList
```
