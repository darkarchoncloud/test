import java.util.*;

public class collectiontest {

public static void main(String args[])  {

Collection c = new ArrayList();

c.add("sunwukong");

c.add(6);

System.out.println("the size of collection c is: "+c.size());

c.remove(6);


System.out.println("the size of collection c is: "+c.size());

System.out.println("The collection c contains the element sunwukong: " + 
            c.contains("sunwukong"));

c.add("becker is my favourite show");

System.out.println("elements in c: " + c);

}
}

