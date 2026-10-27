package TwoPoitners;

import java.util.Arrays;

public class MoveZeroes {

    //Given an integer array nums, move all 0's to the end of it while maintaining the relative order of the non-zero elements.
    //
    //Note that you must do this in-place without making a copy of the array.
    //
    //
    //
    //Example 1:
    //
    //Input: nums = [0,1,0,3,12]
    //Output: [1,3,12,0,0]
    //Example 2:
    //
    //Input: nums = [0]
    //Output: [0]

    static void main() {
        MoveZeroes sol = new MoveZeroes();
        Object[][] teste = {
                // { nums, output așteptat }
                {new int[]{0, 1, 0, 3, 12}, new int[]{1, 3, 12, 0, 0}},
                {new int[]{0}, new int[]{0}},
                {new int[]{}, new int[]{}},
                {new int[]{1}, new int[]{1}},
                {new int[]{0, 1}, new int[]{1, 0}},
                {new int[]{1, 0}, new int[]{1, 0}},
                {new int[]{0, 0, 0}, new int[]{0, 0, 0}},
                {new int[]{1, 2, 3}, new int[]{1, 2, 3}},
                {new int[]{0, 0, 1}, new int[]{1, 0, 0}},
                {new int[]{1, 0, 0}, new int[]{1, 0, 0}},
                {new int[]{0, 1, 0}, new int[]{1, 0, 0}},
                {new int[]{4, 0, 5, 0, 6}, new int[]{4, 5, 6, 0, 0}},
                {new int[]{0, 0, 0, 7, 8}, new int[]{7, 8, 0, 0, 0}},
                {new int[]{-1, 0, -2, 0, 3}, new int[]{-1, -2, 3, 0, 0}},
                {new int[]{3, 3, 0, 3, 0, 3}, new int[]{3, 3, 3, 3, 0, 0}},
                {new int[]{5, 4, 3, 0, 2, 1}, new int[]{5, 4, 3, 2, 1, 0}},
                {new int[]{0, 1, 0, 1, 0, 1, 0}, new int[]{1, 1, 1, 0, 0, 0, 0}},
                {new int[]{Integer.MAX_VALUE, 0, Integer.MIN_VALUE}, new int[]{Integer.MAX_VALUE, Integer.MIN_VALUE, 0}},
        };

        int ok = 0;
        for (Object[] t : teste) {
            int[] nums = ((int[]) t[0]).clone();
            int[] asteptat = (int[]) t[1];
            String input = Arrays.toString(nums);

            sol.moveZeroes(nums);
            // in-place: verificăm tot array-ul, ordinea nenulelor contează
            boolean pass = Arrays.equals(nums, asteptat);
            if (pass) ok++;
            System.out.println((pass ? "PASS" : "FAIL") + "  " + input + " -> " + Arrays.toString(nums)
                    + (pass ? "" : "  (așteptat " + Arrays.toString(asteptat) + ")"));
        }
        System.out.println("\n" + ok + "/" + teste.length + " teste trecute");
    }
    public void moveZeroes(int[] nums) {

        int left = 0;
        int k = 0;
        while(left<=nums.length-1){
            if(nums[left]!=0){
                nums[k++] = nums[left];
            }
            left++;
        }

        while(k<=nums.length-1){
            nums[k++] = 0;
        }

    }

}
