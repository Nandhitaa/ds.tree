package traversal;

import java.util.LinkedList;
import java.util.Queue;

import ds.TreeNode;

public class LevelOrderTraversal {
	public static void traverse(TreeNode root) {
		Queue<TreeNode> queue = new LinkedList<TreeNode>();

		if (root == null)
			return;

		queue.add(root);

		while (!queue.isEmpty()) {
			TreeNode node = queue.poll();
			System.out.print(node.val + "->");
			if (node.left != null) {
				queue.add(node.left);
			}
			if (node.right != null) {
				queue.add(node.right);
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
