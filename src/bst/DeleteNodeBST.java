package bst;

import ds.TreeNode;
import traversal.PreOrderTraversal;

public class DeleteNodeBST {

	private TreeNode deleteNode(TreeNode root, int key) {
		if (root == null)
			return null;
		TreeNode node = root;
		if (node.val == key) {
			return rearrange(node);
		}
		while (node != null) {
			if (node.left != null && node.left.val == key) {
				node.left = rearrange(node.left);
				break;
			}
			else if (node.right != null && node.right.val == key) {
				node.right = rearrange(node.right);
				break;
			}
			else if (key > node.val) {
				node = node.right;
			}
			else {
				node = node.left;
			}
		}
		return root;
	}

	private TreeNode rearrange(TreeNode remove) {
		if (remove.left == null) {
			return remove.right;
		}
		else if (remove.right == null) {
			return remove.left;
		}
		else {
			TreeNode lastRightNode = findLastRightNode(remove.left);
			lastRightNode.right = remove.right;
			return remove.left;
		}
	}

	private TreeNode findLastRightNode(TreeNode node) {
		if (node == null)
			return null;
		while (node.right != null) {
			node = node.right;
		}
		return node;
	}

	public static void main(String[] args) {
		TreeNode root = new TreeNode(9);

		TreeNode node5 = new TreeNode(5);
		TreeNode node2 = new TreeNode(2);
		TreeNode node1 = new TreeNode(1);
		TreeNode node3 = new TreeNode(3);
		TreeNode node4 = new TreeNode(4);
		TreeNode node7 = new TreeNode(7);
		TreeNode node6 = new TreeNode(6);
		TreeNode node8 = new TreeNode(8);
		TreeNode node12 = new TreeNode(12);
		TreeNode node10 = new TreeNode(10);
		TreeNode node13 = new TreeNode(13);

		root.left = node5;
		root.right = node12;
		node5.left = node2;
		node5.right = node7;
		node2.left = node1;
		node2.right = node3;
		node3.right = node4;
		node7.left = node6;
		node7.right = node8;
		node12.left = node10;
		node12.right = node13;

		PreOrderTraversal.traverse(root);

		DeleteNodeBST obj = new DeleteNodeBST();
		TreeNode newRoot = obj.deleteNode(root, 5);

		PreOrderTraversal.traverse(newRoot);

	}
}
