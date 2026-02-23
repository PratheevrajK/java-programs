package leetcode.arrays;

import java.util.Arrays;

public class C_twoSum {
    public static void main(String[] args) {
        int[] nums = {2,7,11,15};
        int[] indices = twoSum(nums, 22);
        System.out.println(Arrays.toString(indices));
    }
    //Brute-force approach
    //Time complexity - O[n2]
    //Space complexity - O[1]
    public static int[] twoSum(int[] nums, int target) {
        for (int i=0; i < nums.length; i++) {
            for (int j=i+1; j < nums.length; j++) {
                if(nums[i]+nums[j] == target) {
                    return new int[]{i, j};
                }
            }
        }
        return new int[] {-1, -1};
    }
}
