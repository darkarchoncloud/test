public class cloud1 {
	public void printCombo(String input) {
		if (input == null) {
			return;
		}
		StringBuilder sb = new StringBuilder();
		printCombo(input, 0, sb);
	}

	public void printCombo(String input, int level, StringBuilder sb) {
		if (level == input.length()) {
			System.out.println(sb.toString());
			return;
		} else {
			printCombo(input, level+1, sb);
			sb.append(input.charAt(level));
			printCombo(input, level+1, sb);
			sb.setLength(sb.length()-1);
			// sb.deleteCharAt(sb.length()-1);
		}


	}

	public static void main(String[] args) {
		cloud1 newcloud = new cloud1();
		String input = "abc";
		newcloud.printCombo(input);
	}
}