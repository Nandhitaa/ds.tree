package bst;

import ds.TreeNode;
import traversal.InOrderTraversal;

public class RecoverBST {

	private TreeNode first;
	private TreeNode middle;
	private TreeNode second;
	private TreeNode prev;
	private TreeNode root;

	RecoverBST(TreeNode root) {
		this.root = root;
		inorder(root);
		swap();
	}

	private void inorder(TreeNode node) {

		if (node == null)
			return;

		inorder(node.left);

		if (prev != null && prev.val > node.val) {
			if (first == null) {
				first = prev;
				middle = node;
			}
			else {
				second = node;
			}
		}

		prev = node;

		inorder(node.right);

	}

	private void swap() {
		if (second != null) {
			int temp = second.val;
			second.val = first.val;
			first.val = temp;
		}
		else {
			int temp = middle.val;
			middle.val = first.val;
			first.val = temp;
		}
	}

	private TreeNode getRoot() {
		return this.root;
	}
	
	public static void main(String[] args) {
		TreeNode root = new TreeNode(3);

		TreeNode node1 = new TreeNode(1);
		TreeNode node2 = new TreeNode(2);
		TreeNode node4 = new TreeNode(4);

		root.left = node1;
		root.right = node4;
		node4.left = node2;

		InOrderTraversal.traverse(root);

		RecoverBST obj = new RecoverBST(root);
		
		InOrderTraversal.traverse(obj.getRoot());
	}
}
