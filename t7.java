public class t7 {
public static class ListNode {
   	public int data;
   	public ListNode next;
   	public ListNode(int value) {
   		this.data = value;
   		next = null;
   	}
   

    //utility function, used to transfer an array into an LinkedList
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

public  static void printListNode(ListNode node) {
	if (node == null) {
		System.out.println("null");
	} else {
		System.out.println("[ " + node.data + " ]");
	}
}

public static ListNode arrayToListWithCircle(int[] array, int preLength) {
  if (array == null || array.length == 0) {
    return null;
  }

  ListNode dummyHead = new ListNode(Integer.MIN_VALUE);
  ListNode current = dummyHead;
  ListNode circleStart = null;

  for (int i = 0; i < array.length; i++) {
    current.next = new ListNode(array[i]);
    current = current.next;
    //preLength is the index where the circle starts
    //Here use circleStart to mark where the circle starts
    //after the current hit the last element,
    //point back to circleStart to make a circle
    if (i == preLength) {
      circleStart = current;
    }


  }

  current.next = circleStart;
  return dummyHead.next;
}

}

public boolean hasCycle(ListNode head) {
  if (head == null || head.next == null) {
    return false;
  }

  ListNode slow = head;
  ListNode fast = head;

  while (fast.next != null && fast.next.next != null) {
    fast = fast.next.next;
    slow = slow.next;
    if (slow == fast) {
      return true;
    }
  }
  return false;
}


public static void main(String[] args) {

  t7 newtest = new t7();
  ListNode head = null;
  head = ListNode.arrayToList(new int[]{1,2,3,4,5});
  System.out.println(newtest.hasCycle(head));

  head = ListNode.arrayToListWithCircle(new int[]{1,2,3,4,5}, 3);

  System.out.println(newtest.hasCycle(head));
}

}
