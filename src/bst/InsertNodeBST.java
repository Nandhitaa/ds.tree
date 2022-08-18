package bst;

import ds.TreeNode;
import traversal.PreOrderTraversal;

public class InsertNodeBST {

	private TreeNode insert(TreeNode node, TreeNode newNode) {
		if (node == null)
			return newNode;
		TreeNode root = node;
		while (true) {
			if (newNode.val < node.val) {
				if (node.left == null) {
					node.left = newNode;
					break;
				}
				else {
					node = node.left;
				}
			}
			else {
				if (node.right == null) {
					node.right = newNode;
					break;
				}
				else {
					node = node.right;
				}
			}
		}
		return root;
	}

	public static void main(String[] args) {
		TreeNode root = new TreeNode(6);

		TreeNode node3 = new TreeNode(3);
		TreeNode node2 = new TreeNode(2);
		TreeNode node4 = new TreeNode(4);
		TreeNode node8 = new TreeNode(8);
		TreeNode node7 = new TreeNode(7);

		root.left = node3;
		root.right = node8;
		node3.left = node2;
		node3.right = node4;
		node8.left = node7;

		InsertNodeBST obj = new InsertNodeBST();
		TreeNode newRoot = obj.insert(root, new TreeNode(5));
		PreOrderTraversal.traverse(newRoot);
	}
}
