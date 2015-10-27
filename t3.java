public void printParentheses(int n, int l, int r, StringBuilder sol) {

	if (l + r == 2*n) {
		System.out.println(sol);
		return;
	}

	if (l < n) {
		sol.append('(');
		printParentheses(n, l+1, r, sol);
		sol.removeLast("(");
	}

	if (r < l) {
		sol.append(")");
		printParentheses(n, l, r+1, sol);
		sol.removeLast(")");
	}

}