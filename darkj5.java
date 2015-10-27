import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;




class darkj5 {


public static void main(String args[]) throws FileNotFoundException {

Scanner in = new Scanner(new File("scannertest.txt"));


while(in.hasNextLine())
{

System.out.println(in.nextLine());

}

}
}