public class d21 {

	public void validParentheses(int k) {
		StringBuilder builder = new StringBuilder();
		validParentheses(k, 0, 0, builder);
	}

	public void validParentheses(int k, int left, int right, StringBuilder builder) {
		if (left + right == 2*k) {
			System.out.println(new String(builder));
			return;
		}

		if (left < k) {
			builder.append("(");
			validParentheses(k, left + 1, right, builder);
			builder.setLength(builder.length() - 1);

		}

		if (right < left) {
			builder.append(")");
			validParentheses(k, left, right + 1, builder);
			builder.deleteCharAt(builder.length()-1);
		}
	}

	public static void main(String[] args) {
		d21 newtest = new d21();
		int k = 3;
		newtest.validParentheses(k);
	}
}