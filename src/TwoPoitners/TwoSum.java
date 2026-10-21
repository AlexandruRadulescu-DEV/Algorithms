package TwoPoitners;

import java.util.Arrays;

//Two Sum II - Input Array Is Sorted
//Medium
//Topics
//premium lock icon
//Companies
//You are given a 1-indexed array of integers numbers that is already sorted in non-decreasing order.
//
//Find two numbers such that they add up to a specific target number. Let these two numbers be numbers[index1] and numbers[index2] where 1 <= index1 < index2 <= numbers.length.
//
//Return the indices of the two numbers index1 and index2 as an integer array [index1, index2] of length 2.
//
//The tests are generated such that there is exactly one solution. You may not use the same element twice.
//
//Your solution must use only constant extra space.
//
//
//
//Example 1:
//
//Input: numbers = [2,7,11,15], target = 9
//Output: [1,2]
//Explanation: The sum of 2 and 7 is 9. Therefore, index1 = 1, index2 = 2. We return [1, 2].
//Example 2:
//
//Input: numbers = [2,3,4], target = 6
//Output: [1,3]
//Explanation: The sum of 2 and 4 is 6. Therefore index1 = 1, index2 = 3. We return [1, 3].
//Example 3:
//
//Input: numbers = [-1,0], target = -1
//Output: [1,2]
//Explanation: The sum of -1 and 0 is -1. Therefore index1 = 1, index2 = 2. We return [1, 2].
public class TwoSum {

    static void main() {
        TwoSum sol = new TwoSum();
        int[][] numbers = {
                {2, 7, 11, 15},
                {2, 3, 4},
                {-1, 0},
                {1, 2},
                {1, 2, 3, 4, 5},
                {1, 2, 3, 4, 5},
                {0, 0, 3, 4},
                {-5, -3, -1, 0, 2},
                {-3, -1, 0, 4, 10},
                {5, 25, 75},
                {1, 3, 4, 4},
                {-1000, -1, 0, 2, 1000},
                {1, 2, 3, 4, 4, 9, 56, 90},
                {2, 3, 5, 7, 11, 13},
                {1, 2, 6, 10},
                {3, 24, 50, 79, 88, 150, 345},
        };
        int[] targets = {9, 6, -1, 3, 9, 3, 0, -8, 1, 100, 8, 0, 8, 24, 12, 200};
        int[][] expected = {
                {1, 2}, {1, 3}, {1, 2}, {1, 2}, {4, 5}, {1, 2}, {1, 2}, {1, 2},
                {1, 4}, {2, 3}, {3, 4}, {1, 5}, {4, 5}, {5, 6}, {2, 4}, {3, 6},
        };

        int ok = 0;
        for (int i = 0; i < numbers.length; i++) {
            int[] rezultat = sol.twoSum(numbers[i], targets[i]);
            boolean pass = Arrays.equals(rezultat, expected[i]);
            if (pass) ok++;
            System.out.println((pass ? "PASS" : "FAIL") + "  " + Arrays.toString(numbers[i]) + ", target = " + targets[i]
                    + " -> " + Arrays.toString(rezultat)
                    + (pass ? "" : "  (așteptat " + Arrays.toString(expected[i]) + ")"));
        }
        System.out.println("\n" + ok + "/" + numbers.length + " teste trecute");
    }


    public int[] twoSum(int[] numbers, int target) {
        if (numbers == null || numbers.length <= 0) return new int[]{};

        int left = 0;
        int right = numbers.length - 1;
        int[] result = new int[]{};

        while (left < right) {

            int sum = numbers[left] + numbers[right];
            if(sum>target){
                right--;
            }else if(sum<target){
                left++;
            }else{
                return new int[]{++left, ++right};
            }
        }
        return new int[]{};
    }
}
