package bst;

import java.util.Stack;

import ds.TreeNode;

class TwoSumBST {

	private Stack<TreeNode> forwardStack;
	private Stack<TreeNode> backwardStack;

	TwoSumBST(TreeNode root) {
		forwardStack = new Stack<TreeNode>();
		backwardStack = new Stack<TreeNode>();
		pushAllLeft(root);
		pushAllRight(root);
	}

	private void pushAllLeft(TreeNode node) {
		while (node != null) {
			forwardStack.push(node);
			node = node.left;
		}
	}

	private void pushAllRight(TreeNode node) {
		while (node != null) {
			backwardStack.push(node);
			node = node.right;
		}
	}

	private int next() {
		TreeNode node = forwardStack.pop();
		if (node.right != null) {
			pushAllLeft(node.right);
		}
		return node.val;
	}

	private int prev() {
		TreeNode node = backwardStack.pop();
		if (node.right != null) {
			pushAllRight(node.left);
		}
		return node.val;
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

		TwoSumBST obj = new TwoSumBST(root);
		int sum = 16;
		int left = obj.next();
		int right = obj.prev();
		while (left < right) {
			if (left + right == sum) {
				System.out.println(left + " " + right);
				break;
			}
			else if (left + right < sum) {
				left = obj.next();
			}
			else if (left + right > sum) {
				right = obj.prev();
			}
		}
	}

}
