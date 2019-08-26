package leetcode.add_two_num;

/**
 * 给出两个 非空 的链表用来表示两个非负的整数。其中，它们各自的位数是按照 逆序 的方式存储的，并且它们的每个节点只能存储 一位 数字。
 * <p>
 * 如果，我们将这两个数相加起来，则会返回一个新的链表来表示它们的和。
 * <p>
 * 您可以假设除了数字 0 之外，这两个数都不会以 0 开头。
 * <p>
 * 示例：
 * <p>
 * 输入：(2 -> 4 -> 3) + (5 -> 6 -> 4)
 * 输出：7 -> 0 -> 8
 * 原因：342 + 465 = 807
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/add-two-numbers
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Solution {
    private ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int num;
        int advance = 0;
        ListNode l3 = null;
        ListNode last = null;
        while (l1 != null || l2 != null) {
            int v1 = l1 == null ? 0 : l1.val;
            int v2 = l2 == null ? 0 : l2.val;
            int sum = v1 + v2 + advance;
            l1 = l1 == null ? null : l1.next;
            l2 = l2 == null ? null : l2.next;
            num = sum > 9 ? sum - 10 : sum;
            advance = sum > 9 ? 1 : 0;
            final ListNode l = last;
            final ListNode newNode = new ListNode(num);
            if (l == null) {
                l3 = newNode;
            } else {
                l.next = newNode;
            }
            last = newNode;
        }
        if (advance == 1) {
            last.next = new ListNode(1);
        }
        return l3;
    }

    public static void main(String[] args) {
        ListNode l1 = new ListNode(3);
        l1.next = new ListNode(4);
        l1.next.next = new ListNode(2);
        ListNode l2 = new ListNode(4);
        l2.next = new ListNode(6);
        ListNode l3 = new Solution().addTwoNumbers(l1, l2);
        System.out.println(l1 + "\n" + l2 + "\n" + l3);
    }

    static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }

        @Override
        public String toString() {
            StringBuilder s = new StringBuilder(val + "");

            while (next != null) {
                s.append("-").append(next.val);
                next = next.next;
            }

            return s.toString();
        }
    }
}
