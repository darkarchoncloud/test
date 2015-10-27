class t1 {
	public Node reverseBinaryTree(Node head) {
		if (head == null || head.left == null) {
			return head;
		}
		if (head.left != null && head.left.left == null && head.left.right == null) {
			Node node1 = head;
			Node node2 = head.left;
			Node node3 = head.right;
			node2.left = node3;
			node2.right = node1;
			return node2;
		}

        Node node1 = head;
        Node node2 = head.left;
        Node node3 = head.right;
		Node newRoot = reverseBinaryTree(head.left);
		node2.left = node3;
		node2.right = node1;
		node1.left = null;
		node1.right = null;
		return newRoot;

	}
}