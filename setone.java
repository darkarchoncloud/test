public class setone {
	public int setOne(int input, int k) {
        if (k < 0) {
        	System.out.print("Wrong bit!");
        	return -1;
        }
        int a = 1;
        a = a << k;
        int result = input | a;
        return result;

	}

	public String bRep(int input) {
		int remainder = 1;
		StringBuilder builder = new StringBuilder();
		while (input != 0) {
			remainder = input % 2;
			input = input / 2;
			builder.append(remainder);


		}
		return builder.reverse().toString();
	}

	public static void main(String[] args) {
		setone dark = new setone();
		int input = 38;
		String result = dark.bRep(input);
		System.out.println(result);

		int k = 4;

		System.out.println("Now after set the kth bit to 1: ");
		int output = dark.setOne(input, k);

		String result1 = dark.bRep(output);
		System.out.println(result1);


        System.out.println("The number is: ");
		System.out.println(output);
	}
}