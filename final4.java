import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Arrays;

public class final4 {

	public static Comparator<Integer> maxcomparator = new Comparator<Integer>() {
		public int compare(Integer i1, Integer i2) {
			if (i1 < i2) {
				return 1;
			} else if (i1 > i2) {
				return -1;
			} else {
				return 0;
			}
		}
	};

	public int[] smallestK(int[] array, int k) {
		if (array == null || k < 0 || k > array.length) {
			return null;
		}
		if (k == 0) {
			return new int[0];
		}
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(k, maxcomparator);

        for (int index = 0; index < array.length; index++) {
        	if (index < k) {
        		maxHeap.offer(array[index]);
        	} else if (array[index] < maxHeap.peek()) {
        		maxHeap.poll();
        		maxHeap.offer(array[index]);
        	}
        }

        return toSortedArray(maxHeap);


	}

	private int[] toSortedArray(PriorityQueue<Integer> maxHeap) {
		if (maxHeap == null) {
			return null;
		}
		int[] array = new int[maxHeap.size()];
		for (int index = array.length - 1; index >= 0; index--) {
			array[index] = maxHeap.poll();
		}

		return array;
	}

	public static void main(String[] args) {
		final4 newfinal = new final4();
		int k = 3;
		int[] array = new int[] {7,9,10,1,3,2};
		String result = Arrays.toString(newfinal.smallestK(array, k));
		System.out.println(result);
	}

}