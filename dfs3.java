public class dfs3 {
	public void printParenthesis(int k, int left, int right, StringBuilder solution) {
		if (left + right == 2 * k) {
			System.out.println(solution);
		}

		if (left < k) {
			solution.append("(");
			printParenthesis(k, left + 1, right, solution);
			solution.deleteCharAt(solution.length() - 1);


		}

		if (right < left) {
			solution.append(")");
			printParenthesis(k, left, right + 1, solution);
			solution.deleteCharAt(solution.length() - 1);
		}

	}

	public static void main(String[] args) {
		dfs3 newdfs = new dfs3();
		StringBuilder builder = new StringBuilder();
		newdfs.printParenthesis(5, 0, 0, builder);
	}
}