public class longestsub {
	public int longestSub(int[] array) {
		if (array == null || array.length == 0) {
			return 0;
		}

		int maxLength = 0;

		int len = array.length;
		int length = 1;
		for (int i = 0; i < len - 1; i++) {
			if (array[i+1] >= array[i]) {
				length++;
				if (length >= maxLength) {
					maxLength = length;
				} 
				} else {
					length = 1;
				}


			}
			return maxLength;
			}

			public static void main(String[] args) {
				longestsub dark = new longestsub();
				int[] array = new int[] {1,4,5,7,2,3,0,6,8};
				int result = dark.longestSub(array);
				System.out.println(result);
			}

		}


	

