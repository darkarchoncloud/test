class cloud9 {
	public int binarySearch(int[] array, int left, int right, int target) {
		if (array == null || array.length == 0) {
			return -1;
		}
		int mid;
		while (left < right - 1) {
			mid = left + (right - left) / 2;
			if (array[mid] >= target) {
				right = mid;
			} else {
				left = mid;
			}
		}
		if (array[left] == target) {
			return left;
		} 
		if (array[right] == target) {
			return right;
		}
		return -1;
		
	}

	public static void main(String[] args) {
		cloud9 newcloud = new cloud9();
		int[] array = new int[]{0,1,1,1, 2, 2, 3, 4, 8};
		int target = 5;
		System.out.println(newcloud.binarySearch(array, 0, array.length - 1, target));

	}
}