package TwoPoitners;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//Given an array nums of n integers, return an array of all the unique quadruplets [nums[a], nums[b], nums[c], nums[d]] such that:
//
//0 <= a, b, c, d < n
//a, b, c, and d are distinct.
//nums[a] + nums[b] + nums[c] + nums[d] == target
//You may return the answer in any order.
//
//
//
//Example 1:
//
//Input: nums = [1,0,-1,0,-2,2], target = 0
//Output: [[-2,-1,1,2],[-2,0,0,2],[-1,0,0,1]]
//Example 2:
//
//Input: nums = [2,2,2,2,2], target = 8
//Output: [[2,2,2,2]]
//
//
//Constraints:
//
//1 <= nums.length <= 200
//-109 <= nums[i] <= 109
//-109 <= target <= 109
public class ForthSum {

    static void main() {
        ForthSum sol = new ForthSum();
        Object[][] teste = {
                // { nums, target, output așteptat }
                {new int[]{1, 0, -1, 0, -2, 2}, 0, new int[][]{{-2, -1, 1, 2}, {-2, 0, 0, 2}, {-1, 0, 0, 1}}},
                {new int[]{2, 2, 2, 2, 2}, 8, new int[][]{{2, 2, 2, 2}}},
                {new int[]{1, 2, 3}, 6, new int[][]{}},
                {new int[]{}, 0, new int[][]{}},
                {new int[]{1, 2, 3, 4}, 10, new int[][]{{1, 2, 3, 4}}},
                {new int[]{1, 2, 3, 4}, 11, new int[][]{}},
                {new int[]{0, 0, 0, 0, 0, 0}, 0, new int[][]{{0, 0, 0, 0}}},
                {new int[]{-2, -1, -1, 1, 1, 2, 2}, 0, new int[][]{{-2, -1, 1, 2}, {-1, -1, 1, 1}}},
                {new int[]{-3, -2, -1, 0, 0, 1, 2, 3}, -1,
                        new int[][]{{-3, -2, 1, 3}, {-3, -1, 0, 3}, {-3, -1, 1, 2}, {-3, 0, 0, 2}, {-2, -1, 0, 2}, {-2, 0, 0, 1}}},
                {new int[]{-3, -2, -1, 0, 0, 1, 2, 3}, 0,
                        new int[][]{{-3, -2, 2, 3}, {-3, -1, 1, 3}, {-3, 0, 0, 3}, {-3, 0, 1, 2}, {-2, -1, 0, 3}, {-2, -1, 1, 2}, {-2, 0, 0, 2}, {-1, 0, 0, 1}}},
                {new int[]{1, -2, -5, -4, -3, 3, 3, 5}, -11, new int[][]{{-5, -4, -3, 1}}},
                {new int[]{-1, 0, 1, 2, -1, -4}, -1, new int[][]{{-4, 0, 1, 2}, {-1, -1, 0, 1}}},
                {new int[]{1, 2, 3, 4, 5}, 100, new int[][]{}},
                {new int[]{-5, -4, -3, -2}, -14, new int[][]{{-5, -4, -3, -2}}},
                {new int[]{5, 5, 3, 5, 1, -5, 1, -2}, 4, new int[][]{{-5, 1, 3, 5}}},
                // overflow: suma ca int dă -294967296, trebuie long
                {new int[]{1000000000, 1000000000, 1000000000, 1000000000}, -294967296, new int[][]{}},
                {new int[]{-1000000000, -1000000000, -1000000000, -1000000000}, 294967296, new int[][]{}},
                {new int[]{1000000000, 1000000000, 1000000000, 1000000000}, 0, new int[][]{}},
        };

        int ok = 0;
        for (Object[] t : teste) {
            int[] nums = (int[]) t[0];
            int target = (int) t[1];
            List<List<Integer>> asteptat = new ArrayList<>();
            for (int[] cvadruplet : (int[][]) t[2]) {
                asteptat.add(Arrays.stream(cvadruplet).boxed().toList());
            }
            String input = Arrays.toString(nums);
            List<List<Integer>> rezultat = sol.fourSum(nums.clone(), target);
            // ordinea cvadrupletelor și a numerelor din cvadruplet nu contează
            boolean pass = normalizeaza(rezultat).equals(normalizeaza(asteptat));
            if (pass) ok++;
            System.out.println((pass ? "PASS" : "FAIL") + "  " + input + ", target=" + target + " -> " + rezultat
                    + (pass ? "" : "  (așteptat " + asteptat + ")"));
        }
        System.out.println("\n" + ok + "/" + teste.length + " teste trecute");
    }

    private static List<List<Integer>> normalizeaza(List<List<Integer>> cvadruplete) {
        List<List<Integer>> rezultat = new ArrayList<>();
        for (List<Integer> cvadruplet : cvadruplete) {
            List<Integer> sortat = new ArrayList<>(cvadruplet);
            sortat.sort(null);
            rezultat.add(sortat);
        }
        rezultat.sort((a, b) -> a.toString().compareTo(b.toString()));
        return rezultat;
    }

    public List<List<Integer>> fourSum(int[] nums, int target) {
        Arrays.sort(nums);
        List<List<Integer>> result = new ArrayList<>();

        if (nums == null || nums.length < 3) return result;

        for (int i = 0; i < nums.length - 3; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) continue;
            for (int j = i + 1; j < nums.length - 2; j++) {
                if (j > i + 1 && nums[j] == nums[j - 1]) continue;
                int left = j + 1;
                int right = nums.length - 1;

                while (left < right) {
                    long sum = (long) nums[i] + nums[j] + nums[left] + nums[right];
                    if (sum == target) {
                        result.add(Arrays.asList(nums[i], nums[j], nums[left], nums[right]));
                        left++;
                        right--;

                        while (left < right && nums[left] == nums[left - 1]) left++;
                        while (left < right && nums[right] == nums[right + 1]) right--;
                    } else if (sum > target) {
                        right--;
                    } else {
                        left++;
                    }

                }
            }

        }

        return result;

    }

}
