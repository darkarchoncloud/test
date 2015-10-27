import java.util.HashSet;

public class uniquechar {
	public boolean allUnique1(String input) {
		if (input == null || input.length() == 0) {
			return true;
		}
		HashSet<Character> set = new HashSet<Character>();
		for (int i = 0; i < input.length(); i++) {
			if (set.contains(input.charAt(i))) {
				return false;
			} else {
				set.add(input.charAt(i));
			}
		}
		
		return true;




	}

	public static void main(String[] args) {
		uniquechar dark = new uniquechar();
		String word = "anqishao";
		System.out.println(dark.allUnique1(word));
	}
}