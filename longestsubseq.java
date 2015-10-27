public class longestsubseq {
	public int longestSubseq(int[] array, int len) {
		if (array == null || array.length == 0) {
			return 0;
		}

		int[] result = new int[len + 1];
		result[0] = 1;
		for (int i = 1; i < len; i++) {
			if (array[i] >= array[i-1]) {
				result[i] = result[i-1] + 1;

			} else {
				int partial = 0;
				for (int k = 0; k < i - 1; k++) {
					if (array[i] >= array[k]) {
						if (result[k] > partial) {
							partial = result[k];
						}
					}
				}
				result[i] = partial;
			}
		}
		return result[len - 1];
	}

	public static void main(String[] args) {
		longestsubseq dark = new longestsubseq();
		int [] array = new int[] {1,4,5,7,3,2,8,4,6,9};
		int result = 0;
		for (int i = 1; i < array.length; i++) {
			if (dark.longestSubseq(array, i) > result) {
		
		System.out.println(result);
	}
	}
}
}