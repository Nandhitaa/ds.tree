package bst;

import ds.TreeNode;

public class SearchBST {

	private TreeNode search(TreeNode node, int value) {
		while (node != null && node.val != value) {
			node = value < node.val ? node.left : node.right;
		}
		return node;
	}

	public static void main(String[] args) {
		TreeNode root = new TreeNode(10);

		TreeNode node2 = new TreeNode(2);
		TreeNode node3 = new TreeNode(3);
		TreeNode node4 = new TreeNode(4);
		TreeNode node15 = new TreeNode(15);
		TreeNode node16 = new TreeNode(16);
		TreeNode node17 = new TreeNode(17);

		root.left = node3;
		root.right = node16;
		node3.left = node2;
		node3.right = node4;
		node16.left = node15;
		node16.right = node17;

		SearchBST obj = new SearchBST();
		TreeNode elem = obj.search(root, 18);
		System.out.println(elem == null ? elem : elem.val);
	}
}
