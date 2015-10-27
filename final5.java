import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;

public class final5 {
public static class ListNode {

  public int value;
  public ListNode next;

  public ListNode(int value) {
    this.value = value;
    this.next = null;
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


public static Comparator<ListNode> maxcomparator = new Comparator<ListNode>() {
	public int compare(ListNode n1, ListNode n2) {
		if (n1.value > n2.value) {
			return 1;
		} else if (n1.value < n2.value) {
			return -1;
		} else {
			return 0;
		}

	}
};
public ListNode mergeKLists(ArrayList<ListNode> lists) {
	if (lists.size() == 0) {
		return null;
	}

	PriorityQueue<ListNode> minHeap = new PriorityQueue<>(lists.size(), maxcomparator);
    for (ListNode temp : lists) {
    	if (temp != null) {
    		minHeap.offer(temp);
    	}
    }
    ListNode dummyHead = new ListNode(0);
    ListNode current = dummyHead;

    while (minHeap.size() > 0) {
    	ListNode tmp = minHeap.poll();
    	current.next = tmp;
    	if (tmp.next != null) {
    		minHeap.offer(tmp.next);
    	}
    	current = current.next;
    }

    return dummyHead.next;
}

public static void main(String[] args) {
	final5 newfinal = new final5();
	ArrayList<ListNode> lists = new ArrayList<ListNode>();
	ListNode list1 = ListNode.arrayToList(new int[] {1,4,5,7,9,23});
	ListNode list2 = ListNode.arrayToList(new int[] {2,8,21,45});
	ListNode list3 = ListNode.arrayToList(new int[] { 3,6,10,17,20});

	lists.add(list1);
	lists.add(list2);
	lists.add(list3);

	ListNode newHead = newfinal.mergeKLists(lists);
	ListNode.printList(newHead);

}

}
