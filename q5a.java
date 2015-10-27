import java.util.ArrayList;
import java.util.Collections;

public class q5 {
	public boolean circle(ArrayList<String> words, int level) {
		if (level == words.size()) {
			int count = words.size();
			for (int i = 0; i < count; i++) {
				String temp1 = words.get(i);
				String temp2 = words.get(i+1);
				if (temp1.charAt(temp1.length() - 1) != temp2.charAt(0)) {
					return false;
				}
			}
		}

		for (int i = level; i < words.size(); i++) {
		
			Collections.swap(words, level, i);
			circle(words, level+1);
			Collections.swap(words, level, i);
		}


	}

	
	public static void main(String[] args) {
		q5 newq = new q5();
		ArrayList<String> words = new ArrayList<String>(4);
		words.add("aaa");
		words.add("bbb");
		words.add("baa");
		words.add("aab");
		boolean result = newq.circle(words, 0);
		System.out.println(result);

	}
}