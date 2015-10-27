public class q1 {


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


public ListNode middlePoint(ListNode head) {
	if (head == null || head.next == null) {
		return head;
	}


	ListNode fast = head;
	ListNode slow = head;
	while (fast.next != null && fast.next.next != null) {
		slow = slow.next;
		fast = fast.next.next;
		
		
		

	}

	return slow;
}






public boolean isPalindrome(ListNode head) {
	if (head == null || head.next == null) {
		return true;
	}
	ListNode fast = head;
	ListNode slow = head;
	while (fast.next != null && fast.next.next != null) {
		fast = fast.next.next;
		slow = slow.next;

	}

	// System.out.println(slow.value);

	ListNode mideleNode = slow;
	ListNode secondHalf = slow.next;

	ListNode reverseHead = reverse(secondHalf);

	ListNode temp1 = head;
	ListNode temp2 = reverseHead;

	while (temp2.next != null) {
		if (temp1.value != temp2.value) {
			return false;
		}
		temp1 = temp1.next;
		temp2 = temp2.next;

	}

	ListNode recoverHead = reverse(reverseHead);
	temp1.next = recoverHead;
	return true;


}

public ListNode reverse(ListNode head) {
      if (head == null || head.next == null) {
      	return head;
      }

      ListNode prev = null;
      ListNode current = head;
      while (current != null) {
      	ListNode next = current.next;
      	current.next = prev;
      	prev = current;
      	current = next;
      }

      return prev;
}


public static void main(String[] args) {
	q1 newq = new q1();
	ListNode head = ListNode.arrayToList(new int[] {1,2,5,6,5,2});
   


	ListNode.printList(head);

	ListNode r1head = newq.reverse(head);

	ListNode.printList(r1head);

	ListNode r2head = newq.reverse(r1head);

	ListNode.printList(r2head);





 //    ListNode middle = newq.middlePoint(head);

 //    System.out.println(middle.value);



	// boolean result = newq.isPalindrome(head);

	// System.out.println(result);

	// ListNode.printList(head);
}


}

