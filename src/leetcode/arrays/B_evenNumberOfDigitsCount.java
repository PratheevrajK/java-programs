package leetcode.arrays;
//Input: nums = [12,345,2,6,7896]
//Output: 2
//Explanation:
//        12 contains 2 digits (even number of digits).
//        345 contains 3 digits (odd number of digits).
//        2 contains 1 digit (odd number of digits).
//        6 contains 1 digit (odd number of digits).
//        7896 contains 4 digits (even number of digits).
//Therefore only 12 and 7896 contain an even number of digits.
public class B_evenNumberOfDigitsCount {
    public static void main(String[] args) {
        int[] arr = {12,345,2,6,7896};
        int count = findNumbers(arr);
        System.out.println(count);
    }
    public static int findNumbers(int[] nums) {
        int totalCount = 0;
        for (int i : nums) {
            int count = 0;
            if(i<=0) continue;
            while (i > 0) {
                count++;
                i = i/10;
            }
            if (count%2 == 0) totalCount++;
        }
        return totalCount;
    }
}
