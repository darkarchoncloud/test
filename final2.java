
public class final2 {

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

  public static boolean isEqual(ListNode head1, ListNode head2) {
    if (head1 == null && head2 == null) {
      return true;
    } else if (head1 == null || head2 == null) {
      return false;
    } else {
      ListNode temp1 = head1;
      ListNode temp2 = head2;
      while (temp1 != null && temp2 != null) {
        if (temp1.value != temp2.value) {
          return false;
        }
        temp1 = temp1.next;
        temp2 = temp2.next;
      }
      return true;
    }
  }

  public static ListNode deepCopy(ListNode head) {
    if (head == null) {
      return head;
    }
    ListNode newHead = new ListNode(head.value);
    ListNode fakeHead = deepCopy(head.next);
    newHead.next = fakeHead;
    return newHead;


  }

}

public ListNode reverse(ListNode head) {
  if (head == null || head.next == null) {
    return head;
  }

  ListNode prev = null;
  ListNode curr = head;
  while (curr != null) {
    ListNode next = curr.next;
    curr.next = prev;
    prev = curr;
    curr = next;
  }
  return prev;
}

public boolean isPalindrome(ListNode head) {
  if (head == null || head.next == null) {
    return true;
  }
  ListNode newhead = ListNode.deepCopy(head);
  ListNode reverseHead = reverse(head);
  
  
  return ListNode.isEqual(newhead, reverseHead);
}


public static void main(String[] args) {
  final2 newfinal = new final2();
  ListNode head = ListNode.arrayToList(new int[] {1,2,3,2,1});
  head = ListNode.arrayToList(new int[] {1,2,1});
  head = null;


  System.out.println(newfinal.isPalindrome(head));

  
  
}
}