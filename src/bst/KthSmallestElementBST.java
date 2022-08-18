package bst;

import ds.TreeNode;

public class KthSmallestElementBST {

	private int getKthSmallestElement(TreeNode root, int k) {
		int count = 0;
		TreeNode current = root;
		while (current != null) {
			if (current.left == null) {
				count++;
				if (count == k) {
					return current.val;
				}
				current = current.right;
			}
			else {
				TreeNode next = current.left;
				while (next.right != null && next.right != current) {
					next = next.right;
				}
				if (next.right == null) {
					next.right = current;
					current = current.left;
				}
				else if (next.right == current) {
					next.right = null;
					count++;
					if (count == k) {
						return current.val;
					}
					current = current.right;
				}
			}
		}
		return -1;
	}

	public static void main(String[] args) {
		TreeNode root = new TreeNode(5);

		TreeNode node3 = new TreeNode(3);
		TreeNode node7 = new TreeNode(7);
		TreeNode node1 = new TreeNode(1);
		TreeNode node4 = new TreeNode(4);
		TreeNode node2 = new TreeNode(2);
		TreeNode node6 = new TreeNode(6);
		TreeNode node8 = new TreeNode(8);

		root.left = node3;
		root.right = node7;
		node3.left = node1;
		node3.right = node4;
		node1.right = node2;
		node7.left = node6;
		node7.right = node8;

		KthSmallestElementBST obj = new KthSmallestElementBST();
		int k = 3;
		int element = obj.getKthSmallestElement(root, k);
		System.out.println(element);

	}
}
