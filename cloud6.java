public class cloud6 {
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

	
	public void firstKSmallest(int[] array, int start, int end, int k) {
		if (start >= end) {
			return;
		}
		int pivotIndex = partition(array, start, end);
		if (pivotIndex == k-1) {
			System.out.println("The pivot is: " + pivotIndex);
			System.out.println("The element is: " + array[pivotIndex]);
			
			return;
		} else if (pivotIndex < k-1) {
			firstKSmallest(array, pivotIndex+1, end, k);

		}
		else {
			firstKSmallest(array, start, pivotIndex-1, k);

		}
		
		
	}


	public static void main(String[] args) {
		cloud6 newcloud = new cloud6();
		int[] array = new int[]{4,2,1,7,5,3,8,10,9,6};
		int k = 5;
		newcloud.firstKSmallest(array, 0, array.length-1, k);
		for(int i : array) {
			System.out.println(i);
		}

	}
}