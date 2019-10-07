package leetcode.roman_numberal;

import java.util.HashMap;
import java.util.Map;

/**
 * 将罗马数字转成阿拉伯数字.
 *
 * @author LiuYJ
 * @since 2019/9/21
 */
public class Solution {

    private static final Map<Character, Integer> RULES = new HashMap<>();

    static {
        RULES.put('I', 1);
        RULES.put('V', 5);
        RULES.put('X', 10);
        RULES.put('L', 50);
        RULES.put('C', 100);
        RULES.put('D', 500);
        RULES.put('M', 1000);
    }

    private static int convert(String romanNum) {
        char[] nums = romanNum.toCharArray();
        int res = RULES.get(nums[nums.length - 1]);
        if (nums.length == 1) {
            return res;
        }

        for (int i = nums.length - 2; i > -1; i--) {
            Integer present = RULES.get(nums[i]);
            Integer last = RULES.get(nums[i + 1]);

            if (present < last) {
                res -= present;
            } else {
                res += present;
            }
        }

        return res;
    }

    public static void main(String[] args) {
        String roman = "MCMXCIV";
        int res = convert(roman);
        System.out.println(roman +  " convert to int as: " + res);
    }
}
