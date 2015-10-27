
import java.util.Deque;
import java.util.List;
import java.util.ArrayList;
import java.util.LinkedList;

public class preorder { 

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

public List<Integer> preOrder1(TreeNode root) {
     List<Integer> result = new ArrayList<Integer>();
     if (root == null) {
      return result;
     }

     Deque<TreeNode> stack = new LinkedList<TreeNode>();
     stack.offerFirst(root);
     while (!stack.isEmpty()) {
      TreeNode temp = stack.pollFirst();
      result.add(temp.key);
      if (temp.right != null) {
        stack.offerFirst(temp.right);
      }
      if (temp.left != null) {
        stack.offerFirst(temp.left);
      }
     }
     return result;
   }

   public List<Integer> preOrder2(TreeNode root) {
    List<Integer> result = new ArrayList<Integer>();
    if (root == null) {
        return result;
    }
    Deque<TreeNode> stack = new LinkedList<TreeNode>();
    stack.offerFirst(root);
    while (!stack.isEmpty()) {
      TreeNode temp = stack.pollFirst();
      result.add(temp.key);
      if (temp.right != null) {
        stack.offerFirst(temp.right);
      }
      if (temp.left != null) {
        stack.offerFirst(temp.left);
      }

    }
    return result;
   }

public List<Integer> inOrder1(TreeNode root) {
    List<Integer> result = new ArrayList<Integer>();
    if (root == null) {
      return result;
    }

    Deque<TreeNode> stack = new LinkedList<TreeNode>();
    TreeNode current = root;
    stack.offerFirst(current);
    while (current.left != null) {
      stack.offerFirst(current.left);
      current = current.left;
    }
    while (!stack.isEmpty()) {
      TreeNode temp = stack.pollFirst();
      result.add(temp.key);
      if (temp.right != null) {
        stack.offerFirst(temp.right);
      }
    }
    return result;

}

public List<Integer> inOrder2(TreeNode root) {
    List<Integer> result = new ArrayList<Integer>();
    if (root == null) {
      return result;
    }
    
    Deque<TreeNode> stack = new LinkedList<TreeNode>();
    
    TreeNode current = root;
    while (current.left != null) {
      stack.offerFirst(current);
      current = current.left;
    }
    result.add(current.key);
    while (!stack.isEmpty()) {
      TreeNode temp = stack.pollFirst();
      result.add(temp.key);
      if (temp.right != null) {
         stack.offerFirst(temp.right);
      }
    }
    return result;
    
}

public List<Integer> postOrder1(TreeNode root) {
  List<Integer> result = new ArrayList<Integer>();
  if (root == null) {
    return result;
  }
  Deque<TreeNode> stack1 = new LinkedList<TreeNode>();
  Deque<TreeNode> stack2 = new LinkedList<TreeNode>();

  stack1.offerFirst(root);
  while (!stack1.isEmpty()) {
    TreeNode current = stack1.pollFirst();
    stack2.offerFirst(current);
    if (current.left != null) {
      stack1.offerFirst(current.left);
    }
    if (current.right != null) {
      stack1.offerFirst(current.right);
    }
  }
  while (!stack2.isEmpty()) {
    result.add(stack2.pollFirst().key);
  }

  return result;
}

public List<Integer> postOrder2(TreeNode root) {
  List<Integer> result = new ArrayList<Integer>();
  if (root == null) {
    return result;
  }
  Deque<TreeNode> stack1 = new LinkedList<TreeNode>();
  Deque<TreeNode> stack2 = new LinkedList<TreeNode>();

  stack1.offerFirst(root);
  while (!stack1.isEmpty()) {
    TreeNode temp = stack1.pollFirst();
    stack2.offerFirst(temp);
    if (temp.left != null) {
      stack1.offerFirst(temp.left);
    }
    if (temp.right != null) {
      stack1.offerFirst(temp.right);
    }
  }
    while (!stack2.isEmpty()) {
      TreeNode temp1 = stack2.pollFirst();
      result.add(temp1.key);
    }
    return result;
  }


  
  








public static void main(String[] args) {
  preorder newpre = new preorder();
  TreeNode root = TreeNode.reConstruct(new String[] {"5", "3", "1", "#", "#", "4", "#", "#", "8", "#", "11", "#", "#"});
      //          5

      //     3          8

      // 1       4            11





  List<Integer> result = new ArrayList<Integer>();
  result = newpre.preOrder2(root);
  System.out.println(result);
  result = newpre.inOrder2(root);
  System.out.println(result);
  result = newpre.postOrder2(root);
  System.out.println(result);
  

}


}

