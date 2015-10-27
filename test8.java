public class test8 {

	public class ListNode {
		int data;
		ListNode next;
		ListNode(int value) {
			this.data = value;
		}
	}
	public void reverseLinkedList(ListNode head) {

		if (head == null || head.next == null) {
			return head;
		}

		ListNode node1 = head;
		ListNode node2 = head.next;

		listNode nodeN = reverseLinkedList(node2);
		node2.next = node1;
		node1.next = null;
		return nodeN;


	}
}