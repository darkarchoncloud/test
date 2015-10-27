public class removeadj1 {
	public String deDup1(String input) {
		if (input == null || input.length() == 0) {
			return input;
		}
		char[] array = input.toCharArray();
		int pos = 0;
		

		for (int i = 1; i < array.length; i++) {
			int counter = 0;
			if (array[i] == array[i-1]) {
				counter++;
				
				continue;
			} 

			if (counter >= 2) {
			    array[pos+3] = array[i];
				array[pos+2] = array[i];
			    pos = pos + 2;
			} else {
				array[++pos] = array[i];
			}

			}
			

			return new String(array, 0, pos + 1);
		
		
		
	}

	public static void main(String[] args) {

		removeadj1 dark = new removeadj1();
		String input = "abbbbc";
		String result = dark.deDup1(input);
		System.out.println(result);

	}
}