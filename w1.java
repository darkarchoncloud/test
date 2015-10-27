import java.util.HashSet;

public class w1 {
    public static void main(String[] args) {
    	String input = "012345";
    	char[] array = input.toCharArray();
    	for (int i = 0; i < array.length; i++) {
    		System.out.println(array[i] > 50);
    	}
    }
}