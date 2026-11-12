package TwoPoitners;

import java.util.HashSet;
import java.util.Set;

//Given an array of integers nums containing n + 1 integers where each integer is in the range [1, n] inclusive.
//
//There is only one repeated number in nums, return this repeated number.
//
//You must solve the problem without modifying the array nums and using only constant extra space.
//
//
//
//Example 1:
//
//Input: nums = [1,3,4,2,2]
//Output: 2
//Example 2:
//
//Input: nums = [3,1,3,4,2]
//Output: 3
//Example 3:
//
//Input: nums = [3,3,3,3,3]
//Output: 3
public class FindTheDuplicateNumber {

    static void main() {
        FindTheDuplicateNumber sol = new FindTheDuplicateNumber();
        Object[][] teste = {
                // { nums, output așteptat }
                {new int[]{1, 3, 4, 2, 2}, 2},                 // exemplul 1
                {new int[]{3, 1, 3, 4, 2}, 3},                 // exemplul 2
                {new int[]{3, 3, 3, 3, 3}, 3},                 // exemplul 3 (apare de mai multe ori)
                {new int[]{1, 1}, 1},                          // cel mai mic caz posibil (n = 1)
                {new int[]{1, 1, 2}, 1},                       // duplicatul la început
                {new int[]{2, 1, 2}, 2},                       // duplicatul la început și la final
                {new int[]{1, 2, 3, 4, 4}, 4},                 // duplicatul la final
                {new int[]{4, 1, 2, 3, 4}, 4},                 // duplicatul = n (valoarea maximă)
                {new int[]{1, 4, 1, 2, 3}, 1},                 // duplicatul = 1 (valoarea minimă)
                {new int[]{2, 2, 2, 2, 2}, 2},                 // toate la fel
                {new int[]{1, 2, 2, 2, 5}, 2},                 // apare de 3 ori, lipsesc alte numere
                {new int[]{9, 8, 7, 6, 5, 4, 3, 2, 1, 5}, 5},  // descrescător, duplicat la mijloc
                {new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 1}, 1},  // primul și ultimul
                {new int[]{7, 9, 7, 4, 2, 8, 7, 7, 1, 5}, 7},  // apare de 4 ori, împrăștiat
        };

        int ok = 0;
        for (Object[] t : teste) {
            int[] nums = (int[]) t[0];
            int asteptat = (int) t[1];
            int[] copie = nums.clone();

            String rezultatText;
            boolean pass;
            try {
                int rezultat = sol.findDuplicate(nums);
                // problema cere să nu modifici array-ul, așa că verificăm și asta
                boolean nemodificat = java.util.Arrays.equals(nums, copie);
                pass = rezultat == asteptat && nemodificat;
                rezultatText = rezultat + (nemodificat ? "" : " (array-ul a fost modificat!)");
            } catch (Exception e) {
                pass = false;
                rezultatText = e.getClass().getSimpleName();
            }
            if (pass) ok++;
            System.out.println((pass ? "PASS" : "FAIL") + "  " + java.util.Arrays.toString(copie)
                    + " -> " + rezultatText
                    + (pass ? "" : "  (așteptat " + asteptat + ")"));
        }
        System.out.println("\n" + ok + "/" + teste.length + " teste trecute");
    }
    public int findDuplicate(int[] nums) {

        Set<Integer> countElements = new HashSet<>();

        for(int i=0;i<nums.length;i++){
            if(countElements.contains(nums[i])){
                return nums[i];
            }else{
                countElements.add(nums[i]);
            }
        }
        return 0;
    }
}
