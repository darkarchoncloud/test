import java.util.HashSet;
import java.util.ArrayList;
import java.util.List;

public class commonnumbers {
	public List<Integer> commonHashSet(int[] array1, int[] array2) {
		if (array1 == null || array2 == null) {
			return null;
		}

		HashSet<Integer> set = new HashSet<Integer>();
		for (int ele : array1) {
			set.add(ele);
		}

		List<Integer> result = new ArrayList<Integer>();
		for (int number : array2) {
			if (set.contains(number)) {
				result.add(number);
			}
		}
		return result;
	}

	public static void main(String[] args) {
		commonnumbers dark = new commonnumbers();
		int[] array1 = new int[] {2,3,4};
		int[] array2 = new int[] {1,2,4};
		int[] array3 = new int[] {1,5};

		List<Integer> result = new ArrayList<Integer>();
		result = dark.commonHashSet(array2, array3);
		System.out.println(result);

	}
}