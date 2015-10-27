import java.util.ArrayList;
import java.util.Collections;

public class s1{
	public static void main(String[] args) {
		ArrayList<String> al = new ArrayList<String>(5);
		al.add("anqi");
		al.add("shao");
		al.add("feng");
		al.add("wei");
		al.add("ning");

		Collections.swap(al, 0, 4);

		System.out.println(al.get(al.size()-1));

	}
}