
import java.util.ArrayList;
import java.util.List;
import java.util.Deque;
import java.util.LinkedList;

public class fish1 {

  public TreeNode insert(TreeNode root, int key) {
    if (root == null) {
      // root = new TreeNode(key);
      // return root;
      TreeNode newroot = new TreeNode(key);
      return newroot;
    }
    TreeNode current = root;
    TreeNode prev = null;
    while (current != null) {
      if (current.key == key) {
        
        return root;
      } else if (current.key < key) {
        prev = current;
        current = current.right;
      } else {
        prev = current;
        current = current.left;
      }
      
    }
    TreeNode newNode = new TreeNode(key);
    if (prev.key < key) {
      
      prev.right = newNode;
    } else {
      prev.left = newNode;
    }
    return root;
  }
	public List<Integer> preOrder(TreeNode root) {
         List<Integer> temp = new ArrayList<Integer>();

         if (root == null) {
         	
         	return temp;
         }
         
         Deque<TreeNode> stack = new LinkedList<TreeNode>();
         stack.offerFirst(root);
         while(!stack.isEmpty()) {
         	TreeNode current = stack.pollFirst();
         	temp.add(current.key);
         	System.out.println(current.key);
         	if (current.right != null) {
         		stack.offerFirst(current.right);
            
         	}
         	if (current.left != null) {
         		stack.offerFirst(current.left);
            
         	}


         }
         return temp;

    }
		public static class TreeNode {
  /*
   * Special symbol for null node, used in pre-order reconstruction.
   */
  public static final String NULL_NODE = "#";
  /*
   * A TreeNode contains an integer key, a reference to the
   * root of left subtree and a reference to root of the right subtree.
   */
  public int key;
  public TreeNode left;
  public TreeNode right;

  public TreeNode(int key) {
    this.key = key;
  }

  @Override
  public String toString() {
    return String.valueOf(key);
  }

  /**
   * Construct the binary tree using pre-order traversal sequence.
   * 
   * Note: the null node will be represented as a special value "#".
   * 
   * If null node is ignored in the pre-order traversal sequence,
   * the constructed binary tree would not be UNIQUE.
   * 
   * Example:
   *           2
   *       /       \
   *      1         3
   *    /  \      /   \
   * null  null null null
   * 
   * The pre-order traversal sequence is:
   *
   * Using the above sequence we can reconstruct the binary tree.
   * 
   * @param preOrder
   *          the preOrder traversal sequence
   * @return the root of the constructed binary tree
   */
  public static TreeNode reConstruct(String[] preOrder) {
    if (preOrder == null || preOrder.length == 0) {
      return null;
    }
    return reConstruct(preOrder, 0).node;
  }

  /*
   * The real implementation of re-construction from preOrder traverse.
   */
  private static Result reConstruct(String[] preOrder, int left) {
    if (preOrder[left].equals(NULL_NODE)) {
      return new Result(left + 1, null);
    }
    TreeNode root = new TreeNode(Integer.parseInt(preOrder[left]));
    Result leftResult = reConstruct(preOrder, left + 1);
    root.left = leftResult.node;
    Result rightResult = reConstruct(preOrder, leftResult.index);
    root.right = rightResult.node;
    rightResult.node = root;
    return rightResult;
  }

  /*
   * Helper class for storing the intermediate information used in
   * reConstruct(String[] preOrder, int left) method.
   */
  private static class Result {
    int index;
    TreeNode node;

    Result(int index, TreeNode node) {
      this.index = index;
      this.node = node;
    }
  }

  /*
   * pre-order traversal to print the given binary tree.
   * null node will be represented as "#".
   */
  public static String preOrder(TreeNode root) {
    if (root == null) {
      return NULL_NODE;
    }
    StringBuilder preOrder = new StringBuilder();
    preOrder(root, preOrder);
    preOrder.deleteCharAt(preOrder.length() - 1);
    return preOrder.toString();
  }
  
  private static void preOrder(TreeNode root, StringBuilder preOrder) {
    if (root == null) {
      preOrder.append(NULL_NODE).append(" ");
      return;
    }
    preOrder.append(root.key).append(" ");
    preOrder(root.left, preOrder);
    preOrder(root.right, preOrder);
  }
}

	



	public static void main(String[] args) {
		fish1 newfish = new fish1();
		TreeNode root = TreeNode.reConstruct(new String[]  { "3", "2", "1", "#", "#", "#", "5", "4", "#", "#",
        "6", "#", "#" });
	    String result = TreeNode.preOrder(root);
	    System.out.println(result);
	    List<Integer> li = new ArrayList<Integer>();
	    li = newfish.preOrder(root);
	    System.out.print(li);
      TreeNode newTree = newfish.insert(root, 8);
      String result1 = TreeNode.preOrder(newTree);
      System.out.println(result1);
	}
}