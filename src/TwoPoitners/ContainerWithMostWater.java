package TwoPoitners;

import static java.util.Collections.min;

//You are given an integer array height of length n. There are n vertical lines drawn such that the two endpoints of the ith line are (i, 0) and (i, height[i]).
//
//Find two lines that together with the x-axis form a container, such that the container contains the most water.
//
//Return the maximum amount of water a container can store.
//
//Notice that you may not slant the container.
//
//
//
//Example 1:
//
//
//Input: height = [1,8,6,2,5,4,8,3,7]
//Output: 49
//Explanation: The above vertical lines are represented by array [1,8,6,2,5,4,8,3,7]. In this case, the max area of water (blue section) the container can contain is 49.
//Example 2:
//
//Input: height = [1,1]
//Output: 1
public class ContainerWithMostWater {

    static void main() {
        ContainerWithMostWater solution = new ContainerWithMostWater();

//        int[] height1 = {1, 8, 6, 2, 5, 4, 8, 3, 7};
//        System.out.println(solution.maxArea(height1)); // expected: 49
//
//        int[] height2 = {1, 1};
//        System.out.println(solution.maxArea(height2)); // expected: 1

        int[] height3 = {3,6,1};
        System.out.println(solution.maxArea(height3)); // expected: 3
    }


    public int maxArea(int[] height) {

        int left = 0;
        int right = height.length-1;
        int max = 0;
        while(left<right){
            int value = Math.min(height[left],height[right]) * (right-left);

            if(value>max){
                max = value;
            }
            int savedRight = right;
            int savedLeft = left;
            int maxFromLeft  = height[left] + height[right - 1];
            int maxFromRight = height[left + 1] + height[right];
            if(height[left]>height[right]){
                right--;
            }else{
                left++;
            }



        }
        return max;

    }
}
