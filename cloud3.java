public class cloud3 {
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
}
//=====================================================================
//=====================================================================
//=====================================================================

	public boolean isBST(TreeNode root) {
		return isBST(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
	}

	//1. 判断是否Binary Search Tree

	public boolean isBST(TreeNode root, int lower, int upper) {
		if (root == null) {
			return true;
		}

		if (root.key <= lower || root.key >= upper) {
			return false;
		}

		return isBST(root.left, lower, root.key) && isBST(root.right, root.key, upper);
	}
    //2. 树的高度
	public int getHeight(TreeNode root) {
		if (root == null) {
			return 0;
		}

		return Math.max(getHeight(root.left), getHeight(root.right)) + 1;
	}
    //3. 任何节点左子树里节点个数

    public int FindLeftChildrenTotal(TreeNode root, int[] result) {
    	if (root == null) {
    		return 0;
    	}
    	int leftTotal = FindLeftChildrenTotal(root.left, result);
    	int rightTotal = FindLeftChildrenTotal(root.right, result);

    	result[0] = leftTotal;

    	return leftTotal + rightTotal + 1;
    }

    //4. 是否balance

    public boolean isBalanced(TreeNode root) {
    	if (root == null) {
    		return true;
    	}
    	int leftHeight = getHeight(root.left);
    	int rightHeight = getHeight(root.right);

    	if (Math.abs(leftHeight - rightHeight) > 1) {
    		return false;
    	}

    	return isBalanced(root.left) && isBalanced(root.right);
    }

    // 5. 寻找left, right节点数maximum difference
    public int FindMaxDiff(TreeNode root, TreeNode resultNode, int[] result) {
    	if (root == null) {
    		return 0;
    	}

    	int leftTotal = FindMaxDiff(root.left, resultNode, result);
    	int rightTotal = FindMaxDiff(root.right, resultNode, result);

    	int maxDiff = Math.abs(leftTotal - rightTotal);
    	if (result[0] < maxDiff) {
    		result[0] = maxDiff;
    		resultNode = root;
    	}

    	return leftTotal + rightTotal + 1;





    }

    //6. Find Maximum path sum from one leaf to another leaf node

    public int maxPathSum(TreeNode root, int[] result) {
    	if (root == null) {
    		return 0;
    	}



    	int lcost = maxPathSum(root.left, result);
    	int rcost = maxPathSum(root.right, result);
    
    	int curr_sum = lcost + rcost + root.key;
    //
        if (curr_sum > result[0] && root.left != null && root.right != null) {
        	result[0] = curr_sum;
        }

        if (root.left == null) {
        	return rcost + root.key;
        } else if (root.right == null) {
        	return lcost + root.key;
        }
     //
        return Math.max(lcost, rcost) + root.key;
     //

    }



	public static void main(String[] args) {
		cloud3 newcloud = new cloud3();

		TreeNode root = null;
		root = TreeNode.reConstruct(new String[] {"3", "1", "0", "#", "#", "2", "#", "#", "5", "4","#", "#", "8","#","#"});
		System.out.println(newcloud.isBST(root));

        TreeNode root1 = null;
		root1 = TreeNode.reConstruct(new String[] {"5", "3", "1", "#", "#", "4", "#", "#", "#"});
        
        TreeNode complextreeroot = null;
        complextreeroot = TreeNode.reConstruct(new String[] {"-15", "5", "-8", "2", "#", "#", "6", "#", "#", "1", "#", "#", "6", "3", "#", "#", "9", "#", "0", "4", "#", "#", "-1", "10", "#", "#", "#"});

		System.out.println(newcloud.getHeight(root));

		int[] result1 = new int[10];

		int useless = newcloud.FindLeftChildrenTotal(complextreeroot, result1);

		System.out.println(result1[0]);
		System.out.println(useless);
		System.out.println(newcloud.isBalanced(root1));

		TreeNode resultNode = null;
		int[] result2 = new int[10];

		int useless2 = newcloud.FindMaxDiff(complextreeroot, resultNode, result2);

		System.out.println(useless2);
		System.out.println(result2[0]);
		// System.out.println(resultNode.key);

		int[] result = new int[10];

		int useless3 = newcloud.maxPathSum(complextreeroot, result);

		

		System.out.println(result[0]);
	}
}