package TwoPoitners;

import java.util.Arrays;

//Boats to Save People
//Medium
//Topics
//premium lock icon
//Companies
//You are given an array people where people[i] is the weight of the ith person, and an infinite number of boats where each boat can carry a maximum weight of limit. Each boat carries at most two people at the same time, provided the sum of the weight of those people is at most limit.
//
//Return the minimum number of boats to carry every given person.
//
//
//
//Example 1:
//
//Input: people = [1,2], limit = 3
//Output: 1
//Explanation: 1 boat (1, 2)
//Example 2:
//
//Input: people = [3,2,2,1], limit = 3
//Output: 3
//Explanation: 3 boats (1, 2), (2) and (3)
//Example 3:
//
//Input: people = [3,5,3,4], limit = 5
//Output: 4
//Explanation: 4 boats (3), (3), (4), (5)
public class BoatsToSavePeople {

    static void main() {
        BoatsToSavePeople sol = new BoatsToSavePeople();
        Object[][] teste = {
                // { people, limit, output așteptat }
//                {new int[]{1, 2}, 3, 1},
//                {new int[]{3, 2, 2, 1}, 3, 3},
//                {new int[]{3, 5, 3, 4}, 5, 4},
//                {new int[]{5}, 5, 1},
//                {new int[]{1}, 5, 1},
//                {new int[]{1, 1}, 2, 1},
//                {new int[]{2, 2}, 3, 2},
//                {new int[]{2, 4}, 5, 2},
                {new int[]{5, 1, 4, 2}, 6, 2},
//                {new int[]{1, 1, 1, 1}, 2, 2},
//                {new int[]{1, 1, 1, 1, 1}, 2, 3},
//                {new int[]{5, 5, 5}, 5, 3},
//                {new int[]{3, 3, 3, 3}, 6, 2},
//                {new int[]{2, 2, 2, 2}, 4, 2},
//                {new int[]{4, 1, 4, 1}, 5, 2},
//                {new int[]{7, 3, 2}, 8, 2},
//                {new int[]{1, 2, 3}, 10, 2},
//                {new int[]{1, 2, 2, 3}, 3, 3},
//                {new int[]{3, 2, 3, 2, 2}, 6, 3},
//                {new int[]{1, 5, 3, 5}, 7, 3},
//                {new int[]{2, 49, 50, 1}, 50, 3},
//                {new int[]{1, 2, 3, 4, 5, 6}, 7, 3},
//                {new int[]{6, 6, 6, 1, 1, 1}, 7, 3},
//                {new int[]{10, 9, 8, 7, 6}, 10, 5},
        };

        int ok = 0;
        for (Object[] t : teste) {
            int[] people = (int[]) t[0];
            int limit = (int) t[1];
            int asteptat = (int) t[2];
            String input = Arrays.toString(people);
            int rezultat = sol.numRescueBoats(people.clone(), limit);
            boolean pass = rezultat == asteptat;
            if (pass) ok++;
            System.out.println((pass ? "PASS" : "FAIL") + "  " + input + ", limit=" + limit + " -> " + rezultat
                    + (pass ? "" : "  (așteptat " + asteptat + ")"));
        }
        System.out.println("\n" + ok + "/" + teste.length + " teste trecute");
    }

    public int numRescueBoats(int[] people, int limit) {
        Arrays.sort(people);
        if(people.length == 0 ) return 0;
        if(people.length == 1) return 1;
        int left = 0;
        int right = people.length-1;
        int boatIncrement = 0;
        while(left<=right){
            int weight = people[left] + people[right];

            if(weight == limit) {
                boatIncrement++;
                left++;
                right--;
            }else if(weight > limit){
              if(people[left] == limit){
                  boatIncrement++;
                  left++;
              }else if(people[right] == limit){
                  boatIncrement++;
                  right--;
              }else{
                  if(people[left]>people[right]){
                    left++;
                    boatIncrement++;
                  }else{
                      right--;
                      boatIncrement++;
                  }
              }

            }else{
                boatIncrement++;
                left++;
                right--;
            }

        }
        return boatIncrement;

    }
}
