package TwoPoitners;

import java.util.Arrays;

//Given an integer array nums sorted in non-decreasing order, return an array of the squares of each number sorted in non-decreasing order.
//
//
//
//Example 1:
//
//Input: nums = [-4,-1,0,3,10]
//Output: [0,1,9,16,100]
//Explanation: After squaring, the array becomes [16,1,0,9,100].
//After sorting, it becomes [0,1,9,16,100].
//Example 2:
//
//Input: nums = [-7,-3,2,3,11]
//Output: [4,9,9,49,121]
//
public class SquaresOfASortedArray {

    static void main() {
        SquaresOfASortedArray sol = new SquaresOfASortedArray();
        int[][][] teste = {
                // { input, output așteptat }
                {{-4, -1, 0, 3, 10}, {0, 1, 9, 16, 100}},
                {{-7, -3, 2, 3, 11}, {4, 9, 9, 49, 121}},
                {{1}, {1}},
                {{-1}, {1}},
                {{0}, {0}},
                {{1, 2, 3, 4}, {1, 4, 9, 16}},
                {{-4, -3, -2, -1}, {1, 4, 9, 16}},
                {{-3, 3}, {9, 9}},
                {{-2, -1, 0, 1, 2}, {0, 1, 1, 4, 4}},
                {{0, 0, 0}, {0, 0, 0}},
                {{-5, -5, 5, 5}, {25, 25, 25, 25}},
                {{-10, 1, 2}, {1, 4, 100}},
                {{-2, -1, 10}, {1, 4, 100}},
                {{-1, 2, 2}, {1, 4, 4}},
                {{-3, -2, 0, 0, 1}, {0, 0, 1, 4, 9}},
                {{-10000, 10000}, {100000000, 100000000}},
        };

        int ok = 0;
        for (int[][] t : teste) {
            int[] rezultat = sol.sortedSquares(t[0].clone());
            boolean pass = Arrays.equals(rezultat, t[1]);
            if (pass) ok++;
            System.out.println((pass ? "PASS" : "FAIL") + "  " + Arrays.toString(t[0]) + " -> " + Arrays.toString(rezultat)
                    + (pass ? "" : "  (așteptat " + Arrays.toString(t[1]) + ")"));
        }
        System.out.println("\n" + ok + "/" + teste.length + " teste trecute");
    }

    public int[] sortedSquares(int[] nums) {
        int left = 0;
        int right = nums.length - 1;
        int k = nums.length - 1;
        int[] result = new int[nums.length];

        while (left <= right) {
            int tempLeft = nums[left] * nums[left];
            int tempRight = nums[right] * nums[right];
            if (tempLeft > tempRight) {
                result[k--] = tempLeft;
                left++;

            } else {
                result[k--] = tempRight;
                right--;
            }
        }
        return result;
    }
}
