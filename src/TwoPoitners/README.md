# Two Pointers

Java solutions to Two Pointers problems from LeetCode.

**Progress: 26 / 27**

Status: ✅ solved · 🟡 in progress · ⏳ to do

## 1. Opposite ends (converge toward the middle)

Start one pointer at the beginning and one at the end, then move them toward each other based on a condition.

| # | Problem | Difficulty | File | Status |
|---|---------|------------|------|--------|
| 344 | [Reverse String](https://leetcode.com/problems/reverse-string/) | Easy | [ReverseString.java](ReverseString.java) | ✅ |
| 125 | [Valid Palindrome](https://leetcode.com/problems/valid-palindrome/) | Easy | [ValidPalindrome.java](ValidPalindrome.java) | ✅ |
| 977 | [Squares of a Sorted Array](https://leetcode.com/problems/squares-of-a-sorted-array/) | Easy | [SquaresOfASortedArray.java](SquaresOfASortedArray.java) | ✅ |
| 167 | [Two Sum II – Input Array Is Sorted](https://leetcode.com/problems/two-sum-ii-input-array-is-sorted/) | Medium | [TwoSum.java](TwoSum.java) | ✅ |
| 680 | [Valid Palindrome II](https://leetcode.com/problems/valid-palindrome-ii/) | Easy | [ValidPalindromII.java](ValidPalindromII.java) | ✅ |
| 11 | [Container With Most Water](https://leetcode.com/problems/container-with-most-water/) | Medium | [ContainerWithMostWater.java](ContainerWithMostWater.java) | ✅ |
| 881 | [Boats to Save People](https://leetcode.com/problems/boats-to-save-people/) | Medium | [BoatsToSavePeople.java](BoatsToSavePeople.java) | ✅ |
| 15 | [3Sum](https://leetcode.com/problems/3sum/) | Medium | [ThreeSum.java](ThreeSum.java) | ✅ |
| 16 | [3Sum Closest](https://leetcode.com/problems/3sum-closest/) | Medium | [ThreeSumClosest.java](ThreeSumClosest.java) | ✅ |
| 18 | [4Sum](https://leetcode.com/problems/4sum/) | Medium | [ForthSum.java](ForthSum.java) | ✅ |
| 42 | [Trapping Rain Water](https://leetcode.com/problems/trapping-rain-water/) | Hard | – | ⏳ |

## 2. Same direction (read/write pointer, in-place)

A slow "write" pointer marks where the next kept element goes; a fast "read" pointer scans the array.

| # | Problem | Difficulty | File | Status |
|---|---------|------------|------|--------|
| 27 | [Remove Element](https://leetcode.com/problems/remove-element/) | Easy | [RemoveElement.java](RemoveElement.java) | ✅ |
| 26 | [Remove Duplicates from Sorted Array](https://leetcode.com/problems/remove-duplicates-from-sorted-array/) | Easy | [RemoveDuplicatesFromSortedArray.java](RemoveDuplicatesFromSortedArray.java) | ✅ |
| 283 | [Move Zeroes](https://leetcode.com/problems/move-zeroes/) | Easy | [MoveZeroes.java](MoveZeroes.java) | ✅ |
| 392 | [Is Subsequence](https://leetcode.com/problems/is-subsequence/) | Easy | [IsSubsequence.java](IsSubsequence.java) | ✅ |
| 80 | [Remove Duplicates from Sorted Array II](https://leetcode.com/problems/remove-duplicates-from-sorted-array-ii/) | Medium | [RemoveDuplicatesFromSortedArrayII.java](RemoveDuplicatesFromSortedArrayII.java) | ✅ |
| 75 | [Sort Colors](https://leetcode.com/problems/sort-colors/) (Dutch National Flag, 3 pointers) | Medium | [SortColors.java](SortColors.java) | ✅ |

## 3. Two pointers on two sequences

One pointer per input, advanced depending on how the current elements compare.

| # | Problem | Difficulty | File | Status |
|---|---------|------------|------|--------|
| 88 | [Merge Sorted Array](https://leetcode.com/problems/merge-sorted-array/) (start from the end!) | Easy | [MergeSortedArray.java](MergeSortedArray.java) | ✅ |
| 350 | [Intersection of Two Arrays II](https://leetcode.com/problems/intersection-of-two-arrays-ii/) | Easy | [InteractionOfTwoArraysII.java](InteractionOfTwoArraysII.java) | ✅ |
| 844 | [Backspace String Compare](https://leetcode.com/problems/backspace-string-compare/) (right to left, O(1) space) | Easy | [BackspaceStringCompare.java](BackspaceStringCompare.java) | ✅ |
| 986 | [Interval List Intersections](https://leetcode.com/problems/interval-list-intersections/) | Medium | [IntervalListIntersaction.java](IntervalListIntersaction.java) | ✅ |

## 4. Fast & slow (linked lists / cycles)

The fast pointer moves 2 steps for each 1 step of the slow pointer.

| # | Problem | Difficulty | File | Status |
|---|---------|------------|------|--------|
| 876 | [Middle of the Linked List](https://leetcode.com/problems/middle-of-the-linked-list/) | Easy | [MiddleOfTheLinkedList.java](MiddleOfTheLinkedList.java) | ✅ |
| 141 | [Linked List Cycle](https://leetcode.com/problems/linked-list-cycle/) | Easy | [LinkedListCycle.java](LinkedListCycle.java) | ✅ |
| 234 | [Palindrome Linked List](https://leetcode.com/problems/palindrome-linked-list/) | Easy | [PalindromLinkedList.java](PalindromLinkedList.java) | ✅ |
| 19 | [Remove Nth Node From End of List](https://leetcode.com/problems/remove-nth-node-from-end-of-list/) | Medium | [RemoveNthNodeFromEndOfList.java](RemoveNthNodeFromEndOfList.java) | ✅ |
| 142 | [Linked List Cycle II](https://leetcode.com/problems/linked-list-cycle-ii/) | Medium | [LinkedListCycleII.java](LinkedListCycleII.java) | ✅ |
| 287 | [Find the Duplicate Number](https://leetcode.com/problems/find-the-duplicate-number/) (Floyd on an array) | Medium | [FindTheDuplicateNumber.java](FindTheDuplicateNumber.java) | ✅ |

## Notes

### 344. Reverse String — O(n) time, O(1) space

Put one pointer at the start and one at the end, swap the two characters, then move both pointers toward the middle until they meet.

### 125. Valid Palindrome — O(n) time, O(1) space

Move `left` forward and `right` backward, skipping any character that is not a letter or digit (`Character.isLetterOrDigit(s.charAt(i))` — pass the character, not the index). When both point to valid characters, compare them with `Character.toLowerCase`; any mismatch means it is not a palindrome. Only advance both pointers after a successful comparison.

### 977. Squares of a Sorted Array — O(n) time, O(n) space for the result

Negative numbers flip order when squared, so the largest square is always at one of the two ends. Compare the squares at `left` and `right`, write the larger one into the result from the back (`k` goes from `n - 1` down to `0`), and move only the pointer it came from. Loop while `left <= right` so the middle element is placed too. Use a new array — writing into `nums` would overwrite values not read yet.

### 167. Two Sum II – Input Array Is Sorted — O(n) time, O(1) space

Start with `left` at the smallest and `right` at the largest number. If the sum is too big, `right--`; if it is too small, `left++`; otherwise return `[left + 1, right + 1]` (1-indexed). A `HashMap` would also be O(n) time, but O(n) space — the problem requires constant space, and the map ignores that the array is sorted (that's the approach for the unsorted Two Sum #1).

### 680. Valid Palindrome II — O(n) time, O(1) space

Walk `left` and `right` toward each other like in Valid Palindrome. At the first mismatch you may delete one character, so there are two options: skip the left character (`left + 1 .. right`) or skip the right one (`left .. right - 1`). The string is valid if either remaining range is a palindrome. Only one deletion is allowed, so a second mismatch inside the chosen range means `false`.

### 11. Container With Most Water — O(n) time, O(1) space

Start with the widest container (`left = 0`, `right = n - 1`); its area is `min(height[left], height[right]) * (right - left)`. Always move the pointer at the **shorter** wall: the width shrinks anyway, and keeping the short wall can never give a bigger area, so the only chance to improve is to look for a taller wall on that side. Keep the maximum seen.

### 881. Boats to Save People — O(n log n) time (sorting), O(1) extra space

Sort the weights. The heaviest person (`right`) always takes a boat; if the lightest person (`left`) fits with them (`people[left] + people[right] <= limit`), they share it and `left++`. Then `right--` and count one boat either way. Loop while `left <= right` so a single person left in the middle also gets a boat.

### 15. 3Sum — O(n²) time, O(1) extra space (besides the result)

Sort, then fix `nums[i]` and run Two Sum II on `i + 1 .. n - 1` looking for `-nums[i]`. To avoid duplicate triplets, skip `i` when `nums[i] == nums[i - 1]`, and after a match move `left`/`right` past equal values. Once `nums[i] > 0` you can `break` — every number after it is positive too.

### 16. 3Sum Closest — O(n²) time, O(1) space

Same structure as 3Sum: sort, fix `i`, move `left`/`right` depending on whether the sum is below or above `target`. On every step compare `Math.abs(sum - target)` with the best so far and keep the closer sum. If `sum == target` return right away — nothing can be closer. Initialize `closest` with the first three numbers, not with `0` or `Integer.MAX_VALUE` (the latter overflows in `closest - target`).

### 18. 4Sum — O(n³) time, O(1) extra space (besides the result)

3Sum with one more loop: fix `i`, then `j` starting at `i + 1`, then run two pointers on `j + 1 .. n - 1`. Skip duplicates on all four levels (`i`, `j`, `left`, `right`). Compute the sum as `long` — four values up to ±10⁹ overflow an `int` (e.g. `4 × 10⁹` wraps around to `-294967296`).

### 27. Remove Element — O(n) time, O(1) space

`left` reads every element, `k` marks where the next kept element is written. Whenever `nums[left] != val`, copy it to `nums[k++]`. At the end `k` is the number of kept elements. Loop over the **whole** array (`left < nums.length`) — stopping at `nums.length - 1` skips the last element. Advance `left` on every step, not only when copying, or the loop never ends on a `val`.

### 26. Remove Duplicates from Sorted Array — O(n) time, O(n) space (with the `HashSet`)

Same read/write pattern as Remove Element: copy `nums[left]` to `nums[k++]` only the first time a value is seen, tracked with a `HashSet`. Since the array is sorted, equal values are next to each other, so the set can be dropped for O(1) space: a value is new exactly when `nums[left] != nums[k - 1]`.

### 283. Move Zeroes — O(n) time, O(1) space

First pass: copy every non-zero element forward to `nums[k++]`, which keeps their relative order. Second pass: fill `k .. n - 1` with zeros. A one-pass alternative is to swap `nums[left]` with `nums[k]` instead of copying.

### 392. Is Subsequence — O(|t|) time, O(1) space

Walk through `t` with `i` and keep a pointer `left` into `s`. When `s.charAt(left) == t.charAt(i)`, that character of `s` is matched, so `left++`; `i` always moves on. Check `left < s.length()` before `charAt`, and at the end `s` is a subsequence if all of it was matched (`k == s.length()`, compare with `s`, not `t`). An empty `s` is always a subsequence.

### 80. Remove Duplicates from Sorted Array II — O(n) time, O(n) space (with the `HashMap`)

Same read/write pattern as #26, but each value may be kept up to twice. A `HashMap` counts how many times each value was written; copy `nums[left]` to `nums[k++]` only while its count is below 2. Loop over the **whole** array (`left <= nums.length - 1`) and don't write anything past `k` — doing so changes the returned length. Because the array is sorted, the map can be dropped for O(1) space (which the problem asks for): keep `nums[left]` when `k < 2 || nums[left] != nums[k - 2]`.

### 75. Sort Colors — O(n²) time (bubble sort), O(1) space

Current solution is bubble sort: repeatedly swap adjacent elements that are out of order (`nums[left] > nums[left + 1]`), shrinking `right` after each pass since the largest value has bubbled to the end. Stop the inner loop at `left < right` so `left + 1` stays in bounds. The intended one-pass O(n) solution is the Dutch National Flag: keep `low`, `mid`, `high`; on `0` swap `mid` with `low` and advance both, on `1` just `mid++`, on `2` swap `mid` with `high` and `high--` without moving `mid` (the swapped-in value still needs checking).

### 88. Merge Sorted Array — O(m + n) time, O(1) space

Fill `nums1` **from the back**: `i = m - 1` (last real value in `nums1`), `j = n - 1` (last in `nums2`), `k = m + n - 1` (write position). Write the larger of `nums1[i]` and `nums2[j]` to `nums1[k--]`. Going backward never overwrites a value not read yet. Loop while `j >= 0` — once `nums2` is used up, what remains in `nums1` is already in place.

### 350. Intersection of Two Arrays II — O(n log n + m log m) time (sorting), O(1) extra space (besides the result)

Sort both arrays and walk them with one pointer each (here from the end). Equal values go into the result and both pointers move; otherwise move only the pointer at the larger value. The result has at most `min(n, m)` elements, so allocate that and trim with `Arrays.copyOf(result, k)`.

### 844. Backspace String Compare — O(n + m) time, O(n + m) space

Read each string **right to left** and count pending `#` in `skip`: a `#` adds one, a normal character is dropped while `skip > 0`, otherwise it is kept. Build the cleaned strings this way and compare them with `equals`. The O(1) space follow-up compares the two strings character by character with the same skip logic, without building them.

### 986. Interval List Intersections — O(n + m) time, O(1) extra space (besides the result)

One pointer per list. Two intervals `a` and `b` overlap on `[max(a[0], b[0]), min(a[1], b[1])]` if that start is `<=` that end. Then advance the pointer of the interval that **ends first** — it can't overlap anything else in the other list. The count of intersections is unknown, so allocate `n + m` rows and trim with `Arrays.copyOf(result, k)` (or collect in a `List<int[]>` and use `toArray(new int[0][])`). Watch the indexes: `b = secondList[j]`, not `firstList[j]`.

### 876. Middle of the Linked List — O(n) time, O(1) space

Count the nodes, then walk `count / 2` steps from `head` (integer division: 5 / 2 = 2 steps lands on the 3rd node; for even lengths it lands on the second middle, as required). After `k` steps you are on node `k + 1`, because `head` is already node 1. One-pass alternative: `slow` 1 step, `fast` 2 steps; when `fast` reaches the end, `slow` is the middle.

### 141. Linked List Cycle — O(n) time, O(1) space

Floyd's tortoise and hare: `slow` moves 1 step, `fast` moves 2. If `fast` reaches the end there is no cycle (`false`); if `slow == fast` they met inside the cycle (`true`) — once both are in the cycle the gap shrinks by exactly 1 per step, so `fast` can't jump over `slow`. Loop condition `fast != null && fast.next != null`: the first check catches even-length lists, the second odd-length ones, and the order matters because `&&` short-circuits.

### 234. Palindrome Linked List — O(n) time, O(n) space (with the copy)

`ListNode aux = head` does **not** copy the list — it is a second reference to the same nodes, so reversing it in place also breaks the original. Current solution builds a real copy (`new ListNode(head.val)` for every node), reverses the copy and compares it node by node with the original. The O(1) space solution: find the middle with `slow`/`fast`, reverse only the second half, then compare it with the first half while the reversed half is not `null`.

### 19. Remove Nth Node From End of List — O(n) time, O(1) space

Put a `dummy` node before `head` (`new ListNode(0, head)`) so even the first node has a node before it — that handles removing the head without a special case. Start `fast` and `slow` at `dummy`, move `fast` `n` steps ahead, then move both until `fast.next == null`. The gap stays `n`, so `slow` stops right **before** the node to delete: `slow.next = slow.next.next`. Return `dummy.next`, not `head` (if the head was removed, `head` still points to the deleted node). Don't move `head` itself while walking, or you lose the start of the list.

### 142. Linked List Cycle II — O(n) time, O(1) space

Phase 1 is Linked List Cycle: `slow` 1 step, `fast` 2 steps until `slow == fast`. The meeting point is **not** necessarily the start of the cycle. Phase 2: put `p` at `head`, leave `slow` at the meeting point, and move **both** 1 step at a time; they meet exactly at the start of the cycle, because the distance from `head` to the cycle start equals the distance from the meeting point to the cycle start (plus whole laps). Compare nodes with `==`, never by `.val` — values can repeat.

### 287. Find the Duplicate Number — O(n) time, O(n) space (with the `HashSet`)

Current solution adds each number to a `HashSet` and returns the first one that is already there. Correct, but the problem asks for O(1) extra space and no changes to `nums` (so no sorting). The intended solution is Linked List Cycle II on the array: treat index `i` as a node whose `next` is `nums[i]`. The duplicate value has two indexes pointing to it, so it is the start of the cycle — find it with `slow = nums[slow]`, `fast = nums[nums[fast]]`, then phase 2 from index `0`.

## Running

Each problem class has its own `main` method with test cases that print the result for each case (`PASS`/`FAIL` and a final score, or expected vs. actual). Run it from IntelliJ IDEA, or from the project root:

```bash
javac -d out src/TwoPoitners/ReverseString.java
java -cp out TwoPoitners.ReverseString
```