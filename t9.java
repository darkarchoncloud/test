public class t9 {
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


public ListNode merge(ListNode headone, ListNode headtwo) {
	if (headone == null && headtwo == null) {
		return null;
	} else if (headone == null) {
		return headtwo;
	} else if (headtwo == null) {
		return headone;
	} else {
		ListNode dummyHead = new ListNode(Integer.MIN_VALUE);
		ListNode current = dummyHead;

		ListNode h1 = headone;
		ListNode h2 = headtwo;

		while (h1 != null && h2 != null) {
			if (h1.data <= h2.data) {
				ListNode nextNode = new ListNode(h1.data);
				current.next = nextNode;
				current = current.next;
				h1 =  h1.next;

			}

			if (h1.data >= h2.data) {
				ListNode nextNode = new ListNode(h2.data);
				current.next = nextNode;
				current = current.next;
				h2 = h2.next;
			}
		}

		while (h1 != null) {
			ListNode nextNode = new ListNode(h1.data);
			current.next = nextNode;
			current = current.next;
			h1 = h1.next;
		}

		while (h2 != null) {
			ListNode nextNode = new ListNode(h2.data);
			current.next = nextNode;
			current = current.next;
			h2 = h2.next;
		}
		current.next = null;
        return dummyHead.next;

	}
	
}

public static void main(String[] args) {
	t9 newtest = new t9();
	ListNode head1 = null;
	ListNode head2 = null;

	ListNode head = null;

	head1 = ListNode.arrayToList(new int[] {1,4,6});
	head2 = ListNode.arrayToList(new int[] {2,5});

	ListNode.printList(head1);
	ListNode.printList(head2);

	head = newtest.merge(head1, head2);

	ListNode.printList(head);
}

}

