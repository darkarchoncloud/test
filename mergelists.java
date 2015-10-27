public class mergelists {
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

public ListNode mergeLists(ListNode head1, ListNode head2) {
	if (head1 ==  null && head2 == null) {
		return null;
	} else if (head1 == null || head2 == null) {
		if (head1 == null) {
			return head2;
		}
		if (head2 == null) {
			return head1;
		}
	} 
		ListNode newHead = new ListNode(0);
		ListNode current = newHead;
		ListNode p1 = head1;
		ListNode p2 = head2;
		while (p1 != null && p2 != null) {
			if (p1.value <= p2.value) {
				current.next = p1;
				p1 = p1.next;
				current = current.next;
			} else {
				current.next = p2;
				p2 = p2.next;
				current = current.next;
			}
		}

		while (p1 != null) {
			current.next = p1;
			p1 = p1.next;
			current = current.next;
		}

		while (p2 != null) {
			current.next = p2;
			p2 = p2.next;
			current = current.next;
		}
		current.next = null;
		return newHead.next;
	
	
	
}


public static void main(String[] args) {
	mergelists dark = new mergelists();
	ListNode head1 = null;
	ListNode head2 = null;
	head1 = ListNode.arrayToList(new int[] {1,3,5,7,9});
	ListNode.printList(head1);
	head2 = ListNode.arrayToList(new int[] {2,4,6,8,10});
	ListNode.printList(head2);
    ListNode head3 = null;
    head3 = dark.mergeLists(head1, head2);
    
    
    ListNode.printList(head3);


}
}