public class decompress {
	public String decompressI(String input) {
		if (input == null || input.length() == 0) {
			return null;
		}
		char[] array = input.toCharArray();
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < input.length() - 1; i++) {
			if (array[i+1] <= 'z' && array[i+1] >= 'a') {
				sb.append(array[i]);
			} else {
				int count = array[i+1] - '0';
				for (int j = 0; j < count; j++) {
					sb.append(array[i]);
				}
				i++;

			}

		}
		sb.append(array[array.length-1]);
		return sb.toString();

	}

	public static void main(String[] args) {
		decompress dark = new decompress();
		String input = "abc5de";
		String result = dark.decompressI(input);
		System.out.println(result);
	}
}