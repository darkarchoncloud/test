class cloud5 {

	//mergesort
	public void copyArray(int[] source, int[] dest, int start, int end) {
		for (int i = start; i <= end; i++) {
			dest[i] = source[i];
		}
		return;
	}

	public void mergeSort(int[] array) {
		if (array == null) {
			return;
		}
		int[] helper = new int[array.length];
		mergeSort(array, helper, 0, array.length - 1);
	}

	public void mergeSort(int[] array, int[] helper, int start, int end) {
		if (start >= end) {
			return;
		}

		int mid = start + (end - start) / 2;
		mergeSort(array, helper, start, mid);
		mergeSort(array, helper, mid + 1, end);
		merge(array, helper, start, mid, end);
	}


	public void merge(int[] array, int[] helper, int start, int mid, int end) {
		copyArray(array, helper, start, end);
		
		int index1 = start;
		int index2 = mid + 1;

		while (index1 <= mid && index2 <= end) {
			if (helper[index1] < helper[index2]) {
				array[start++] = helper[index1++];
			} else {
				array[start++] = helper[index2++];
			}

		}

		while (index1 <= mid) {
			array[start++] = helper[index1++];
		}
		while (index2 <= end) {
			array[start++] = helper[index2++];
		}

		
	}


	public static void main(String[] args) {
		cloud5 newcloud = new cloud5();
		int[] array = new int[] {1,4,3,6,2,7};
		int[] helper = new int[array.length];

		newcloud.mergeSort(array, helper, 0, array.length - 1);

		for (int i : array) {
			System.out.println(i);
		}
	}
}