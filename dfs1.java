public class dfs1 {
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
   * {"2", "1", "#", "#", "3", "#", "#"}
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

public void printPreOrder(TreeNode root) {
	if (root ==  null) {
		return;
	}
	System.out.print(root.key + "=>");
	printPreOrder(root.left);
	printPreOrder(root.right);
}

public void printInOrder(TreeNode root) {
	if (root == null) {
		return;
	}
	printInOrder(root.left);
	System.out.print(root.key + "=>");
	printInOrder(root.right);
}

public void printPostOrder(TreeNode root) {
	if (root == null) {
		return;
	}
	printPostOrder(root.left);
	printPostOrder(root.right);
	System.out.print(root.key + "=>");
}


public static void main(String[] args) {
	TreeNode root1 = TreeNode.reConstruct(new String[] {"-15", "5", "-8", "2", "#", "#", "6", "#", "#", "1", "#", "#", "6", "3", "#", "#", "9", "#", "0", "4", "#", "#", "-1", "10", "#", "#", "#"});
	String pre = TreeNode.preOrder(root1);
	dfs1 newdfs = new dfs1();
	System.out.println("In order print tree: ");
	newdfs.printInOrder(root1);
	System.out.println();
	System.out.println("Post order print tree: ");
	newdfs.printPostOrder(root1);
	System.out.println();
	System.out.println("Pre order print tree: ");
	newdfs.printPreOrder(root1);
	System.out.println();

}

}