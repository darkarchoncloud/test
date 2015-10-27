public class cloud10 {

	public int binarySearch(int[] array, int target) {
		if (array == null || array.length == 0) {
			return -1;
		}

		int mid;
		int left = 0;
		int right = array.length - 1;
		while (left < right - 1) {
			mid = left + (right - left) / 2;
			if (array[mid] <= target) {
				left = mid;
			}
			else {
				right = mid;
			}
		}
			if (array[right] == target) {
				return right;
			}
			if (array[left] == target) {
				return left;
			}

			return -1;
		}
	

	public static void main(String[] args) {
		cloud10 newcloud = new cloud10();
		int[] array = new int[]{0,1,1,1, 2, 2, 3, 4, 8};
		int target = 5;
		System.out.println(newcloud.binarySearch(array,  target));

	}

}