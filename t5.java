public class t5 {
   public static class ListNode {
   	public int data;
   	public ListNode next;
   	public ListNode(int value) {
   		this.data = value;
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
   

   public ListNode reverseRecursive(ListNode head) {
   	   if (head == null || head.next == null) {
   	   	return head;
   	   }

   	   ListNode n2 = head.next;
   	   ListNode n1 = head;
   	   ListNode newHead = reverseRecursive(n2);
   	   n2.next = n1;
   	   n1.next = null;
   	   return newHead;

   }

   public static void main(String[] args) {
   	t5 newtest = new t5();
   	
   	ListNode head = ListNode.arrayToList(new int[] {1,2,3,4,5});
   	
   	ListNode.printList(head);

   	System.out.println("After reverse: ");

   	ListNode newHead = newtest.reverseRecursive(head);

   	ListNode.printList(newHead);
    

   }

}