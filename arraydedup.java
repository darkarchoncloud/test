public class arraydedup {
	public int dedup(int[] array) {
		if (array == null) {
			return 0;
		}

		int len = array.length;
		int pos = 0;
		for (int i = 1; i < len; i++) {
			if (array[i] == array[i-1]) {
				continue;
			}
			array[++pos] = array[i];
		}
		return pos+1;
	}

	public static void main(String[] args) {
		arraydedup dark = new arraydedup();
		int[] array = new int[]{1,2,2,3,3,3};
		int result = dark.dedup(array);
		System.out.println(result);
		System.out.println("Now after deduplicate, the elements are: ");
		for (int ele : array) {
			System.out.print(ele+" ");
		}
	}
}