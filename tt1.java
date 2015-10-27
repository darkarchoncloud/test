class tt1 {

	public static void main(String[] args) {
		double t = Math.random();
		System.out.println(t);
		int start = 0;
		int end = 10;
		int randomNum = start + (int)(end*t);
		double c = 1.01;
		int floor = (int)(c);
		System.out.println(floor);
		System.out.println(randomNum);
	}
}