package TwoPoitners;

import java.util.Arrays;

//Given an integer array nums and an integer val, remove all occurrences of val in nums in-place. The order of the elements may be changed. Then return the number of elements in nums which are not equal to val.
//
//Consider the number of elements in nums which are not equal to val be k, to get accepted, you need to do the following things:
//
//Change the array nums such that the first k elements of nums contain the elements which are not equal to val. The remaining elements of nums are not important as well as the size of nums.
//Return k.
//Custom Judge:
//
//The judge will test your solution with the following code:
//
//int[] nums = [...]; // Input array
//int val = ...; // Value to remove
//int[] expectedNums = [...]; // The expected answer with correct length.
//                            // It is sorted with no values equaling val.
//
//int k = removeElement(nums, val); // Calls your implementation
//
//assert k == expectedNums.length;
//sort(nums, 0, k); // Sort the first k elements of nums
//for (int i = 0; i < actualLength; i++) {
//    assert nums[i] == expectedNums[i];
//}
//If all assertions pass, then your solution will be accepted.
//
//
//
//Example 1:
//
//Input: nums = [3,2,2,3], val = 3
//Output: 2, nums = [2,2,_,_]
//Explanation: Your function should return k = 2, with the first two elements of nums being 2.
//It does not matter what you leave beyond the returned k (hence they are underscores).
//Example 2:
//
//Input: nums = [0,1,2,2,3,0,4,2], val = 2
//Output: 5, nums = [0,1,4,0,3,_,_,_]
//Explanation: Your function should return k = 5, with the first five elements of nums containing 0, 0, 1, 3, and 4.
//Note that the five elements can be returned in any order.
//It does not matter what you leave beyond the returned k (hence they are underscores).
public class RemoveElement {

    static void main() {
        RemoveElement sol = new RemoveElement();
        Object[][] teste = {
                // { nums, val, expectedNums (sortat, fără val) }
                {new int[]{3, 2, 2, 3}, 3, new int[]{2, 2}},
                {new int[]{0, 1, 2, 2, 3, 0, 4, 2}, 2, new int[]{0, 0, 1, 3, 4}},
                {new int[]{}, 0, new int[]{}},
                {new int[]{1}, 1, new int[]{}},
                {new int[]{1}, 2, new int[]{1}},
                {new int[]{2, 2, 2, 2}, 2, new int[]{}},
                {new int[]{1, 2, 3, 4}, 5, new int[]{1, 2, 3, 4}},
                {new int[]{3, 1, 2}, 3, new int[]{1, 2}},
                {new int[]{1, 2, 3}, 3, new int[]{1, 2}},
                {new int[]{1, 3, 2}, 3, new int[]{1, 2}},
                {new int[]{4, 5}, 5, new int[]{4}},
                {new int[]{5, 4}, 5, new int[]{4}},
                {new int[]{3, 3, 1, 3, 3}, 3, new int[]{1}},
                {new int[]{1, 3, 1, 3, 1}, 3, new int[]{1, 1, 1}},
                {new int[]{0, 0, 0, 1}, 0, new int[]{1}},
                {new int[]{1, 0, 0, 0}, 0, new int[]{1}},
                {new int[]{50, 0, 50, 49, 50}, 50, new int[]{0, 49}},
                {new int[]{4, 1, 4, 2, 4, 3, 4}, 4, new int[]{1, 2, 3}},
        };

        int ok = 0;
        for (Object[] t : teste) {
            int[] nums = ((int[]) t[0]).clone();
            int val = (int) t[1];
            int[] asteptat = (int[]) t[2];
            String input = Arrays.toString(nums) + ", val=" + val;

            int k = sol.removeElement(nums, val);
            // ordinea primelor k elemente nu contează
            int[] primele = Arrays.copyOfRange(nums, 0, Math.max(0, Math.min(k, nums.length)));
            Arrays.sort(primele);
            boolean pass = k == asteptat.length && Arrays.equals(primele, asteptat);
            if (pass) ok++;
            System.out.println((pass ? "PASS" : "FAIL") + "  " + input + " -> k=" + k + ", " + Arrays.toString(primele)
                    + (pass ? "" : "  (așteptat k=" + asteptat.length + ", " + Arrays.toString(asteptat) + ")"));
        }
        System.out.println("\n" + ok + "/" + teste.length + " teste trecute");
    }

    public int removeElement(int[] nums, int val) {

        int left = 0;
        int k = 0;
        while(left<=nums.length-1){
        if(nums[left] != val){
            nums[k++] = nums[left];
        }
        left++;
    }
        return k;
}
}
