public class middlenode {
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

public ListNode middleNode(ListNode head) {
	if (head == null || head.next == null) {
		return head;
	}

	ListNode fast = head, slow = head;
	while (fast.next != null && fast.next.next != null) {
		fast = fast.next.next;
		slow = slow.next;
	}
	if (fast.next == null) {
		return slow;
	} else {

	return slow.next;
}
}

public ListNode reversell(ListNode head) {
	if (head == null || head.next == null) {
		return head;
	}

	ListNode prev = null;
	ListNode current = head;
	while (current != null) {
		ListNode nextNode = current.next;
		current.next = prev;
		prev = current;
		current = nextNode;
	}
	return prev;
}

public ListNode convert(ListNode head) {
	if (head == null || head.next == null || head.next.next == null) {
		return head;
	}

	ListNode middle = middleNode(head);
	ListNode reverseHalf = reversell(middle);
	ListNode dummyHead = new ListNode(0);
	ListNode current = dummyHead;
	ListNode p1 = head;
	ListNode p2 = reverseHalf;
	while (p1 != null && p2 != null) {
		current.next = p1;
		p1 = p1.next;
		current = current.next;
		current.next = p2;
		p2 = p2.next;
		current =  current.next;

	}
	current.next = null;

	return dummyHead.next;




}

public ListNode partition(ListNode head, int target) {
	if (head == null || head.next == null) {
		return head;
	}

	
}

public static void main(String[] args) {
	middlenode dark = new middlenode();
	ListNode head = ListNode.arrayToList(new int[] {1,2,3,4,5,6,7,8,9});
	ListNode middle = dark.middleNode(head);
	ListNode.printListNode(middle);
	ListNode convertHead = dark.convert(head);
	ListNode.printList(convertHead);
}
}