public class d2 {
	public void validParentheses(int k) {
		char[] solution = new char[2*k];
		validParentheses(k, 0, 0, solution);
	}


	public void validParentheses(int k, int left, int right, char[] solution) {
		if (left + right == 2*k) {
			System.out.println(new String(solution));
		}

		if (left < k) {
			solution[left + right] = '(';
			validParentheses(k, left + 1, right, solution);
		}

		if (right < left) {
			solution[left + right] = ')';
            validParentheses(k, left, right + 1, solution);

		}
	}

	public static void main(String[] args) {
		d2 newtest = new d2();

		int k = 3;

		newtest.validParentheses(k);
	}


}