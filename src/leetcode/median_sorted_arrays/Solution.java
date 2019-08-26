package leetcode.median_sorted_arrays;

/**
 * 给定两个大小为 m 和 n 的有序数组 nums1 和 nums2。
 * <p>
 * 请你找出这两个有序数组的中位数，并且要求算法的时间复杂度为 O(log(m + n))。
 * <p>
 * 你可以假设 nums1 和 nums2 不会同时为空。
 * <p>
 * 示例 1:
 * <p>
 * nums1 = [1, 3]
 * nums2 = [2]
 * <p>
 * 则中位数是 2.0
 * 示例 2:
 * <p>
 * nums1 = [1, 2]
 * nums2 = [3, 4]
 * <p>
 * 则中位数是 (2 + 3)/2 = 2.5
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/median-of-two-sorted-arrays
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author LiuYJ
 * @since 2019/7/18
 */
public class Solution {

    private static double findMedianSortedArrays(int[] a_arr, int[] b_arr) {
        int m = a_arr.length;
        int n = b_arr.length;
        int[] c_arr = new int[m + n];

        int i = 0, j = 0, k = 0;

        while (i < m && j < n) {
            if (a_arr[i] <= b_arr[j]) {
                c_arr[k++] = a_arr[i++];
            } else {
                c_arr[k++] = b_arr[j++];
            }
        }

        if (i == m) {
            while (j < n)
                c_arr[k++] = b_arr[j++];
        } else {
            while (i < m)
                c_arr[k++] = a_arr[i++];
        }

        if ((m + n) % 2 == 0) {
            return ((double) c_arr[(m + n) / 2 - 1] + c_arr[(m + n) / 2]) / 2;
        } else {
            return c_arr[(m + n) / 2];
        }
    }


    public static void main(String[] args) {
        int[] a = new int[]{1, 8};
        int[] b = new int[]{4, 5};

        System.out.println(findMedianSortedArrays(a, b));
    }
}
