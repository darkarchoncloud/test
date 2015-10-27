public class cloud2 {

	public void printParentheses(int k) {
		if (k == 0) {
			return;
		}
		StringBuilder sb = new StringBuilder();

		printParentheses(k, 0, 0, sb);
	}

	 public void printParentheses(int k, int left, int right, StringBuilder sb) {
	 	if (left + right == 2*k) {
	 		System.out.println(sb.toString());
	 		return;
	 	}

	 	if (left < k) {
	 		sb.append("(");
	 		printParentheses(k, left + 1, right, sb);
	 		sb.setLength(sb.length()-1);
	 	}

	 	if (right < left) {
	 		sb.append(")");
	 		printParentheses(k, left, right + 1, sb);
	 		sb.setLength(sb.length() - 1);
	 	}
	 }

	 public static void main(String[] args) {
	 	cloud2 newcloud = new cloud2();
	 	int k = 3;
	 	newcloud.printParentheses(k);
	 }

}