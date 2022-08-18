package bst;

import ds.TreeNode;

public class CeilBST {

	private int findCeil(TreeNode node, int key) {

		int ceil = -1;

		while (node != null) {
			if (node.val == key) {
				ceil = node.val;
				return ceil;
			}
			if (node.val < key) {
				node = node.right;
			}
			else {
				ceil = node.val;
				node = node.left;
			}
		}

		return ceil;
	}

	public static void main(String[] args) {
		TreeNode root = new TreeNode(10);

		TreeNode node5 = new TreeNode(5);
		TreeNode node13 = new TreeNode(13);
		TreeNode node3 = new TreeNode(3);
		TreeNode node6 = new TreeNode(6);
		TreeNode node11 = new TreeNode(11);
		TreeNode node14 = new TreeNode(14);
		TreeNode node9 = new TreeNode(9);
		TreeNode node2 = new TreeNode(2);
		TreeNode node4 = new TreeNode(4);

		root.left = node5;
		root.right = node13;
		node5.left = node3;
		node5.right = node6;
		node13.left = node11;
		node13.right = node14;
		node6.right = node9;
		node3.left = node2;
		node3.right = node4;

		CeilBST obj = new CeilBST();
		int ceil = obj.findCeil(root, 8);
		System.out.println(ceil);
	}
}
