package traversal;

import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.TreeMap;

import ds.TreeNode;
import ds.Tuple;

public class VerticalOrderTraversal {

	public static void traverse(TreeNode root) {
		if (root == null)
			return;
		TreeMap<Integer, TreeMap<Integer, PriorityQueue<Integer>>> map = new TreeMap<>();
		Queue<Tuple> queue = new LinkedList<Tuple>();
		queue.add(new Tuple(root, 0, 0));

		while (!queue.isEmpty()) {
			Tuple tuple = queue.poll();
			TreeNode node = tuple.node;
			int vLevel = tuple.verticalLevel;
			int hLevel = tuple.horizontalLevel;

			map.put(vLevel, map.getOrDefault(vLevel, new TreeMap<Integer, PriorityQueue<Integer>>()));
			PriorityQueue<Integer> pqElement = map.get(vLevel).getOrDefault(hLevel, new PriorityQueue<Integer>());
			pqElement.add(node.val);
			map.get(vLevel).put(hLevel, pqElement);

			if (node.left != null) {
				queue.add(new Tuple(node.left, vLevel - 1, hLevel + 1));
			}
			if (node.right != null) {
				queue.add(new Tuple(node.right, vLevel + 1, hLevel + 1));
			}
		}

		for (TreeMap<Integer, PriorityQueue<Integer>> entry : map.values()) {
			for (PriorityQueue<Integer> values : entry.values()) {
				while (!values.isEmpty()) {
					System.out.print(values.poll() + "->");
				}
			}
		}
		System.out.println();
	}

	public static void main(String[] args) {
		TreeNode root = new TreeNode(5);

		TreeNode node2 = new TreeNode(2);
		TreeNode node3 = new TreeNode(3);
		TreeNode node4 = new TreeNode(4);
		TreeNode node6 = new TreeNode(6);
		TreeNode node1 = new TreeNode(1);
		TreeNode node7 = new TreeNode(7);

		root.left = node2;
		root.right = node3;
		node2.left = node4;
		node2.right = node6;
		node3.left = node1;
		node3.right = node7;

		traverse(root);
	}
}
