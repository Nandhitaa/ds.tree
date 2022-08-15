package general;

import ds.TreeNode;

public class BalancedBinaryTree {

	private int height(TreeNode node) {
		if (node == null) {
			return 0;
		}

		int leftHeight = height(node.left);
		if (leftHeight == -1) {
			return -1;
		}

		int rightHeight = height(node.right);
		if (rightHeight == -1) {
			return -1;
		}

		if (Math.abs(leftHeight - rightHeight) > 1) {
			return -1;
		}

		return 1 + Math.max(leftHeight, rightHeight);
	}

	private boolean isBalanced(TreeNode root) {
		return height(root) != -1;
	}

	public static void main(String[] args) {
		BalancedBinaryTree obj = new BalancedBinaryTree();

		TreeNode root = new TreeNode(1);

		TreeNode node2 = new TreeNode(2);
		TreeNode node3 = new TreeNode(3);
		TreeNode node4 = new TreeNode(4);
		TreeNode node5 = new TreeNode(5);
		TreeNode node6 = new TreeNode(6);
		TreeNode node7 = new TreeNode(7);

		root.left = node2;
		root.right = node3;
		node2.left = node4;
		node2.right = node5;
		node3.left = node6;
		node3.right = node7;

		boolean result = obj.isBalanced(root);
		System.out.println(result);

	}
}
