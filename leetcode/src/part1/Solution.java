package part1;

import java.util.*;
import java.util.stream.Collectors;

/**
 * 力扣习题
 */
public class Solution {
    public static void main(String[] args) {
        Integer[] arr = {2,3,4,4};
        Integer integer1 = method3(arr, 4);
    }

    /**
     * 给定一个整数数组 nums 和一个整数目标值 target，请你在该数组中找出 和为目标值 target  的那 两个 整数，并返回它们的数组下标。
     * 你可以假设每种输入只会对应一个答案。但是，数组中同一个元素在答案里不能重复出现。
     * 你可以按任意顺序返回答案。
     * 输入：nums = [3,3], target = 6
     * 输出：[0,1]
     * @param nums
     * @param target
     * @return
     */
    public static List<Integer> twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> map = new HashMap();
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], i);
        }
        return map.entrySet().stream()
                .filter(m -> map.entrySet()
                        .stream()
                        .anyMatch(a -> Objects.equals(target - m.getKey(), a.getKey()))).map(a -> a.getValue()).collect(Collectors.toList());
    }

    public static String method1(String str) {
        TreeMap<Character, Integer> map = new TreeMap<>();
        char[] chars = str.toCharArray();
        for (char c : chars) {
            map.put(c, Objects.isNull(map.get(c)) ? 1 : map.get(c) + 1);
        }
        return map.entrySet().stream().map(e -> e.getKey() + "" + e.getValue()).collect(Collectors.joining());
    }

    public static Integer method2(Integer max) {
        Integer result = 0;
        for (int i = 1; i <= max; i++) {
            result += i;
        }
        return result;
    }

    public static Integer method3(Integer[] arr, Integer key) {
        TreeMap<Integer, Integer> map = new TreeMap<>();
        for (int i = 0; i < arr.length; i++) {
            if (i==0) {
                map.put(arr[i], i);
            } else if (arr[i] != arr[i-1]) {
                map.put(arr[i], i);
            }
        }
        return map.get(key);
    }
}
