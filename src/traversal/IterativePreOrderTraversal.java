package traversal;

import java.util.Stack;

import ds.TreeNode;

public class IterativePreOrderTraversal {

	public static void traverse(TreeNode root) {
		Stack<TreeNode> stack = new Stack<TreeNode>();

		if (root == null) {
			return;
		}

		stack.push(root);

		while (!stack.isEmpty()) {
			TreeNode node = stack.pop();

			System.out.print(node.val + "->");

			if (node.right != null) {
				stack.push(node.right);
			}
			if (node.left != null) {
				stack.push(node.left);
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
