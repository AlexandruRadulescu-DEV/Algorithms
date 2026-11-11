package TwoPoitners;

import java.util.Arrays;

//You are given two integer arrays nums1 and nums2, sorted in non-decreasing order, and two integers m and n, representing the number of elements in nums1 and nums2 respectively.
//
//Merge nums1 and nums2 into a single array sorted in non-decreasing order.
//
//The final sorted array should not be returned by the function, but instead be stored inside the array nums1. To accommodate this, nums1 has a length of m + n, where the first m elements denote the elements that should be merged, and the last n elements are set to 0 and should be ignored. nums2 has a length of n.
//
//
//
//Example 1:
//
//Input: nums1 = [1,2,3,0,0,0], m = 3, nums2 = [2,5,6], n = 3
//Output: [1,2,2,3,5,6]
//Explanation: The arrays we are merging are [1,2,3] and [2,5,6].
//The result of the merge is [1,2,2,3,5,6] with the underlined elements coming from nums1.
//Example 2:
//
//Input: nums1 = [1], m = 1, nums2 = [], n = 0
//Output: [1]
//Explanation: The arrays we are merging are [1] and [].
//The result of the merge is [1].
//Example 3:
//
//Input: nums1 = [0], m = 0, nums2 = [1], n = 1
//Output: [1]
//Explanation: The arrays we are merging are [] and [1].
//The result of the merge is [1].
//Note that because m = 0, there are no elements in nums1. The 0 is only there to ensure the merge result can fit in nums1.
public class MergeSortedArray {

static void main() {
    MergeSortedArray sol = new MergeSortedArray();
    Object[][] teste = {
            // { nums1, m, nums2, n, output așteptat }
            {new int[]{1, 2, 3, 0, 0, 0}, 3, new int[]{2, 5, 6}, 3, new int[]{1, 2, 2, 3, 5, 6}},
            {new int[]{1}, 1, new int[]{}, 0, new int[]{1}},
            {new int[]{0}, 0, new int[]{1}, 1, new int[]{1}},
            {new int[]{2, 0}, 1, new int[]{1}, 1, new int[]{1, 2}},
            {new int[]{1, 0}, 1, new int[]{2}, 1, new int[]{1, 2}},
            {new int[]{4, 5, 6, 0, 0, 0}, 3, new int[]{1, 2, 3}, 3, new int[]{1, 2, 3, 4, 5, 6}},
            {new int[]{1, 2, 3, 0, 0, 0}, 3, new int[]{4, 5, 6}, 3, new int[]{1, 2, 3, 4, 5, 6}},
            {new int[]{0, 0, 0}, 0, new int[]{1, 2, 3}, 3, new int[]{1, 2, 3}},
            {new int[]{1, 1, 1, 0, 0, 0}, 3, new int[]{1, 1, 1}, 3, new int[]{1, 1, 1, 1, 1, 1}},
            {new int[]{1, 3, 5, 7, 0, 0, 0, 0}, 4, new int[]{2, 4, 6, 8}, 4, new int[]{1, 2, 3, 4, 5, 6, 7, 8}},
            {new int[]{-3, -1, 0, 0, 0}, 2, new int[]{-2, 0, 4}, 3, new int[]{-3, -2, -1, 0, 4}},
            {new int[]{0, 0, 3, 0, 0, 0}, 3, new int[]{-1, 1, 2}, 3, new int[]{-1, 0, 0, 1, 2, 3}},
            {new int[]{5, 0, 0, 0}, 1, new int[]{1, 2, 3}, 3, new int[]{1, 2, 3, 5}},
            {new int[]{1, 2, 3, 9, 0}, 4, new int[]{4}, 1, new int[]{1, 2, 3, 4, 9}},
            {new int[]{2, 2, 0, 0}, 2, new int[]{2, 2}, 2, new int[]{2, 2, 2, 2}},
            {new int[]{Integer.MIN_VALUE, Integer.MAX_VALUE, 0}, 2, new int[]{0}, 1, new int[]{Integer.MIN_VALUE, 0, Integer.MAX_VALUE}},
    };

    int ok = 0;
    for (Object[] t : teste) {
        int[] nums1 = ((int[]) t[0]).clone();
        int m = (int) t[1];
        int[] nums2 = ((int[]) t[2]).clone();
        int n = (int) t[3];
        int[] asteptat = (int[]) t[4];
        String input = Arrays.toString(nums1) + ", m=" + m + ", " + Arrays.toString(nums2) + ", n=" + n;

        sol.merge(nums1, m, nums2, n);
        boolean pass = Arrays.equals(nums1, asteptat);
        if (pass) ok++;
        System.out.println((pass ? "PASS" : "FAIL") + "  " + input + " -> " + Arrays.toString(nums1)
                + (pass ? "" : "  (așteptat " + Arrays.toString(asteptat) + ")"));
    }
    System.out.println("\n" + ok + "/" + teste.length + " teste trecute");
}

public void merge(int[] nums1, int m, int[] nums2, int n) {


    int i = m - 1;
    int j = n - 1;
    int k = m + n - 1;

    while (j >= 0) {
        if (i >= 0 && nums1[i] > nums2[j]) {
            nums1[k--] = nums1[i--];
        } else {
            nums1[k--] = nums2[j--];
        }
    }

}


}
