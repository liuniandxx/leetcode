/**
 * Palindrome Linked List
 *
 * 回文字符串链表
 *
 * 判断链表元素是否是回文的(链表正序和反序是一样的)
 *
 * 举例:
 * 2 ->3 ->4 -> 5 ->3 -> 2 就不是回文
 *
 * 2 —> 3 -> 4 -> 5 —> 4 -> 3 -> 2
 *
 * 思路： 先找到链表的中点，然后逆转链表中点之后的部分
 *
 * 然后遍历逆转的部分，同时从表头遍历，直到逆序部分到达链表尾部，比较两者遍历是否相等
 * 如果相等就是回文链表，反之，不是回文链表
 *
 */
public class PalindromeList {
    public boolean isPalindrome(ListNode head) {
        if(head == null || head.next == null) {
            return true;
        }

        ListNode p = head;
        ListNode q = head;

        while(q != null) {
            p = p.next;
            q = q.next;
            if(q != null) {
                q = q.next;
            }
        }

        ListNode rp = reverseList(p);
        ListNode r = head;
        while(rp != null) {
            if(r.val != rp.val) {
                return false;
            } else {
                r = r.next;
                rp = rp.next;
            }
        }

        return true;
    }

    private ListNode reverseList(ListNode head)  {
        if(head == null || head.next == null) {
            return head;
        }
        ListNode newHead =  new ListNode(0);
        newHead.next = head;


        while (head.next != null) {
            ListNode p = head.next;
            head.next = p.next;
            //一定注意newHead的next不都是head，只有第一次是head
            p.next = newHead.next;
            newHead.next = p;
        }
        return newHead.next;
    }
}
