public class test5 {
	public void commonElement(int[] array1, int[] array2) {
		if (array1 == null || array2 == null || array1.length == 0 || array2.length == 0) {
			return;
		}
		int index1 = 0;
		int index2 = 0;
		int start;
		while (index1 < array1.length && index2 < array2.length) {
			if (array1[index1] < array2[index2]) {
				index1++;
			} else if (array1[index1] > array2[index2]) {
				index2++;
			} else {
				System.out.println(array1[index1]);
				index1++;
				index2++;
			}

		}

	}

	public static void main(String[] args) {
		test5 newtest = new test5();
		int[] array1 = new int[] {1,2,3,4,5};
		int[] array2 = new int[] {4,5,6};
		newtest.commonElement(array1, array2);

		

	}
}