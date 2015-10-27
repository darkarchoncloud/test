import java.util.ArrayList;
import java.util.*;



public class c12 {
  public List<String> subSets(String set) {
    // write your solution here
    if (set == null) {
      return null;
    }
    List<String> ls = new ArrayList<String>();
    return subSets(set, 0, ls);
    
  }
  
  
  private List<String> subSets(String input, int level, List<String> solution) {

    if (level == input.length()) {
      return solution;

    } else {
      //Case 1: Don't append anything
      subSets(input, level + 1, solution);
      //Case 2: Append char at new level
      StringBuilder builder = new StringBuilder();
      builder.append(input.charAt(level));
      solution.add(builder.toString());
      subSets(input, level + 1, solution);
      solution.remove(solution.size() - 1);
    }
    
    return solution;
  }


  public static void main(String[] args) {
  	c12 newtest = new c12();

  	String input = "abc";
  	List<String> result = new ArrayList<String>();
    result = newtest.subSets(input);

    for (String ele: result) {
    	System.out.println(ele);
    }

  }
}