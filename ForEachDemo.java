import java.util.*;

class ForEachDemo {

public static void main(String[] args) {

ArrayList<String> al = new ArrayList<String>();

al.add("A");
al.add("C");
al.add("F");
al.add("X");
al.add("B");
al.add("G");
al.add("V");


for(String temp: al)
{

temp += "+";
System.out.println(temp);


}

for(String temp: al)
{
System.out.println(temp);
}
}
}