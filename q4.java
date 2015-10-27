public class q4 {
	public void swap(StringBuffer str, int i, int j) {
          assert (i < str.length() && j < str.length());
          if (i == j) {
          	return;
          }
          char temp = str.charAt(i);
          str.setCharAt(i, str.charAt(j));
          str.setCharAt(j, temp);

          
         

	}

	public void permutation(StringBuffer str, int level) {
		if (level == str.length()) {
			System.out.println(str);
			return;
		}

		for (int i = level; i < str.length(); i++) {
			swap(str, level, i);
			permutation(str, level+1);
			swap(str, level, i);
		}

	}

	public static void main(String[] args) {
		q4 newq = new q4();
		StringBuffer str = new StringBuffer("abcd");
		newq.permutation(str, 0);
	}



}