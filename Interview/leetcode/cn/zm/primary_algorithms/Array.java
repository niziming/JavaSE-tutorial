package cn.zm.primary_algorithms;

public class Array {

    /**
     * 删除排序数组中的重复项
     * https://leetcode.cn/leetbook/read/top-interview-questions-easy/x2gy9m/
     * @param nums
     * @return
     */
    public static int removeDuplicates(int[] nums) {
        if (nums == null || nums.length == 0) return -1;
        int left = 0;
        for (int right = 1; right < nums.length; right++)
            if (nums[left] != nums[right])
                nums[++left] = nums[right];
        return ++left;
    }
    /**
     * 买卖股票的最佳时机 II
     * https://leetcode.cn/leetbook/read/top-interview-questions-easy/x2zsx1/
     * @param prices
     * @return
     */
    public static int maxProfit(int[] prices) {
        return 0;
    }
    /**
     * 买卖股票的最佳时机 II
     * https://leetcode.cn/leetbook/read/top-interview-questions-easy/x2zsx1/
     * @param prices
     * @return
     */
    public static int method(int[] prices) {
        return 0;
    }
    public static void main(String[] args) {
    }

}
