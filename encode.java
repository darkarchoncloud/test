public class encode {
	public String convert(String input) {
		if (input == null || input.length() == 0) {
			return input;
		}
		char[] array = input.toCharArray();
		int count = 0;
		for (int i = 0; i < array.length; i++) {
			if (array[i] == ' ') {
				count++;
			}
		}

		int len = input.length();
		int newLen = len + 2 * count;
		StringBuilder sb = new StringBuilder(newLen);



		for (int j = 0; j < len; j++) {
			if (array[j] != ' ') {
				sb.append(array[j]);
			} else {
				sb.append("20%");
			}

		}
		return sb.toString();

		
	}

	public static void main(String[] args) {
		encode dark = new encode();
		String input = "google/q?flo wer market";
		String result = dark.convert(input);
		System.out.println(result);
	}
}