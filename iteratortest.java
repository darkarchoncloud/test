import java.util.*;

public class iteratortest {

public static void main(String[] args) {

Collection books = new HashSet();

books.add("becker 1");

books.add("becker 2");

books.add("becker 3");

Iterator it = books.iterator();

while(it.hasNext())

{

String book = (String)it.next();
System.out.println(book);
}
}
}
