public class cloud13 {

	public static class ListNode {

  public int value;
  public ListNode next;

  public ListNode(int value) {
    this.value = value;
  }

  /*
   * Utility method to convert an int array to singled linked list.
   */
  public static ListNode arrayToList(int[] array) {
    if (array == null || array.length == 0) {
      return null;
    }
    ListNode head = new ListNode(array[0]);
    ListNode current = head;
    for (int index = 1; index < array.length; index++) {
      current.next = new ListNode(array[index]);
      current = current.next;
    }
    return head;
  }

  /**
   * Utility method to convert an int array to singled linked list
   * with circle.
   * 
   * Example:
   * arrayToListWithCircle(new int[] {1, 2, 3, 4, 5}, 2) will construct
   * a list with circle starting at the node of 3.
   * 
   * @param array
   *          the int array
   * @param preLength
   *          the number of nodes before entering the circle.
   * @return the head of the list
   */
  public static ListNode arrayToListWithCircle(int[] array, int preLength) {
    if (array == null || array.length == 0) {
      return null;
    }
    ListNode dummyHead = new ListNode(Integer.MIN_VALUE);
    ListNode current = dummyHead;
    ListNode circleStart = null;
    for (int index = 0; index < array.length; index++) {
      current.next = new ListNode(array[index]);
      current = current.next;
      if (index == preLength) {
        circleStart = current;
      }
    }
    current.next = circleStart;
    return dummyHead.next;
  }

  /*
   * Utility method to print out a singled linked list.
   */
  public static void printList(ListNode head) {
    StringBuilder builder = new StringBuilder();
    while (head != null) {
      builder.append(head.value).append(" -> ");
      head = head.next;
    }
    builder.append("null");
    System.out.println(builder.toString());
  }

  /*
   * Utility method to print out a node in linked list.
   */
  public static void printListNode(ListNode node) {
    if (node == null) {
      System.out.println("null");
    } else {
      System.out.println("[ " + node.value + " ]");
    }
  }
}

public int countNodeNumber(ListNode head) {
	if (head == null) {
		return 0;
	}
	ListNode temp = head;
	int count = 0;
	while (temp != null) {
		temp = temp.next;
		count++;
	}
	return count;
}

public ListNode reverse1(ListNode head) {
	if (head == null || head.next == null) {
		return head;
	}
	
	ListNode prev = null;
	ListNode current = head;
	

	while(current != null) {
		ListNode next = current.next;
		current.next = prev;
		prev = current;
		current = next;


	}

	return prev;

}

public ListNode reverse2(ListNode head) {
	if (head == null || head.next == null) {
		return head;
	}

	ListNode node1 = head;
	ListNode node2 = head.next;
	ListNode newHead = reverse2(node2);

	node2.next = head;
	node1.next = null;
	return newHead;
}




public static void main(String[] args) {
	cloud13 newcloud = new cloud13();
	ListNode l1 = null;
	l1 = ListNode.arrayToList(new int[] {1,2,3,4,5});
	ListNode.printList(l1);
	System.out.println(newcloud.countNodeNumber(l1));
	ListNode l2 = null;
	l2 = newcloud.reverse2(l1);
	ListNode.printList(l2);

}


}