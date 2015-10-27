public class test4 {
	public void quickSort(int[] array) {
		if (array == null) {
			return;
		}
		
		quickSort(array, 0, array.length - 1);


	}

	private void quickSort(int[] array, int left, int right) {
		if (left >= right) {
			return;
		}
		int pivotPos = partition(array, left, right);
		quickSort(array, left, pivotPos - 1);
		quickSort(array, pivotPos + 1, right);
	}

	public int partition(int[] array, int left, int right) {
		int pivotPos = pivotPos(left, right);
		int pivot = array[pivotPos];

		swap(array, pivotPos, right);

		int i = left;
		int j = right - 1;

		while (i <= j) {
			if (array[i] < pivot) {
				i++;
			} else {
				swap(array, i, j--);
			}
		}

		swap(array, i, right);
		return i;
	}

	private int pivotPos(int left, int right) {
		return left + (int)(Math.random() * (right - left + 1));
	}

	private void swap(int[] array, int left, int right) {
		int temp;
		temp = array[left];
		array[left] = array[right];
		array[right] = temp;
	}


	public static void main(String[] args) {
		test4 newtest = new test4();
		int[] array = new int[]{ 2, 5, 3, 1, 4 };
	
		newtest.quickSort(array);
		for (int i : array) {
			System.out.println(i);
		}
	
}
}