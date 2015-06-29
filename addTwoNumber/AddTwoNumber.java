/**
 * Author: LiuNian
 * Date: 2015/06/29
 *
 * 使用链表表示非负整数
 * 比如: 链表 2 -> 4 -> 3 表示整数 342
 * 同理：链表  6 -> 8 -> 7 表示正是 786
 *
 *  现在给定两个链表，求其表示的两个整数的和的链表表示
 *
 *  思路：从给定链表表头开始，按照加法的运算规则，一位一位的计算。
 *  (不要忘记运算结束后要处理进位)
 */
public class AddTwoNumber {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
       ListNode res = new ListNode(0);

       int up = 0; //表示进位
       ListNode p = res;

       while (l1 != null && l2 != null) {
           int cur = (l1.val + l2.val + up) % 10;
           up = (l1.val + l2.val + up) / 10;
           p.next = new ListNode(cur);
           p = p.next;
           l1 = l1.next;
           l2 = l2.next;
       }

       while (l1 != null) {
           int cur = (l1.val + up) % 10;
           up = (l1.val + up) / 10;
           p.next = new ListNode(cur);
           p = p.next;
           l1 = l1.next;
       }

        while (l2 != null) {
            int cur = (l2.val + up) % 10;
            up = (l2.val + up) / 10;
            p.next = new ListNode(cur);
            p = p.next;
            l2 = l2.next;
        }

        /**
         * 注意不要忘记处理最后的进位up
         */
        if(up != 0) {
            p.next = new ListNode(up);
        }

        return res.next;
    }
}
