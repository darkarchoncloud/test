public class cloud12 {


   public int[] kClosest(int[] array, int target, int k) {
   	if (array == null || array.length == 0 || k > array.length) {
   		return null;
   	}

   	int[] kClosest = new int[k];
   	if (k == 0) {
   		return kClosest;
   	}

   	int closest = closestIndex(array, target);

   	kClosest[0] = array[closest];

   	int smaller = closest - 1;
   	int bigger = closest + 1;
   	for (int i = 1; i < k; i++) {
   		if (bigger >= array.length || smaller >= 0 && (target - array[smaller]) <= (array[bigger] - target)) {
   			kClosest[i++] = array[smaller--];
   		} else if (smaller <= 0 || bigger <= array.length && (target - array[smaller]) >= (array[bigger] - target)) {
   			kClosest[i++] = array[bigger++];
   		}
   	}
   	return kClosest;

   }


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




	public int kthClosest(int[] array, int target, int k) {
		if (array == null || array.length == 0) {
			return -1;
		}
		if (k == 0 || k > array.length) {
			return -1;
		}

		int mid = 0;
		int left = 0;
		int right = array.length - 1;

		while (left < right - 1) {
			mid = left + (right - left) / 2;
			if (array[mid] == target) {
				if (k > mid + 1) {
					return -1;
				} else {
					return Math.abs(array[mid - k + 1]) < Math.abs(array[mid + k - 1]) ? (mid - k + 1) : (mid + k - 1);
				}
			} else if (array[mid] < target) {
				left = mid;
			} else {
				right = mid;
			}

		}

		int i = left;
		int j = right;
		boolean flag = true;

		while (k > 0) {
			k--;
			if (Math.abs(array[i] - target) < Math.abs(array[j] - target)) {
				i--;
				flag = true;
				if (i == 0) {
					j++;
					flag = false;
				}
			} else if (Math.abs(array[i] - target) > Math.abs(array[j] - target)) {
				j++;
				flag = false;
				if (j == array.length - 1) {
					i--;
					flag = true;
				}
			}
		}

		if (flag == true) {
			return i;
		} else {
			return j;
		}


	}

	public static void main(String[] args) {
		cloud12 newcloud = new cloud12();
		int[] array = new int[]{1,4,6,8};
		int target = 3;
		int k = 3;
		int[] result = newcloud.kClosest(array, target, k);
		for (int i : result){

		System.out.println(i);
	}
}
}