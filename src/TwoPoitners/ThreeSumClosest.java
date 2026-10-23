package TwoPoitners;

import java.util.Arrays;

//3Sum Closest
//Medium
//Topics
//premium lock icon
//Companies
//You are given an integer array nums of length n and an integer target.
//
//Find three integers at distinct indices in nums such that the sum is closest to target.
//
//Return the sum of the three integers.
//
//You may assume that each input would have exactly one solution.
//
//
//
//Example 1:
//
//Input: nums = [-1,2,1,-4], target = 1
//Output: 2
//Explanation: The sum that is closest to the target is 2. (-1 + 2 + 1 = 2).
//Example 2:
//
//Input: nums = [0,0,0], target = 1
//Output: 0
//Explanation: The sum that is closest to the target is 0. (0 + 0 + 0 = 0).
public class ThreeSumClosest {

    static void main() {
        ThreeSumClosest sol = new ThreeSumClosest();
        Object[][] teste = {
                // { nums, target, output așteptat }
                {new int[]{-1, 2, 1, -4}, 1, 2},
                {new int[]{0, 0, 0}, 1, 0},
                {new int[]{1, 1, 1}, 3, 3},
                {new int[]{1, 1, 1}, 0, 3},
                {new int[]{0, 1, 2}, 0, 3},
                {new int[]{1, 2, 3}, 100, 6},
                {new int[]{1, 2, 3}, -100, 6},
                {new int[]{1, 1, 1, 0}, -100, 2},
                {new int[]{1, 1, 1, 0}, 100, 3},
                {new int[]{0, 2, 1, -3}, 1, 0},
                {new int[]{-3, -2, -5, 3, -4}, -1, -2},
                {new int[]{1, 1, -1, -1, 3}, -1, -1},
                {new int[]{-1, 0, 1, 1, 55}, 3, 2},
                {new int[]{2, 3, 8, 9, 10}, 16, 15},
                {new int[]{10, 20, 30, 40, 50}, 70, 70},
                {new int[]{-100, -98, -2, -1}, -101, -101},
                {new int[]{4, 0, 5, -5, 3, 3, 0, -4, -5}, -2, -2},
                {new int[]{1, 2, 4, 8, 16, 32, 64, 128}, 82, 82},
                {new int[]{-55, -24, -18, -11, -7, -3, 4, 5, 6, 9, 11, 23, 33}, 0, 0},
                {new int[]{-1000, -1000, -1000}, -3000, -3000},
                {new int[]{1000, 1000, 1000}, -10000, 3000},
        };

        int ok = 0;
        for (Object[] t : teste) {
            int[] nums = (int[]) t[0];
            int target = (int) t[1];
            int asteptat = (int) t[2];
            String input = Arrays.toString(nums);
            int rezultat = sol.threeSumClosest(nums.clone(), target);
            boolean pass = rezultat == asteptat;
            if (pass) ok++;
            System.out.println((pass ? "PASS" : "FAIL") + "  " + input + ", target=" + target + " -> " + rezultat
                    + (pass ? "" : "  (așteptat " + asteptat + ")"));
        }
        System.out.println("\n" + ok + "/" + teste.length + " teste trecute");
    }

    //[-4,-1,1,2} 1 -> 2
    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int closest = nums[0] + nums[1] + nums[2];
        if (nums == null || nums.length == 0) return 0;
        if (nums.length == 2) return nums[0] + nums[1] + nums[2];


        for (int i = 0; i < nums.length - 2; i++) {

            int left = i + 1;
            int right = nums.length - 1;

            while (left < right) {
                int sum = nums[i] + nums[left] + nums[right];
                if (sum == target) {
                    return sum;
                } else if (sum < target) {
                    left++;
                } else {
                    right--;
                }

                if (Math.abs(sum - target) < Math.abs(closest - target)) {
                    closest = sum;
                }
            }


        }

        return closest;


    }
}
