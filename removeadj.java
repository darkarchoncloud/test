public class removeadj {
	public String deDup(String input) {
		if (input == null || input.length() == 0) {
			return input;
		}
		char[] array = input.toCharArray();
		int pos = 0;
		for (int i = 1; i < array.length; i++) {
			if (array[i] == array[i-1]) {
				continue;
			}
			array[++pos] = array[i];
		}
		return new String(array, 0, pos+1);
	}

	public static void main(String[] args) {
		removeadj dark = new removeadj();
		String input = "aaabbcc";
		String result = dark.deDup(input);
		System.out.println(result);
	}
}