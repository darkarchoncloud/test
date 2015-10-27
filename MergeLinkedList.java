class MergeLinkedList {

public static class Node {

    int info;
    Node next;
      
    Node(int x) {
         info = x;
         next = null;
}
    Node() { }

}







public static Node mergesort(Node head) {

if (head == null || head.next == null) { return head; }
Node middle = getMiddle(head);           //get the middle of the list
Node sHalf = middle.next; middle.next=null;     //split the list into two halfs

return combine(mergesort(head), mergesort(sHalf));   //recurse on that
}




public static Node combine(Node a, Node b) {

Node dummyHead, curr;
dummyHead = new Node(); curr = dummyHead;
while(a != null && b != null) {

     if(a.info <= b.info) { curr.next = a; a = a.next; }
     else { curr.next = b; b = b.next; }
     curr = curr.next;

}

curr.next = (a == null) ? b : a;
return dummyHead.next;

}


public static Node getMiddle(Node head) {  //get middle Node经典方法，快慢指针


if (head == null) { return head; }

Node slow, fast; slow = fast = head;
while (fast.next != null && fast.next.next != null) {
      slow = slow.next; fast = fast.next.next;
}

return slow;

}


public static void printList(Node x) {

if (x != null) {

       System.out.print(x.info + " ");
       while (x.next != null) {
               System.out.print(x.next.info + " ");
               x = x.next;
}

System.out.println();

}
}
public static void main(String[] args) {

Node n1 = new Node(2);
Node n2 = new Node(3);
Node n3 = new Node(4);
Node n4 = new Node(-3);
Node n5 = new Node(40);
Node n6 = new Node(1);

n1.next = n2;
n2.next = n3;
n3.next = n4;
n4.next = n5;
n5.next = n6;

Node result = new Node(0);
System.out.println("The original list is: ");
printList(n1);

result = mergesort(n1);
System.out.println("After merge sort, the list is: ");
printList(result);



}         




}



















