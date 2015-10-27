public class t8 {
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
public static void printList(ListNode head) {
  StringBuilder builder = new StringBuilder();
  while (head != null) {
    builder.append(head.data).append("-->");
    head = head.next;
  }
  builder.append("null");
  System.out.println(builder.toString());
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


public ListNode insertNode(ListNode head, int value) {
  if (head == null) {
    ListNode newHead = new ListNode(value);
    newHead.next = null;
    return newHead;
  }

  ListNode dummyHead = new ListNode(Integer.MIN_VALUE);

  dummyHead.next = head;

  ListNode current = dummyHead;

  while (current.next != null && current.next.data <= value) {
    current = current.next;

  }

  ListNode newNode = new ListNode(value);
  newNode.next = current.next;
  current.next = newNode;

  return dummyHead.next;



}



public static void main(String[] args) {
  t8 newtest = new t8();

  ListNode head = null;
   
   head = newtest.insertNode(head, 1);
   ListNode.printList(head);
  head = ListNode.arrayToList(new int[]{1,3,5,7,9});

  ListNode.printList(head);

  head = newtest.insertNode(head, 4);

  ListNode.printList(head);


  head = newtest.insertNode(head, 2);

  ListNode.printList(head);


 head = ListNode.arrayToList(new int[]{1});
 head = newtest.insertNode(head, 1);
 ListNode.printList(head);
}











}