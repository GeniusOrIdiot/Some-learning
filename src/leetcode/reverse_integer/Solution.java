package leetcode.reverse_integer;

public class Solution {

    private static int reverse(int x) {

        boolean neg = false;
        long x_ = x;

        if (x_ < 0) {
            neg = true;
            x_ = -x_;
        }

        long res = 0;
        do {
            res *= 10;
            res += x_ % 10;
            if (res > Integer.MAX_VALUE) return 0;
            x_ = x_ / 10;
        } while (x_ > 0);

        return (int) (neg ? -res : res);
    }

    public static void main(String[] args) {
        System.out.println(reverse(12345));
    }
}
