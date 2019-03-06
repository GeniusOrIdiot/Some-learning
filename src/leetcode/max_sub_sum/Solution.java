package leetcode.max_sub_sum;

/**
 * 最大子序列问题.
 */
public class Solution {

    public static void main(String[] args) {
        int[] a = new int[]{-2, 3, 4, -2, 8, -3, -9, 3, -6, 5, 7};

        System.out.println("Max sub sum : " + maxSumRec(a, 0, a.length - 1));

        System.out.println("Max sub sum : " + maxSubSumO(a));
    }

    /**
     * 递归实现.
     */
    private static int maxSumRec(int[] a, int left, int right) {
        if (left == right) {
            if (a[left] > 0) {
                return a[left];
            }
            return 0;
        }

        int center = (left + right) / 2;
        int maxLeftSum = maxSumRec(a, left, center);
        int maxRightSum = maxSumRec(a, center + 1, right);

        int maxLeftBorderSum = 0, leftBorderSum = 0;
        for (int i = center; i >= left; i--) {
            leftBorderSum += a[i];
            if (maxLeftBorderSum < leftBorderSum) {
                maxLeftBorderSum = leftBorderSum;
            }
        }

        int maxRightBorderSum = 0, rightBorderSum = 0;
        for (int i = center + 1; i <= right; i++) {
            rightBorderSum += a[i];
            if (rightBorderSum > maxRightBorderSum) {
                maxRightBorderSum = rightBorderSum;
            }
        }

        return max(maxLeftSum, maxRightSum, maxLeftBorderSum + maxRightBorderSum);
    }

    /**
     * O(N)解法.
     */
    private static int maxSubSumO(int[] a) {
        /*
        对这个方法的说明：
        - thisSum 记录了当前的累加值
        - maxSum 记录了 thisSum 累加过程中的最大值
        - 一旦 thisSum 经历了 maxSum 之后开始变小（加了负数）
        - 但是依然比 0 大的话，我们仍然可以相信 这次累加的结果之后还有机会出现新的最大值
            > 比如：之前加了 -2，本次加了3，累计值还是上升了1，出现了新的 maxSum
        - 如果 thisSum < 0 了，再继续累加，只会导致之后的累加结果始终会因为这次的负数的 thisSum 而错失较大的值
        - 所以 令累计值 thisSum = 0，重新开始累积是合理的
        */
        int maxSum = 0, thisSum = 0;

        for (int i : a) {
            thisSum += i;

            // 对 a 累加，择优替换.
            if (thisSum > maxSum) {
                maxSum = thisSum;
            } else if (thisSum < 0) {
                // 低于 0 则重置.
                thisSum = 0;
            }
        }

        return maxSum;
    }

    private static int max(int a, int b, int c) {
        if (a > b && a > c) {
            return a;
        }

        if (b > c) {
            return b;
        }

        return c;
    }
}
