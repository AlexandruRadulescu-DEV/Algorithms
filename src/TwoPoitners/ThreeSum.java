package TwoPoitners;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//Given an integer array nums, return all the triplets [nums[i], nums[j], nums[k]] such that i != j, i != k, and j != k, and nums[i] + nums[j] + nums[k] == 0.
//
//Notice that the solution set must not contain duplicate triplets.
//
//
//
//Example 1:
//
//Input: nums = [-1,0,1,2,-1,-4]
//Output: [[-1,-1,2],[-1,0,1]]
//Explanation:
//nums[0] + nums[1] + nums[2] = (-1) + 0 + 1 = 0.
//nums[1] + nums[2] + nums[4] = 0 + 1 + (-1) = 0.
//nums[0] + nums[3] + nums[4] = (-1) + 2 + (-1) = 0.
//The distinct triplets are [-1,0,1] and [-1,-1,2].
//Notice that the order of the output and the order of the triplets does not matter.
//Example 2:
//
//Input: nums = [0,1,1]
//Output: []
//Explanation: The only possible triplet does not sum up to 0.
//Example 3:
//
//Input: nums = [0,0,0]
//Output: [[0,0,0]]
//Explanation: The only possible triplet sums up to 0.
public class ThreeSum {
    static void main() {
        ThreeSum sol = new ThreeSum();
        Object[][] teste = {
                // { nums, output așteptat }
                {new int[]{-1, 0, 1, 2, -1, -4}, new int[][]{{-1, -1, 2}, {-1, 0, 1}}},
//                {new int[]{0, 1, 1}, new int[][]{}},
//                {new int[]{0, 0, 0}, new int[][]{{0, 0, 0}}},
//                {new int[]{0, 0, 0, 0}, new int[][]{{0, 0, 0}}},
//                {new int[]{}, new int[][]{}},
//                {new int[]{1}, new int[][]{}},
//                {new int[]{1, -1}, new int[][]{}},
//                {new int[]{-1, 0, 1}, new int[][]{{-1, 0, 1}}},
//                {new int[]{1, 2, 3}, new int[][]{}},
//                {new int[]{-3, -2, -1}, new int[][]{}},
//                {new int[]{1, 1, 1}, new int[][]{}},
//                {new int[]{1, 1, -2}, new int[][]{{-2, 1, 1}}},
//                {new int[]{2, -1, -1}, new int[][]{{-1, -1, 2}}},
//                {new int[]{5, -5, 0}, new int[][]{{-5, 0, 5}}},
//                {new int[]{-1, 0, 1, 0}, new int[][]{{-1, 0, 1}}},
//                {new int[]{-1, -1, -1, 2, 2}, new int[][]{{-1, -1, 2}}},
//                {new int[]{-1, 1, 0, 0, 0}, new int[][]{{-1, 0, 1}, {0, 0, 0}}},
//                {new int[]{-2, 0, 1, 1, 2}, new int[][]{{-2, 0, 2}, {-2, 1, 1}}},
//                {new int[]{-2, -1, 0, 1, 2}, new int[][]{{-2, 0, 2}, {-1, 0, 1}}},
//                {new int[]{3, 0, -2, -1, 1, 2}, new int[][]{{-2, -1, 3}, {-2, 0, 2}, {-1, 0, 1}}},
//                {new int[]{-5, 2, 3, 0, 0, 5}, new int[][]{{-5, 0, 5}, {-5, 2, 3}}},
//                {new int[]{-4, -2, -2, -2, 0, 1, 2, 2, 2, 3, 3, 4, 4, 6, 6},
//                        new int[][]{{-4, -2, 6}, {-4, 0, 4}, {-4, 1, 3}, {-4, 2, 2}, {-2, -2, 4}, {-2, 0, 2}}},
        };

        int ok = 0;
        for (Object[] t : teste) {
            int[] nums = (int[]) t[0];
            List<List<Integer>> asteptat = new ArrayList<>();
            for (int[] triplet : (int[][]) t[1]) {
                asteptat.add(Arrays.stream(triplet).boxed().toList());
            }
            String input = Arrays.toString(nums);
            List<List<Integer>> rezultat = sol.threeSum(nums.clone());
            // ordinea tripletelor și a numerelor din triplet nu contează
            boolean pass = normalizeaza(rezultat).equals(normalizeaza(asteptat));
            if (pass) ok++;
            System.out.println((pass ? "PASS" : "FAIL") + "  " + input + " -> " + rezultat
                    + (pass ? "" : "  (așteptat " + asteptat + ")"));
        }
        System.out.println("\n" + ok + "/" + teste.length + " teste trecute");
    }

    private static List<List<Integer>> normalizeaza(List<List<Integer>> triplete) {
        List<List<Integer>> rezultat = new ArrayList<>();
        for (List<Integer> triplet : triplete) {
            List<Integer> sortat = new ArrayList<>(triplet);
            sortat.sort(null);
            rezultat.add(sortat);
        }
        rezultat.sort((a, b) -> a.toString().compareTo(b.toString()));
        return rezultat;
    }

    // [-4,-1,-1,0,1,5]
    //-5, 0, 0, 2, 3, 5
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);

        List<List<Integer>> result = new ArrayList<>();

        for (int i = 0; i < nums.length - 2; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            if (nums[i] > 0) {
                break;
            }

            int left = i + 1;
            int right = nums.length - 1;

            while (left < right) {
                int sum = nums[i] + nums[left] + nums[right];

                if (sum < 0) {
                    left++;
                } else if (sum > 0) {
                    right--;
                } else {
                    result.add(Arrays.asList(nums[i], nums[left], nums[right]));

                    while (left < right && nums[left] == nums[left + 1]) {
                        left++;
                    }
                    while (left < right && nums[right] == nums[right - 1]) {
                        right--;
                    }
                    left++;
                    right--;
                }
            }
        }
        return result;
    }


}


