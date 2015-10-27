import java.util.Queue;
import java.util.Deque;
import java.util.LinkedList;

public class q3 {

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


    public void rightView(TreeNode root, int level, int[] max_level) {
    	if (root == null) {
    		return;
    	}


    	if (level > max_level[0]) {
	System.out.print(root.key);
	max_level[0] = level;

}
    rightView(root.right, level+1, max_level);
    rightView(root.left, level+1, max_level);


        
}

	public void BFS(TreeNode root) {
		if (root == null) {
			System.out.println(root);
			return;
		}

		Queue<TreeNode> queue = new LinkedList<TreeNode>();
		queue.offer(root);
		while (!queue.isEmpty()) {
			int size = queue.size();
			for (int index = 0; index < size; index++) {
				TreeNode currentNode = queue.poll();
				if (currentNode.left != null) {
					queue.offer(currentNode.left);
				}
				if (currentNode.right != null) {
					queue.offer(currentNode.right);
				}
				if (index == size - 1) {
				System.out.print(currentNode.key);
			}
			}
			System.out.println();
		}
	}

	public static void main(String[] args) {
		q3 newq = new q3();

		int[] max_level = new int[3];

		TreeNode root = TreeNode.reConstruct(new String[] {"1", "2", "4", "9", "10", "#", "#", "11", "#", "#", "#", "5", "#", "#", "3", "6", "#", "#", "7", "#", "8",  
         "#", "#"});

        // newq.BFS(root);

        newq.rightView(root, 1, max_level);

	}





}