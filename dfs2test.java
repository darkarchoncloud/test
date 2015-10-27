import java.util.ArrayList;

public class dfs2test {
	public void getSubset(String input, int level, StringBuilder builder, ArrayList<String> solution) {
		if (input.length() == level) {
			
			solution.add(builder.toString());
			return;

		}

		builder.append(input.charAt(level));
		getSubset(input, level+1, builder, solution);
		builder.deleteCharAt(builder.length() - 1);

		getSubset(input, level+1, builder, solution);
	}

	public void getSubset(String set, ArrayList<String> solution) {
		if (set == null) {
			return;
		}

		StringBuilder result = new StringBuilder();
		
	    getSubset(set, 0, result, solution);
	}

	public static void main(String[] args) {
		dfs2test newdfs = new dfs2test();
		String input = "abcde";
		ArrayList<String> solution = new ArrayList<String>();
		newdfs.getSubset(input, solution);
		System.out.println(solution);
	}
}