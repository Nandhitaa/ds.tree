package conversions;

import ds.TreeNode;
import traversal.PreOrderTraversal;

public class BinaryTreeToLinkedList {

	public static TreeNode head;

	public void binaryTreeToLl(TreeNode root) {
		if (root == null) {
			return;
		}
		TreeNode current = root;
		while (current != null) {
			TreeNode temp = current.left;
			while (temp != null && temp.right != null) {
				temp = temp.right;
			}
			if (temp != null) {
				temp.right = current.right;
				current.right = current.left;
				current.left = null;
			}
			current = current.right;
		}
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

		BinaryTreeToLinkedList obj = new BinaryTreeToLinkedList();
		PreOrderTraversal.traverse(root);
		obj.binaryTreeToLl(root);
		TreeNode curr = root;
		while (curr != null) {
			System.out.print(curr.val + "->");
			curr = curr.right;
		}
	}

}
