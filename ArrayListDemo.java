import java.util.ArrayList;

class ArrayListDemo {

     public static void main(String[] args) {


          ArrayList<String> al = new ArrayList<String>();

          System.out.println("Initial size of al: "+al.size());

          al.add("C");
          al.add("A");
          al.add("E");
          al.add("P");
          al.add("B");
          al.add("D");
          al.add("F");
           
          System.out.println("Size of al after insertions: "+al.size());

          System.out.println("Contents of al: " + al);

          System.out.println("The third element is: " + al.get(2));

          al.set(2,"new stuff");

          System.out.println("Now the third element is: " + al.get(2));


          al.remove("F");
          al.remove(2);
          System.out.println("Size of al after deletions: " + al.size());
          System.out.println("Contents of al: "+al);

          for(String i: al)
             System.out.println("Elements in al are: "+i);
          
          boolean a = al.contains("B");

          if(a)
          System.out.println("B is still there!");

          else
          System.out.println("B is not here anymore.");

          System.out.println("The hashcode of al is: " + al.hashCode());

          //al.clear();

          boolean b = al.isEmpty();
          if(b)
          System.out.println("The Arraylist is empty!");
          else
          System.out.println("The Arraylist is not empty!");

          
           



}

}