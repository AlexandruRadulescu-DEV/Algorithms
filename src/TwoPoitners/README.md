# Two Pointers

Java solutions to Two Pointers problems from LeetCode.

**Progress: 16 / 27**

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
| 88 | [Merge Sorted Array](https://leetcode.com/problems/merge-sorted-array/) (start from the end!) | Easy | – | ⏳ |
| 350 | [Intersection of Two Arrays II](https://leetcode.com/problems/intersection-of-two-arrays-ii/) | Easy | – | ⏳ |
| 844 | [Backspace String Compare](https://leetcode.com/problems/backspace-string-compare/) (right to left, O(1) space) | Easy | – | ⏳ |
| 986 | [Interval List Intersections](https://leetcode.com/problems/interval-list-intersections/) | Medium | – | ⏳ |

## 4. Fast & slow (linked lists / cycles)

The fast pointer moves 2 steps for each 1 step of the slow pointer.

| # | Problem | Difficulty | File | Status |
|---|---------|------------|------|--------|
| 876 | [Middle of the Linked List](https://leetcode.com/problems/middle-of-the-linked-list/) | Easy | – | ⏳ |
| 141 | [Linked List Cycle](https://leetcode.com/problems/linked-list-cycle/) | Easy | – | ⏳ |
| 234 | [Palindrome Linked List](https://leetcode.com/problems/palindrome-linked-list/) | Easy | – | ⏳ |
| 19 | [Remove Nth Node From End of List](https://leetcode.com/problems/remove-nth-node-from-end-of-list/) | Medium | – | ⏳ |
| 142 | [Linked List Cycle II](https://leetcode.com/problems/linked-list-cycle-ii/) | Medium | – | ⏳ |
| 287 | [Find the Duplicate Number](https://leetcode.com/problems/find-the-duplicate-number/) (Floyd on an array) | Medium | – | ⏳ |

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

## Running

Each problem class has its own `main` method with test cases that print the result for each case (`PASS`/`FAIL` and a final score, or expected vs. actual). Run it from IntelliJ IDEA, or from the project root:

```bash
javac -d out src/TwoPoitners/ReverseString.java
java -cp out TwoPoitners.ReverseString
```