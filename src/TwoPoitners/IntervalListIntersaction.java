package TwoPoitners;

import java.util.Arrays;

//You are given two lists of closed intervals, firstList and secondList, where firstList[i] = [starti, endi] and secondList[j] = [startj, endj]. Each list of intervals is pairwise disjoint and in sorted order.
//
//Return the intersection of these two interval lists.
//
//A closed interval [a, b] (with a <= b) denotes the set of real numbers x with a <= x <= b.
//
//The intersection of two closed intervals is a set of real numbers that are either empty or represented as a closed interval. For example, the intersection of [1, 3] and [2, 4] is [2, 3].
//
//
//
//Example 1:
//
//
//Input: firstList = [[0,2],[5,10],[13,23],[24,25]], secondList = [[1,5],[8,12],[15,24],[25,26]]
//Output: [[1,2],[5,5],[8,10],[15,23],[24,24],[25,25]]
//Example 2:
//
//Input: firstList = [[1,3],[5,9]], secondList = []
//Output: []
public class IntervalListIntersaction {

    static void main() {
        IntervalListIntersaction sol = new IntervalListIntersaction();
        int[][][][] teste = {
                // { firstList, secondList, output așteptat }
                {{{0, 2}, {5, 10}, {13, 23}, {24, 25}}, {{1, 5}, {8, 12}, {15, 24}, {25, 26}},
                        {{1, 2}, {5, 5}, {8, 10}, {15, 23}, {24, 24}, {25, 25}}},
                {{{1, 3}, {5, 9}}, {}, {}},
                {{}, {{1, 3}}, {}},
                {{{1, 7}}, {{3, 10}}, {{3, 7}}},
                {{{1, 2}}, {{3, 4}}, {}},                              // fără suprapunere
                {{{1, 3}}, {{3, 5}}, {{3, 3}}},                        // se ating într-un punct
                {{{0, 10}}, {{1, 2}, {4, 5}, {7, 8}}, {{1, 2}, {4, 5}, {7, 8}}}, // unul le acoperă pe toate
                {{{1, 2}, {4, 5}, {7, 8}}, {{0, 10}}, {{1, 2}, {4, 5}, {7, 8}}}, // invers
                {{{1, 5}}, {{1, 5}}, {{1, 5}}},                        // identice
                {{{5, 5}}, {{5, 5}}, {{5, 5}}},                        // intervale de un punct
                {{{1, 2}, {5, 6}}, {{3, 4}, {7, 8}}, {}},              // alternează fără suprapunere
                {{{3, 5}, {9, 20}}, {{4, 5}, {7, 10}, {11, 12}, {14, 15}, {16, 20}},
                        {{4, 5}, {9, 10}, {11, 12}, {14, 15}, {16, 20}}},
        };

        int ok = 0;
        for (int[][][] t : teste) {
            int[][] first = t[0];
            int[][] second = t[1];
            int[][] asteptat = t[2];
            String input = Arrays.deepToString(first) + ", " + Arrays.deepToString(second);

            int[][] rezultat = sol.intervalIntersection(first, second);
            boolean pass = Arrays.deepEquals(rezultat, asteptat);
            if (pass) ok++;
            System.out.println((pass ? "PASS" : "FAIL") + "  " + input + " -> " + Arrays.deepToString(rezultat)
                    + (pass ? "" : "  (așteptat " + Arrays.deepToString(asteptat) + ")"));
        }
        System.out.println("\n" + ok + "/" + teste.length + " teste trecute");
    }

    public int[][] intervalIntersection(int[][] firstList, int[][] secondList) {
        int i = 0;
        int j = 0;
        int[][] result = new int[firstList.length + secondList.length][];
        int k = 0;
        while(i<firstList.length && j<secondList.length){
            int a[] = firstList[i];
            int b[] = secondList[j];

            int minFirst = Math.max(a[0],b[0]);
            int minLast = Math.min(a[1],b[1]);
            if(minFirst<=minLast){
                result[k++] = new int[]{minFirst,minLast};
            }
            if(a[1]<b[1]){
                i++;
            }else{
                j++;
            }

        }
        return Arrays.copyOf(result,k);
    }
}
