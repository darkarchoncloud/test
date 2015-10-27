public class poweroftwo {
	public boolean powerOfTwo(int target) {
		int a = 1;
		int counter = 0;
		while (target > 0) {
			if ((target & a) == 1) {
				counter++;
			}
			target >>= 1;
		}
		return (counter == 1);



	}

	public boolean powerOfTwo1(int target) {
		return ((target & (target - 1)) ==  0 && target != 0);
	}

	public static void main(String[] args) {
		poweroftwo dark = new poweroftwo();

		int target = 8;
		System.out.println(dark.powerOfTwo(target));
		System.out.println(dark.powerOfTwo1(target));

		target = 10;
		System.out.println(dark.powerOfTwo(target));
		System.out.println(dark.powerOfTwo1(target));
	}
}


