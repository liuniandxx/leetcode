/**
 * 
 * @author liunian
 * 
 * 思路：
 * 将当前节点的后继节点的值拷贝到当前节点，
 * 然后删除后继节点
 * 
 * (前提是后继节点不为空，即当前节点不是尾节点)
 * （当前节点为尾节点时，只能从表头开始遍历，找到倒数第二个节点，然后删除尾节点）
 * 
 */
public class DeleteNode {
	public void deleteNode(ListNode node) {
		node.val = node.next.val;
		node.next = node.next.next;
	}
}
