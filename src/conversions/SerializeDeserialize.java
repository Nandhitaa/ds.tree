package conversions;

import java.util.LinkedList;
import java.util.Queue;

import ds.TreeNode;
import traversal.PreOrderTraversal;

public class SerializeDeserialize {

	public static String serialize(TreeNode root) {
		if (root == null)
			return "";
		StringBuilder result = new StringBuilder();
		Queue<TreeNode> queue = new LinkedList<TreeNode>();
		queue.add(root);
		while (!queue.isEmpty()) {
			TreeNode node = queue.poll();
			if (node == null) {
				result.append("#,");
				continue;
			}
			result.append(node.val + ",");
			queue.add(node.left);
			queue.add(node.right);
		}
		return result.toString();
	}

	public static TreeNode deserialize(String input) {
		if (input == null || input == "")
			return null;
		String[] data = input.split(",");
		Queue<TreeNode> queue = new LinkedList<TreeNode>();
		TreeNode parent = new TreeNode(Integer.valueOf(data[0]));
		queue.add(parent);
		for (int index = 1; index < data.length; index++) {
			TreeNode node = queue.poll();
			if (!data[index].equals("#")) {
				node.left = new TreeNode(Integer.valueOf(data[index]));
				queue.add(node.left);
			}
			if (!data[++index].equals("#")) {
				node.right = new TreeNode(Integer.valueOf(data[index]));
				queue.add(node.right);
			}
		}
		return parent;
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

		String serialized = serialize(root);
		System.out.println(serialized);
		TreeNode deserialized = deserialize(serialized);
		PreOrderTraversal.traverse(deserialized);
	}
}
