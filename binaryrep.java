public class binaryrep {
	String binaryRep(int input) {
		StringBuilder builder = new StringBuilder();
		while (input != 0) {
			int p = input % 2;
			input = input / 2;
			builder.append(p);

		}

		return builder.reverse().toString();
	}

	public static void main(String[] args) {
		binaryrep dark = new binaryrep();
		int input = 38;
		String result = dark.binaryRep(input);
		System.out.println(result);
	}
}