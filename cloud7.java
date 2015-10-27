class cloud7 {
	public int power(int a, int b) {
		if (b == 0) {
			return 1;
		} else if (b == 1) {
			return a;
		} else {
			int half = b / 2;
			int middle = power(a, half);
			if (b % 2 == 0) {
				
				return middle * middle;
			} else {
				return middle * middle * a;

			}
		}
	}

	public static void main(String[] args) {
		cloud7 newcloud = new cloud7();
		int a = 2;
		int b = 20;

		System.out.println(newcloud.power(a, b));
		System.out.println(newcloud.power(b,a));
	}
}