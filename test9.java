public ListNode reversePair(ListNode head) {
	if (head == null || head.next == null) {
		return head;
	} else if (head.next != null && head.next.next == null) {
        head.next.next = head;
		return head.next;
	}
	ListNode node1 = head;
	ListNode node2 = head.next;
	ListNode newHead = node2;
	listNode nodeN = reversePair(newHead.next);

	newHead.next = node1;
	node1.next = nodeN;

	return newhead;


}