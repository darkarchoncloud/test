public class t6 {
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
}
   





	public ListNode middleNode(ListNode head) {
		if (head == null || head.next == null) {
			return head;
		}

		ListNode fast = head;
		ListNode slow = head;
		while (fast.next != null && fast.next.next != null) {
			fast = fast.next.next;
			slow = slow.next;
		}

		return slow;




	}


	public static void main(String[] args) {

		t6 newtest =  new t6();
		ListNode head = null;

		head = ListNode.arrayToList(new int[]{1,2,3,4,5});
		ListNode.printList(head);
		ListNode middle = newtest.middleNode(head);
		System.out.println(middle.data);
		head = ListNode.arrayToList(new int[]{1,2,4,5});
		middle = newtest.middleNode(head);
		System.out.println(middle.data);
		head = ListNode.arrayToList(new int[]{1,4,5});
		middle = newtest.middleNode(head);
		System.out.println(middle.data);
		head = ListNode.arrayToList(new int[]{1,5});
		middle = newtest.middleNode(head);
		System.out.println(middle.data);
		head = ListNode.arrayToList(new int[]{1});
		middle = newtest.middleNode(head);
		System.out.println(middle.data);
		
	}
}