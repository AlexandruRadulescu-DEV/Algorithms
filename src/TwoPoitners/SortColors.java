package TwoPoitners;

import java.util.Arrays;

//Sort Colors
//Medium
//Topics
//premium lock icon
//Companies
//Hint
//You are given an array nums with n objects colored red, white, or blue, sort them in-place so that objects of the same color are adjacent, with the colors in the order red, white, and blue.
//
//We will use the integers 0, 1, and 2 to represent the color red, white, and blue, respectively.
//
//You must solve this problem without using the library's sort function.
//
//
//
//Example 1:
//
//Input: nums = [2,0,2,1,1,0]
//
//Output: [0,0,1,1,2,2]
//
//Explanation:
//
//The array has two 0s, two 1s, and two 2s. Sorting them in-place places all 0s first, then all 1s, then all 2s.
//
//Example 2:
//
//Input: nums = [2,0,1]
//
//Output: [0,1,2]
//
//Explanation:
//
//The array has one each of 0, 1, and 2, arranged in-place in the order 0, 1, 2
public class SortColors {

    static void main() {
        SortColors sol = new SortColors();
        int[][] teste = {
                {2, 0, 2, 1, 1, 0},
                {2, 0, 1},
                {0},
                {1},
                {2},
                {0, 1},
                {1, 0},
                {2, 2},
                {0, 0, 0, 0},
                {2, 2, 2, 2},
                {0, 1, 2},
                {2, 1, 0},
                {2, 1, 0, 2, 1, 0},
                {1, 1, 1, 0},
                {2, 0, 0, 0},
                {1, 2, 0},
                {0, 2, 1, 2, 0, 1, 1},
                {2, 2, 1, 1, 0, 0},
                {1, 0, 2, 1, 0, 2, 1, 0, 2, 1},
                {0, 0, 2, 2, 1, 1, 0, 2},
        };

        int ok = 0;
        for (int[] t : teste) {
            int[] nums = t.clone();
            int[] asteptat = t.clone();
            Arrays.sort(asteptat); // doar pentru verificare
            String input = Arrays.toString(nums);

            String rezultat;
            boolean pass;
            try {
                sol.sortColors(nums);
                rezultat = Arrays.toString(nums);
                pass = Arrays.equals(nums, asteptat);
            } catch (Exception e) {
                rezultat = e.getClass().getSimpleName();
                pass = false;
            }
            if (pass) ok++;
            System.out.println((pass ? "PASS" : "FAIL") + "  " + input + " -> " + rezultat
                    + (pass ? "" : "  (așteptat " + Arrays.toString(asteptat) + ")"));
        }
        System.out.println("\n" + ok + "/" + teste.length + " teste trecute");
    }
    public void sortColors(int[] nums) {


        int right = nums.length-1;

        while (right > 0) {
            int left = 0;

            while (left < right) {
                if (nums[left] > nums[left + 1]) {
                    int temp = nums[left];
                    nums[left] = nums[left + 1];
                    nums[left + 1] = temp;
                }
                left++;
            }

            right--;
        }


    }

}
