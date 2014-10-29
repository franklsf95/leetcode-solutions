public class Solution {
    public int findMin(int[] num) {
        if (num.length == 0) {
            return 0;
        }
        int prev = num[0];
        for (int i = 1; i < num.length; i++) {
            if (num[i] < prev) {
                return num[i];
            }
            prev = num[i];
        }
        // no gap
        return num[0];
    }

    public static void main(String args[]) {
        Solution s = new Solution();
        int[] arr = {4, 5, 6, 7, 0, 1, 2};
        System.out.println(s.findMin(arr));

        int[] arr2 = {9, 1, 2};
        System.out.println(s.findMin(arr2));

        int[] arr3 = {1};
        System.out.println(s.findMin(arr3));

        int[] arr4 = {1, 2, 3};
        System.out.println(s.findMin(arr4));

        int[] arr5 = {};
        System.out.println(s.findMin(arr5));
    }
}
