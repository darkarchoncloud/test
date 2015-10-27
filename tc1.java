import java.util.Deque;
import java.util.LinkedList;

public class tc1 {
	public static void main(String[] args) {
		String s1 = "ABCDEBF";
		System.out.println(s1.length());
		System.out.println(s1.charAt(4));
		System.out.println(s1.indexOf("B"));
		System.out.println(s1.substring(0,2));
		System.out.println(s1.lastIndexOf("B"));
		System.out.println(s1.toUpperCase());
		System.out.println(s1.toLowerCase());
		System.out.println(s1.contains("B"));
		System.out.println(s1.concat("GP"));
		System.out.println(s1.startsWith("A"));
		System.out.println(s1.endsWith("P"));
		System.out.println(s1.isEmpty());
		char[] s2 = s1.toCharArray();
		Deque<Character> qc = new LinkedList<>();
		for (int i = 0; i < s2.length; i++) {
			qc.offerFirst(s2[i]);
		}

		while (!qc.isEmpty()) {
			System.out.println(qc.pollFirst());

		}


	}
}