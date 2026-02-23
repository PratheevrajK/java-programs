package arrays;

public class A_findMaxConsecutiveOnes {
    public static void main(String[] args) {
        int[] arr = {1,1,0,1,0,0,1,1,1,1,0,0,1,1,0,0,0,1,1,1,0,1,0,0,0,1,1,1,1,1};
        int maxCount = findMaxConsecutiveOnes(arr);
        System.out.println(maxCount);
    }
    public static int findMaxConsecutiveOnes(int[] nums) {
        int maxCount = 0;
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            if(nums[i]==1) {
                count++;
            } else {
                if (count > maxCount) {
                    maxCount = count;
                }
                count=0;
            }
        }
        return Math.max(count, maxCount);
    }
}
