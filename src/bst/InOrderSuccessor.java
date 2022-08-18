package bst;

import ds.TreeNode;

public class InOrderSuccessor {

	private int findSuccessor(TreeNode node, int element) {
		int successor = 0;

		while (node != null) {
			if (element < node.val) {
				successor = node.val;
				node = node.left;
			}
			else {
				node = node.right;
			}
		}

		return successor;

	}

	public static void main(String[] args) {
		TreeNode root = new TreeNode(5);

		TreeNode node3 = new TreeNode(3);
		TreeNode node2 = new TreeNode(2);
		TreeNode node4 = new TreeNode(4);
		TreeNode node1 = new TreeNode(1);
		TreeNode node7 = new TreeNode(7);
		TreeNode node6 = new TreeNode(6);
		TreeNode node9 = new TreeNode(9);
		TreeNode node8 = new TreeNode(8);
		TreeNode node10 = new TreeNode(10);

		root.left = node3;
		root.right = node7;
		node3.left = node2;
		node3.right = node4;
		node2.left = node1;
		node7.left = node6;
		node7.right = node9;
		node9.left = node8;
		node9.right = node10;

		InOrderSuccessor obj = new InOrderSuccessor();
		int element = 7;
		int successor = obj.findSuccessor(root, element);
		System.out.println(successor);
	}
}
