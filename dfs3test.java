import java.util.ArrayList;

public class dfs3test {
	public void printParenthesis(int k, int left, int right, StringBuilder builder, ArrayList<String> solution) {
		if (left + right == 2 * k) {
			solution.add(builder.toString());
			return;
		}

		if (left < k) {
			builder.append("(");
			printParenthesis(k, left + 1, right, builder, solution);
			builder.deleteCharAt(builder.length() - 1);
		}

		if (right < left) {
			builder.append(")");
			printParenthesis(k, left, right + 1, builder, solution);
			builder.deleteCharAt(builder.length() - 1);
		}
	}

	public static void main(String[] args) {
		dfs3test newdfs = new dfs3test();
		StringBuilder builder = new StringBuilder();
		ArrayList<String> solution = new ArrayList<String>();
		newdfs.printParenthesis(5,0,0,builder,solution);
		System.out.println(solution);
	}
}