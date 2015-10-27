public class c1 {


	
	
	public void printSubset(String input) {
          if (input == null) {
          	return;
          }

          StringBuilder solution = new StringBuilder();
          printSubset(input, 0, solution);

	}



	private void printSubset(String input, int level, StringBuilder solution) {
		if (level == input.length()) {
			System.out.println(solution.toString());
			return;
		} else {
			//Case 1: Do not append anything, go to next level
			printSubset(input, level+1, solution);
			//Case 2: Append apparent level letter to builder
			//Don't forget to resume original state by popping the new element
			solution.append(input.charAt(level));
			System.out.println(solution.length());
			printSubset(input, level+1, solution);
			solution.deleteCharAt(solution.length() - 1);




		}


	}

    public static void main(String[] args) {
    	c1 newtest = new c1();

    	String input = "bac";
    	newtest.printSubset(input);
    }


}