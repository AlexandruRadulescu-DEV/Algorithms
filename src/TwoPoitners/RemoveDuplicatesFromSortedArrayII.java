package TwoPoitners;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

//Given an integer array nums sorted in non-decreasing order, remove some duplicates in-place such that each unique element appears at most twice. The relative order of the elements should be kept the same.
//
//Since it is impossible to change the length of the array in some languages, you must instead have the result be placed in the first part of the array nums. More formally, if there are k elements after removing the duplicates, then the first k elements of nums should hold the final result. It does not matter what you leave beyond the first k elements.
//
//Return k after placing the final result in the first k slots of nums.
//
//Do not allocate extra space for another array. You must do this by modifying the input array in-place with O(1) extra memory.
//
//Custom Judge:
//
//The judge will test your solution with the following code:
//
//int[] nums = [...]; // Input array
//int[] expectedNums = [...]; // The expected answer with correct length
//
//int k = removeDuplicates(nums); // Calls your implementation
//
//assert k == expectedNums.length;
//for (int i = 0; i < k; i++) {
//    assert nums[i] == expectedNums[i];
//}
//If all assertions pass, then your solution will be accepted.
//
//
//
//Example 1:
//
//Input: nums = [1,1,1,2,2,3]
//Output: 5, nums = [1,1,2,2,3,_]
//Explanation: Your function should return k = 5, with the first five elements of nums being 1, 1, 2, 2 and 3 respectively.
//It does not matter what you leave beyond the returned k (hence they are underscores).
//Example 2:
//
//Input: nums = [0,0,1,1,1,1,2,3,3]
//Output: 7, nums = [0,0,1,1,2,3,3,_,_]
//Explanation: Your function should return k = 7, with the first seven elements of nums being 0, 0, 1, 1, 2, 3 and 3 respectively.
//It does not matter what you leave beyond the returned k (hence they are underscores).
public class RemoveDuplicatesFromSortedArrayII {


    static void main() {
        RemoveDuplicatesFromSortedArrayII sol = new RemoveDuplicatesFromSortedArrayII();
        Object[][] teste = {
                // { nums, expectedNums }
                {new int[]{1, 1, 1, 2, 2, 3}, new int[]{1, 1, 2, 2, 3}},
                {new int[]{0, 0, 1, 1, 1, 1, 2, 3, 3}, new int[]{0, 0, 1, 1, 2, 3, 3}},
                {new int[]{}, new int[]{}},
                {new int[]{1}, new int[]{1}},
                {new int[]{1, 1}, new int[]{1, 1}},
                {new int[]{1, 1, 1}, new int[]{1, 1}},
                {new int[]{1, 2}, new int[]{1, 2}},
                {new int[]{7, 7, 7, 7, 7}, new int[]{7, 7}},
                {new int[]{1, 2, 3, 4, 5}, new int[]{1, 2, 3, 4, 5}},
                {new int[]{1, 2, 2, 2}, new int[]{1, 2, 2}},
                {new int[]{1, 1, 1, 2, 3}, new int[]{1, 1, 2, 3}},
                {new int[]{1, 2, 3, 3, 3}, new int[]{1, 2, 3, 3}},
                {new int[]{1, 2, 2, 2, 3}, new int[]{1, 2, 2, 3}},
                {new int[]{-3, -3, -3, -1, 0, 0, 0, 2}, new int[]{-3, -3, -1, 0, 0, 2}},
                {new int[]{-10000, -10000, 0, 10000, 10000, 10000}, new int[]{-10000, -10000, 0, 10000, 10000}},
                {new int[]{0, 0, 0, 0, 1}, new int[]{0, 0, 1}},
                {new int[]{0, 1, 1, 1, 1}, new int[]{0, 1, 1}},
                {new int[]{1, 1, 2, 2, 3, 3, 4, 4}, new int[]{1, 1, 2, 2, 3, 3, 4, 4}},
                {new int[]{1, 1, 1, 2, 2, 2, 3, 3, 3}, new int[]{1, 1, 2, 2, 3, 3}},
                {new int[]{1, 2, 2, 2, 3, 4, 4, 4, 4, 5}, new int[]{1, 2, 2, 3, 4, 4, 5}},
        };

        int ok = 0;
        for (Object[] t : teste) {
            int[] nums = ((int[]) t[0]).clone();
            int[] asteptat = (int[]) t[1];
            String input = Arrays.toString(nums);

            int k = sol.removeDuplicates(nums);
            // aici ordinea contează: primele k elemente trebuie să fie exact asteptat
            int[] primele = Arrays.copyOfRange(nums, 0, Math.max(0, Math.min(k, nums.length)));
            boolean pass = k == asteptat.length && Arrays.equals(primele, asteptat);
            if (pass) ok++;
            System.out.println((pass ? "PASS" : "FAIL") + "  " + input + " -> k=" + k + ", " + Arrays.toString(primele)
                    + (pass ? "" : "  (așteptat k=" + asteptat.length + ", " + Arrays.toString(asteptat) + ")"));
        }
        System.out.println("\n" + ok + "/" + teste.length + " teste trecute");
    }

    public int removeDuplicates(int[] nums) {
        int left = 0;
        int right = nums.length - 1;
        Map<Integer, Integer> container = new HashMap<>();
        int k = 0;

        while (left <= right) {

            if (container.containsKey(nums[left]) && (container.get(nums[left]) < 2)) {
                nums[k++] = nums[left];
                int counter = container.get(nums[left]) + 1;
                container.put(nums[left],counter);

            }

            if (!container.containsKey(nums[left])) {
                container.put(nums[left], 1);
                nums[k++] = nums[left];
            }

            left++;

        }
        return k;
    }
}
