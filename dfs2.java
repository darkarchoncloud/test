public class dfs2 {
	public void printSubset(String input, int level, StringBuilder builder) {
		if (input.length() == level) {
			System.out.println(builder);
			return;

		}

		builder.append(input.charAt(level));
		printSubset(input, level+1, builder);
		builder.deleteCharAt(builder.length() - 1);

		printSubset(input, level+1, builder);
	}

	public void printSubset(String set) {
		if (set == null) {
			return;
		}

		StringBuilder result = new StringBuilder();
		printSubset(set, 0, result);
	}

	public static void main(String[] args) {
		dfs2 newdfs = new dfs2();
		String input = "abcd";
		newdfs.printSubset(input);
	}
}