package bst;

import ds.TreeNode;
import traversal.PreOrderTraversal;

public class BSTFromPreOrderTraversal {

	private TreeNode buildBST(int[] preOrder, int upperLimit, int[] index) {
		if (index[0] == preOrder.length || preOrder[index[0]] > upperLimit) {
			return null;
		}
		TreeNode root = new TreeNode(preOrder[index[0]++]);
		root.left = buildBST(preOrder, root.val, index);
		root.right = buildBST(preOrder, upperLimit, index);
		return root;
	}

	public static void main(String[] args) {
		int[] preOrder = { 8, 5, 1, 7, 10, 12 };
		BSTFromPreOrderTraversal obj = new BSTFromPreOrderTraversal();
		TreeNode root = obj.buildBST(preOrder, Integer.MAX_VALUE, new int[] { 0 });
		PreOrderTraversal.traverse(root);
	}
}
