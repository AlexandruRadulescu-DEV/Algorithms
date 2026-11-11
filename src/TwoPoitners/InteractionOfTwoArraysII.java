package TwoPoitners;

import java.util.Arrays;

//Intersection of Two Arrays II
//Easy
//Topics
//premium lock icon
//Companies
//Given two integer arrays nums1 and nums2, return an array of their intersection. Each element in the result must appear as many times as it shows in both arrays and you may return the result in any order.
//
//
//
//Example 1:
//
//Input: nums1 = [1,2,2,1], nums2 = [2,2]
//Output: [2,2]
//Example 2:
//
//Input: nums1 = [4,9,5], nums2 = [9,4,9,8,4]
//Output: [4,9]
//Explanation: [9,4] is also accepted.
public class InteractionOfTwoArraysII {

    static void main() {
        InteractionOfTwoArraysII sol = new InteractionOfTwoArraysII();
        int[][][] teste = {
                // { nums1, nums2, output așteptat (orice ordine) }
                {{1, 2, 2, 1}, {2, 2}, {2, 2}},
                {{4, 9, 5}, {9, 4, 9, 8, 4}, {4, 9}},
                {{1, 2, 3}, {4, 5, 6}, {}},
                {{1}, {1}, {1}},
                {{1}, {2}, {}},
                {{}, {1, 2}, {}},
                {{1, 2}, {}, {}},
                {{1, 1, 1, 1}, {1, 1}, {1, 1}},
                {{1, 1}, {1, 1, 1, 1}, {1, 1}},
                {{1, 2, 3, 4}, {4, 3, 2, 1}, {1, 2, 3, 4}},
                {{3, 1, 2}, {1, 1}, {1}},
                {{1, 2, 2, 3, 3, 3}, {3, 3, 2, 5}, {2, 3, 3}},
                {{0, 0, 0}, {0}, {0}},
                {{-1, -2, 3, -1}, {-1, -1, -1, 3}, {-1, -1, 3}},
                {{1000, 1, 1000}, {1000, 1000, 1000}, {1000, 1000}},
                {{5, 7, 7, 9}, {7, 9, 9, 7, 5, 5}, {5, 7, 7, 9}},
        };

        int ok = 0;
        for (int[][] t : teste) {
            int[] nums1 = t[0].clone();
            int[] nums2 = t[1].clone();
            int[] asteptat = t[2].clone();
            String input = Arrays.toString(nums1) + ", " + Arrays.toString(nums2);

            int[] rezultat = sol.intersect(nums1, nums2);
            int[] rezultatSortat = rezultat.clone();
            Arrays.sort(rezultatSortat);
            Arrays.sort(asteptat);
            boolean pass = Arrays.equals(rezultatSortat, asteptat);
            if (pass) ok++;
            System.out.println((pass ? "PASS" : "FAIL") + "  " + input + " -> " + Arrays.toString(rezultat)
                    + (pass ? "" : "  (așteptat " + Arrays.toString(t[2]) + ")"));
        }
        System.out.println("\n" + ok + "/" + teste.length + " teste trecute");
    }

    public int[] intersect(int[] nums1, int[] nums2) {
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        int i = nums1.length - 1;
        int j = nums2.length - 1;
        int k = 0;
        int[] result = new int[Math.min(nums1.length, nums2.length)];
        while (j >= 0 && i >= 0) {
            if (nums1[i] == nums2[j]) {
                result[k++] = nums1[i];
                i--;
                j--;
            } else if (nums1[i] > nums2[j]) {
                i--;
            } else {
                j--;
            }
        }
        return Arrays.copyOf(result, k);

    }
}
