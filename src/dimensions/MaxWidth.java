package dimensions;

import java.util.LinkedList;
import java.util.Queue;

import ds.Pair;
import ds.TreeNode;

public class MaxWidth {

	private int getMaxWidth(TreeNode root) {
		if (root == null)
			return 0;
		Queue<Pair> queue = new LinkedList<Pair>();
		queue.add(new Pair(root, 0));
		int max = 0;
		while (!queue.isEmpty()) {
			int size = queue.size();
			int first = 0;
			int last = 0;
			int min = queue.peek().verticalLevel;
			for (int index = 0; index < size; index++) {
				Pair pair = queue.poll();
				TreeNode node = pair.node;
				int id = pair.verticalLevel - min;
				if (index == 0)
					first = id;
				if (index == size - 1)
					last = id;
				if (node.left != null) {
					queue.add(new Pair(node.left, 2 * id + 1));
				}
				if (node.right != null) {
					queue.add(new Pair(node.right, 2 * id + 2));
				}
			}
			max = Math.max(max, last - first + 1);
		}
		return max;
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

		MaxWidth obj = new MaxWidth();
		int result = obj.getMaxWidth(root);
		System.out.println(result);
	}
}
