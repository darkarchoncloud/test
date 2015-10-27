import java.util.ArrayList;

class darkj2 {

public static void main(String args[]) {

ArrayList<String> dark1 = new ArrayList<String>(10);


dark1.add("Anqi Shao");
dark1.add("Ning Guo");
dark1.add("Wei Feng");
dark1.add("Kitty Gray");


for(int i = 0; i < dark1.size(); i++)
{

System.out.println(dark1.get(i));

}

System.out.println();

for(String temp : dark1)

System.out.println(temp);

}


}