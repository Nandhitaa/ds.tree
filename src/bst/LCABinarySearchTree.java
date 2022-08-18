package bst;

import ds.TreeNode;

public class LCABinarySearchTree {

	public TreeNode lca(TreeNode root, int num1, int num2) {
		if (root == null) {
			return null;
		}
		if (num1 < root.val && num2 < root.val) {
			return lca(root.left, num1, num2);
		}
		if (num1 > root.val && num2 > root.val) {
			return lca(root.right, num1, num2);
		}
		return root;
	}

	public static void main(String[] args) {
		TreeNode root = new TreeNode(6);
		TreeNode node2 = new TreeNode(2);
		TreeNode node3 = new TreeNode(8);
		TreeNode node4 = new TreeNode(0);
		TreeNode node5 = new TreeNode(4);
		TreeNode node6 = new TreeNode(3);
		TreeNode node7 = new TreeNode(5);
		TreeNode node8 = new TreeNode(7);
		TreeNode node9 = new TreeNode(9);

		root.left = node2;
		root.right = node3;
		node2.left = node4;
		node2.right = node5;
		node5.left = node6;
		node5.right = node7;
		node3.left = node8;
		node3.right = node9;

		LCABinarySearchTree obj = new LCABinarySearchTree();
		TreeNode result = obj.lca(root, 0, 4);
		System.out.println(result.val);
	}

}
