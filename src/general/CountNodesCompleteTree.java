package general;

import ds.TreeNode;

public class CountNodesCompleteTree {

	private int getLeftHeight(TreeNode node) {
		if (node == null)
			return 0;
		int count = 0;
		while (node != null) {
			count++;
			node = node.left;
		}
		return count;
	}

	private int getRightHeight(TreeNode node) {
		if (node == null)
			return 0;
		int count = 0;
		while (node != null) {
			count++;
			node = node.right;
		}
		return count;
	}

	private int countNodes(TreeNode node) {
		if (node == null)
			return 0;

		int left = getLeftHeight(node);
		int right = getRightHeight(node);

		if (left == right) {
			return (int) (Math.pow(2, left) - 1);
		}

		return 1 + countNodes(node.left) + countNodes(node.right);

	}

	public static void main(String[] args) {
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

		CountNodesCompleteTree obj = new CountNodesCompleteTree();
		int count = obj.countNodes(root);
		System.out.println(count);

	}
}
