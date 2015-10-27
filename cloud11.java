public class cloud11 {
	public int closestIndex(int[] array, int target) {
		if (array == null || array.length == 0) {
			return -1;
		}

		int mid = 0;
		int left = 0;
		int right = array.length - 1;

		while (left < right - 1) {
			mid = left + (right - left) / 2;
			if (array[mid] == target) {
				return mid;
			} else if (array[mid] < target) {
				left = mid;
			} else {
				right = mid;
			}
		}

		return (Math.abs(array[left] - target) < Math.abs(array[right] - target)) ? left : right;

	}

	public static void main(String[] args) {
		cloud11 newcloud = new cloud11(); 
		int[] array = new int[] {1,4,5,8};
		int target = 7;
		System.out.println(newcloud.closestIndex(array, target));

	}
}