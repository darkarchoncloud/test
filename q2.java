public class q2 {

	public String shiftLetters(String input, int k) {
		if (input == null || k == 0 || k >= input.length()) {
			return null;
		}

		char[] array = input.toCharArray();
		reverse(array, 0, array.length - 1);
		reverse(array, 0, k-1);
		reverse(array, k, array.length - 1);

		
		return new String(array);

	}

	private void reverse(char[] array, int left, int right) {
		while (left < right) {
			char temp = array[left];
			array[left] = array[right];
			array[right] = temp;
			left++;
			right--;
		}
	}

	public static void main(String[] args) {
		q2 newq = new q2();
		String words = "ABCDEF";
		String rev = newq.shiftLetters(words, 3);
		System.out.println(rev);
	}
}
