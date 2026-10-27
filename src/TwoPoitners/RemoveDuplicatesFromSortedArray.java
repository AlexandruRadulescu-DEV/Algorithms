package TwoPoitners;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class RemoveDuplicatesFromSortedArray {

    //Given an integer array nums sorted in non-decreasing order, remove the duplicates in-place such that each unique element appears only once. The relative order of the elements should be kept the same.
    //
    //Consider the number of unique elements in nums to be k​​​​​​​​​​​​​​. After removing duplicates, return the number of unique elements k.
    //
    //The first k elements of nums should contain the unique numbers in sorted order. The remaining elements beyond index k - 1 can be ignored.
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
    //Input: nums = [1,1,2]
    //Output: 2, nums = [1,2,_]
    //Explanation: Your function should return k = 2, with the first two elements of nums being 1 and 2 respectively.
    //It does not matter what you leave beyond the returned k (hence they are underscores).
    //Example 2:
    //
    //Input: nums = [0,0,1,1,1,2,2,3,3,4]
    //Output: 5, nums = [0,1,2,3,4,_,_,_,_,_]
    //Explanation: Your function should return k = 5, with the first five elements of nums being 0, 1, 2, 3, and 4 respectively.
    //It does not matter what you leave beyond the returned k (hence they are underscores).
    //

    static void main() {
        RemoveDuplicatesFromSortedArray sol = new RemoveDuplicatesFromSortedArray();
        Object[][] teste = {
                // { nums, expectedNums }
                {new int[]{1, 1, 2}, new int[]{1, 2}},
                {new int[]{0, 0, 1, 1, 1, 2, 2, 3, 3, 4}, new int[]{0, 1, 2, 3, 4}},
                {new int[]{}, new int[]{}},
                {new int[]{1}, new int[]{1}},
                {new int[]{1, 1}, new int[]{1}},
                {new int[]{1, 2}, new int[]{1, 2}},
                {new int[]{7, 7, 7, 7, 7}, new int[]{7}},
                {new int[]{1, 2, 3, 4, 5}, new int[]{1, 2, 3, 4, 5}},
                {new int[]{1, 2, 2}, new int[]{1, 2}},
                {new int[]{1, 1, 2, 3}, new int[]{1, 2, 3}},
                {new int[]{1, 2, 3, 3}, new int[]{1, 2, 3}},
                {new int[]{1, 2, 2, 3}, new int[]{1, 2, 3}},
                {new int[]{-3, -3, -1, 0, 0, 2}, new int[]{-3, -1, 0, 2}},
                {new int[]{-100, -100, 0, 100, 100}, new int[]{-100, 0, 100}},
                {new int[]{0, 0, 0, 0, 1}, new int[]{0, 1}},
                {new int[]{0, 1, 1, 1, 1}, new int[]{0, 1}},
                {new int[]{1, 1, 2, 2, 3, 3, 4, 4}, new int[]{1, 2, 3, 4}},
                {new int[]{1, 2, 2, 2, 3, 4, 4, 5}, new int[]{1, 2, 3, 4, 5}},
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
        int k = 0;
        Set<Integer> set = new HashSet<>();

        while(left<=nums.length-1){

            if(!set.contains(nums[left])){
                set.add(nums[left]);
                nums[k++] = nums[left];
            }
            left++;

        }

        return k;

    }

}
