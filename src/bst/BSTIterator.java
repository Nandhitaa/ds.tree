package bst;

import java.util.Stack;

import ds.TreeNode;

public class BSTIterator {

	private Stack<TreeNode> stack;

	BSTIterator(TreeNode root) {
		stack = new Stack<TreeNode>();
		pushAllLeft(root);
	}

	private int next() {
		TreeNode node = stack.pop();
		if (node.right != null) {
			pushAllLeft(node.right);
		}
		return node.val;
	}

	private boolean hasNext() {
		return !stack.isEmpty();
	}

	private void pushAllLeft(TreeNode node) {
		while (node != null) {
			stack.push(node);
			node = node.left;
		}
	}

	public static void main(String[] args) {

		TreeNode root = new TreeNode(7);

		TreeNode node3 = new TreeNode(3);
		TreeNode node6 = new TreeNode(6);
		TreeNode node2 = new TreeNode(2);
		TreeNode node1 = new TreeNode(1);
		TreeNode node5 = new TreeNode(5);
		TreeNode node4 = new TreeNode(4);
		TreeNode node10 = new TreeNode(10);
		TreeNode node9 = new TreeNode(9);
		TreeNode node8 = new TreeNode(8);
		TreeNode node11 = new TreeNode(11);

		root.left = node3;
		root.right = node10;
		node3.left = node2;
		node2.left = node1;
		node3.right = node6;
		node6.left = node5;
		node5.left = node4;
		node10.left = node9;
		node9.left = node8;
		node10.right = node11;

		BSTIterator obj = new BSTIterator(root);
		System.out.println(obj.hasNext());
		for (int i = 0; i < 11; i++) {
			System.out.println(obj.next());
		}
		System.out.println(obj.hasNext());
	}
}
