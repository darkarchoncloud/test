public class cyclelist {
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
	public boolean hasCycle(ListNode head) {
		if (head == null || head.next == null) {
			return false;
		}

		ListNode slow = head, fast = head;
		while (fast.next != null && fast.next.next != null) {
			fast = fast.next.next;
			slow = slow.next;
			if (slow == fast) {
				return true;
			}
		}
		return false;

	}

	public ListNode findCycle(ListNode head) {
		if (!hasCycle(head)) {
			return null;
		}
		ListNode slow = head, fast = head;
		while (fast.next != null && fast.next.next != null) {
			fast = fast.next.next;
			slow = slow.next;
			if (slow == fast) {
				break;
			}
		}
		slow = head;
		while (slow != fast) {
			slow = slow.next;
			fast = fast.next;
		}

		return slow;
	}



	public static void main(String[] args) {
		cyclelist dark = new cyclelist();
		ListNode head = ListNode.arrayToListWithCircle(new int[] {1,2,3,4,32,6,7,8}, 4);
		ListNode head1 = ListNode.arrayToList(new int[] {1,2,3,4,5});
		boolean result = dark.hasCycle(head);
		System.out.println(result);
		boolean result1 = dark.hasCycle(head1);
		System.out.println(result1);

		ListNode cycle = dark.findCycle(head);
		System.out.println(cycle.value);
		ListNode cycle1 = dark.findCycle(head1);
		if (cycle1 == null) {
			System.out.println("There is no cycle!");
		}
	}
}