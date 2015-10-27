public class setzero {
	public int setZero(int input, int k) {
		if (k < 0) {
			System.out.println("Wrong bit!");
			return -1;
		}
		int a = 1;
		a = a << k;
		a = ~a;
		return input & a;

	}

	public String biRep(int input) {
		int remainder = 1;
		StringBuilder builder = new StringBuilder();
		while (input != 0) {
			remainder = input % 2;
			input /= 2;
			builder.append(remainder);
		}
		return builder.reverse().toString();



	}

	public static void main(String[] args) {
		setzero dark = new setzero();
		int input = 38;
		String result = dark.biRep(input);

		System.out.println(result);
		int k = 1;

		int output = dark.setZero(input, k);
		System.out.println(output);
		String result1 = dark.biRep(output);
		System.out.println(result1);
	}
}