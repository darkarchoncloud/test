public class c11 {

	public static void main(String[] args) {
		StringBuilder builder = new StringBuilder();

		int v = 300;
		double v2 = 3.14;
		short v3 = 5;
		char value4 = 'A';

		builder.append(v).append("\n");
		builder.append(v2).append("\n");
		builder.append(v3).append("\n");
		builder.append(value4);

		String result = builder.toString();

		System.out.println(result);
	}
}