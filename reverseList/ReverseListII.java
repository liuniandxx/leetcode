
/**
 * 
 * @author liunian
 * 2015/07/04
 * 链表反转
 * 
 * 一个链表,数字m, n
 * 1 ≤ m ≤ n ≤ length of list.
 * 反转链表第m到第n个的元素
 * 
 * 处理这种题目无他：仔细处理链表之间的关联关系
 */
public class ReverseListII {
	 public ListNode reverseBetween(ListNode head, int m, int n) {
		 if(m == n || head == null || head.next == null) {
			 return head;
		 }
		 
		 ListNode newHead = new ListNode(0);
		 newHead.next = head;
		 ListNode p = newHead;
		 int cnt = 1;
		 while(cnt < m) {
			 p = p.next;
			 ++cnt;
		 }
		 
		 ListNode q = p.next;
		 while(cnt < n) {
			 ListNode r = p.next;
			 p.next = q.next;
			 q.next = q.next.next;
			 p.next.next = r;
			 ++cnt;
		 }
		 return newHead.next;
	 }
}
