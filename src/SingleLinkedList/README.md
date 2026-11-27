# Singly Linked List

Java solutions to Singly Linked List problems from LeetCode.

> **Order: start here.** Do this folder first, then move on to [Doubly Linked List](../DoublyLinkedList/README.md).

**Progress: 11 / 17**

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
| 237 | [Delete Node in a Linked List](https://leetcode.com/problems/delete-node-in-a-linked-list/) | Medium | [DeleteNodeInALinkedList.java](DeleteNodeInALinkedList.java) | ✅ |
| 2095 | [Delete the Middle Node of a Linked List](https://leetcode.com/problems/delete-the-middle-node-of-a-linked-list/) | Medium | [DeleteMiddleNodeOfLinkedList.java](DeleteMiddleNodeOfLinkedList.java) | ✅ |
| 203 | [Remove Linked List Elements](https://leetcode.com/problems/remove-linked-list-elements/) | Easy | [RemoveLinkedListElements.java](RemoveLinkedListElements.java) | ✅ |
| 83 | [Remove Duplicates from Sorted List](https://leetcode.com/problems/remove-duplicates-from-sorted-list/) | Easy | [RemoveDuplicatesFromSortedList.java](RemoveDuplicatesFromSortedList.java) | ✅ |
| 82 | [Remove Duplicates from Sorted List II](https://leetcode.com/problems/remove-duplicates-from-sorted-list-ii/) | Medium | [RemoveDuplicatesFromSortedListII.java](RemoveDuplicatesFromSortedListII.java) | ✅ |

## 2. Reversal

Three pointers `prev`, `cur`, `next`: save `cur.next`, point `cur.next` back to `prev`, then move both forward. Learn 206 by heart — most problems below reuse it.

| # | Problem | Difficulty | File | Status |
|---|---------|------------|------|--------|
| 206 | [Reverse Linked List](https://leetcode.com/problems/reverse-linked-list/) (iterative **and** recursive) | Easy | [ReverseLinkedList.java](ReverseLinkedList.java) | ✅ |
| 92 | [Reverse Linked List II](https://leetcode.com/problems/reverse-linked-list-ii/) | Medium | [ReverseLinkedListII.java](ReverseLinkedListII.java) | ✅ |
| 24 | [Swap Nodes in Pairs](https://leetcode.com/problems/swap-nodes-in-pairs/) | Medium | [SwapNodesInPairs.java](SwapNodesInPairs.java) | ✅ |
| 25 | [Reverse Nodes in k-Group](https://leetcode.com/problems/reverse-nodes-in-k-group/) | Hard | – | ⏳ |

## 3. Merging & combining two lists

One pointer per list, plus a `tail` pointer that builds the result after a `dummy` node (same idea as `SinglyList.addLast`).

| # | Problem | Difficulty | File | Status |
|---|---------|------------|------|--------|
| 21 | [Merge Two Sorted Lists](https://leetcode.com/problems/merge-two-sorted-lists/) | Easy | [MergeTwoSortedLists.java](MergeTwoSortedLists.java) | ✅ |
| 160 | [Intersection of Two Linked Lists](https://leetcode.com/problems/intersection-of-two-linked-lists/) | Easy | – | ⏳ |
| 2 | [Add Two Numbers](https://leetcode.com/problems/add-two-numbers/) (carry) | Medium | [AddTwoNumbers.java](AddTwoNumbers.java) | ✅ |
| 23 | [Merge k Sorted Lists](https://leetcode.com/problems/merge-k-sorted-lists/) (heap or divide & conquer) | Hard | – | ⏳ |

## 4. Rearranging (split, reorder, sort)

Split the list into parts with separate `dummy` heads, then reconnect them.

| # | Problem | Difficulty | File | Status |
|---|---------|------------|------|--------|
| 328 | [Odd Even Linked List](https://leetcode.com/problems/odd-even-linked-list/) | Medium | [OddEvenLinkedList.java](OddEvenLinkedList.java) | ✅ |
| 143 | [Reorder List](https://leetcode.com/problems/reorder-list/) (middle + reverse + merge) | Medium | – | ⏳ |
| 148 | [Sort List](https://leetcode.com/problems/sort-list/) (merge sort, O(n log n)) | Medium | – | ⏳ |

## Notes

### 237. Delete Node in a Linked List — O(1) time, O(1) space

You only get the node to delete, not `head`, so you can't reach the node before it. Instead, copy the next node's value into this node (`node.val = node.next.val`) and skip the next node (`node.next = node.next.next`). This works because the problem guarantees the node is not the tail.

### 2095. Delete the Middle Node of a Linked List — O(n) time, O(1) space

Count the nodes, then walk `count / 2 - 1` steps from `head` to stop on the node **before** the middle, and unlink it with `prev.next = prev.next.next`. A single node has no node before it, so return `null` for it. One-pass alternative: `slow`/`fast` with `fast` starting one step ahead, so `slow` stops before the middle.

### 203. Remove Linked List Elements — O(n) time, O(1) space

`dummy` before `head`, `current` starts at `dummy` and always looks at `current.next`. If it has `val`, skip it (`current.next = current.next.next`) and **don't** move `current`: the new `current.next` may also need removing (e.g. `6, 6, 1`). Otherwise move forward. Return `dummy.next`, since the head may have been removed.

### 83. Remove Duplicates from Sorted List — O(n) time, O(n) space (with the `HashSet`)

Same skip-or-advance loop as 203, deleting values already in a `HashSet`. Because the list is sorted, duplicates sit next to each other, so the set can be dropped for O(1) space: skip `cur.next` while `cur.next.val == cur.val`.

### 82. Remove Duplicates from Sorted List II — O(n) time, O(1) space

Every copy of a duplicated value goes, including the first one, so the head may go too. Hence the `dummy` node. If `current.next.val == current.next.next.val`, save that value in `dup` and skip nodes while `current.next.val == dup`, without moving `current`. Otherwise advance `current`.

### 206. Reverse Linked List — O(n) time, O(1) space

`prev = null`, `cur = head`. On each step: save `next = cur.next`, point `cur.next = prev`, then `prev = cur`, `cur = next`. When `cur` is `null`, `prev` is the new head. The recursive version also takes O(n), but uses O(n) stack.

### 92. Reverse Linked List II — O(n) time, O(1) space

Walk `left - 1` steps from `dummy` to `before`, the node just before the section. Remember `first = before.next`: after the reversal it becomes the **last** node of the section. Reverse `right - left + 1` nodes exactly like 206. Then reconnect: `before.next = prev` (the new start of the section) and `first.next = current` (the rest of the list). The `dummy` handles `left = 1`.

### 24. Swap Nodes in Pairs — O(n) time, O(1) space

`before` sits right before each pair (starts at `dummy`). With `first = before.next` and `second = first.next`: `first.next = second.next`, `second.next = first`, `before.next = second`. After the swap `first` is the second node of the pair, so `before = first`. Loop while there are still two nodes (`before.next != null && before.next.next != null`).

### 21. Merge Two Sorted Lists — O(n + m) time, O(1) space

`dummy` plus a `tail` pointer. Attach the smaller head to `tail.next`, advance that list and `tail`. When one list runs out, attach the rest of the other list in one step (`tail.next = list1 != null ? list1 : list2`), with no loop needed. The nodes are relinked, not copied.

### 2. Add Two Numbers — O(max(n, m)) time, O(max(n, m)) space for the result

The digits are stored in reverse order, so add them from the head like on paper: `sum = x + y + carry`, write `sum % 10` into a new node, keep `carry = sum / 10`. Use `0` for a list that has ended. Loop while `l1 != null || l2 != null || carry != 0`. The `carry` check adds the final digit (e.g. `5 + 5 = 10`).

### 328. Odd Even Linked List — O(n) time, O(1) space

Two `dummy` heads, one for odd positions and one for even positions (positions, not values). Walk the list with an index and append each node to the right tail. At the end, set `evenTail.next = null`, otherwise the last even node still points into the list and creates a cycle. Then join with `oddTail.next = evenDummy.next`.

## Running

Each problem class has its own `main` method with test cases that print the result for each case (`PASS`/`FAIL` and a final score, or expected vs. actual). Run it from IntelliJ IDEA, or from the project root:

```bash
javac -d out src/SingleLinkedList/*.java
java -cp out SingleLinkedList.SinglyList
```
