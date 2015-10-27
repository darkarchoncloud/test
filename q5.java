import java.util.ArrayList;
import java.util.Collections;

public class q5 {
	public boolean circle(ArrayList<String> words, int level) {
		if (level == words.size()) {
			String str1 = words.get(0);
			String str2 = words.get(words.size() - 1);
			return str1.charAt(0) ==  str2.charAt(str2.length() - 1);
		}

		for (int i = level; i < words.size(); i++) {
			if (temp1.charAt(temp1.length() - 1) == temp2.charAt(0)) {
				circle(words, level + 1);
			}
			Collections.swap(words, level, i);
			String temp1 = words.get(level);
			String temp2 = words.get(level + 1);
			
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