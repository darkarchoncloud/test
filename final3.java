
import java.util.Deque;
import java.util.LinkedList;

public class final3 {
	public String shiftLetter(String input, int k) {
		if (input == null || input.length() == 0 || k == 0) {
			return input;
		}

		int len = input.length();

		char[] tail = input.substring(len - k).toCharArray();
		char[] head = input.substring(0, len - k).toCharArray();

		StringBuilder sb = new StringBuilder();
		Deque<Character> tailqueue = new LinkedList<Character>();
		Deque<Character> headqueue = new LinkedList<Character>();

		for (int i = 0; i < tail.length; i++) {
			tailqueue.offerLast(tail[i]);
		}

		for (int j = 0 ; j < head.length; j++) {
			headqueue.offerLast(head[j]);
		}

		while (!tailqueue.isEmpty()) {
			sb.append(tailqueue.pollFirst());
		}

		while (!headqueue.isEmpty()) {
			sb.append(headqueue.pollFirst());
		}

		return sb.toString();

		




	}

	public static void main(String[] args) {
		final3 newfinal = new final3();
		String input = "ABCDEF";
		int k = 4;
		String output = newfinal.shiftLetter(input, k);
		System.out.println(output);
	}
}