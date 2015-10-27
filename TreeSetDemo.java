import java.util.*;

class TreeSetDemo {


    public static void main(String[] args) {


     TreeSet<String> hs = new TreeSet<String>();

     hs.add("B");
     hs.add("A");
     hs.add("D");
     hs.add("E");
     hs.add("C");
     hs.add("F");

     System.out.println(hs);

     System.out.println(hs.subSet("B","E"));

}
}