package bst;

import ds.TreeNode;

public class FloorBST {

	private int findFloor(TreeNode node, int key) {

		int floor = -1;

		while (node != null) {
			if (node.val == key) {
				return node.val;
			}
			if (node.val > key) {
				node = node.left;
			}
			else {
				floor = node.val;
				node = node.right;
			}
		}

		return floor;
	}

	public static void main(String[] args) {
		TreeNode root = new TreeNode(10);

		TreeNode node5 = new TreeNode(5);
		TreeNode node15 = new TreeNode(15);
		TreeNode node2 = new TreeNode(2);
		TreeNode node8 = new TreeNode(8);
		TreeNode node6 = new TreeNode(6);
		TreeNode node13 = new TreeNode(13);
		TreeNode node17 = new TreeNode(17);

		root.left = node5;
		root.right = node15;
		node5.left = node2;
		node5.right = node8;
		node8.left = node6;
		node15.left = node13;
		node15.right = node17;

		FloorBST obj = new FloorBST();
		int floor = obj.findFloor(root, 9);
		System.out.println(floor);
	}
}
