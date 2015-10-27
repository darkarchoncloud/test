public class cloud4 {
	//quicksort

	private int partition(int[] array, int start, int end) {
		int randomIndex = start + (int)(Math.random() * (end - start + 1));
		
		swap(array, randomIndex, end);
		int pivot = array[end];
		int i = start;
		int j = end - 1;
		while (i <= j) {
			if (array[i] < pivot) {
				i++;
			} else {
				
				swap(array, i, j);
				j--;
			}
			

		}
		swap(array, i, end);
		return i;
	}


	public void swap(int[] array, int index1, int index2) {
		int temp = array[index1];
		array[index1] = array[index2];
		array[index2] = temp;
		return;
	}

	public void quickSort(int[] array) {
		if (array == null || array.length == 0) {
			return;
		}
		quickSort(array, 0, array.length-1);

	}

	public void quickSort(int[] array, int start, int end) {
		if (start >= end) {
			return;
		}
		int pivotIndex = partition(array, start, end);
		quickSort(array, start, pivotIndex-1);
		quickSort(array, pivotIndex+1, end);
	}


	public static void main(String[] args) {
		cloud4 newcloud = new cloud4();
		int[] array = new int[]{3,5,1,2,4};
		newcloud.quickSort(array);
		for(int i : array) {
			System.out.println(i);
		}

	}
}