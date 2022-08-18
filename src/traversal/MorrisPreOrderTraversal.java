package traversal;

import ds.TreeNode;

public class MorrisPreOrderTraversal {

	public static void traverse(TreeNode root) {
		TreeNode currentNode = root;
		while (currentNode != null) {
			if (currentNode.left == null) {
				System.out.print(currentNode.val + "->");
				currentNode = currentNode.right;
			}
			else {
				TreeNode next = currentNode.left;
				while (next.right != null && next.right != currentNode) {
					next = next.right;
				}
				if (next.right == null) {
					next.right = currentNode;
					System.out.print(currentNode.val + "->");
					currentNode = currentNode.left;
				}
				else {
					next.right = null;
					currentNode = currentNode.right;
				}
			}
		}
		System.out.println();
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

		traverse(root);
	}
}
