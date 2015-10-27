public class allunique {

	// public boolean allUnique(String word) {

	// 	if (word == null || word.length() == 0) {
	// 		return false;
	// 	}

	// 	char[] array = word.toCharArray();
	// 	int len = array.length;
	// 	int temp = 0;
	// 	for (int i = 0; i < len; i++) {
	// 		int temp2 = array[i] - 'a';
	// 		if ((temp & (1 << temp2)) != 0) {
	// 			return false;
	// 		} 
	// 		temp = temp | (1 << temp2);

	// 	}
	// 	return true;
	//}

	public boolean allUnique(String word) {
		if (word == null || word.length() == 0) {
			return false;
		}

		int temp = 0;
		for (int i = 0; i < word.length(); i++) {
			int pos = word.charAt(i) - 'a';
			if ((temp & (1 << pos)) != 0) {
				return false;
			} else {
				temp |= (1 << pos);
			}
		}
		return true;
	}



	

	public static void main(String[] args) {
		allunique dark = new allunique();
		String input = "abcdfqpo";

		boolean result = dark.allUnique(input);
		System.out.println(result);

		input = "shaoanqi";


		result = dark.allUnique(input);

		System.out.println(result);


	}

}