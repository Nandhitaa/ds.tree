package general;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;

import ds.TreeNode;

public class BurnBinaryTree {

	private void getParentNodes(TreeNode root, HashMap<TreeNode, TreeNode> parentMap) {
		if (root == null)
			return;
		Queue<TreeNode> queue = new LinkedList<TreeNode>();
		queue.add(root);
		while (!queue.isEmpty()) {
			TreeNode node = queue.poll();
			if (node.left != null) {
				queue.add(node.left);
				parentMap.put(node.left, node);
			}
			if (node.right != null) {
				queue.add(node.right);
				parentMap.put(node.right, node);
			}
		}
	}

	private int burnTime(TreeNode root, TreeNode start) {
		int timeTaken = 0;
		HashMap<TreeNode, TreeNode> parentMap = new HashMap<TreeNode, TreeNode>();
		getParentNodes(root, parentMap);
		HashSet<TreeNode> visited = new HashSet<TreeNode>();
		Queue<TreeNode> queue = new LinkedList<TreeNode>();
		queue.add(start);
		while (!queue.isEmpty()) {
			int size = queue.size();
			boolean burnt = false;
			for (int index = 0; index < size; index++) {
				TreeNode node = queue.poll();
				if (node.left != null && visited.add(node.left)) {
					queue.add(node.left);
					burnt = true;
				}
				if (node.right != null && visited.add(node.right)) {
					queue.add(node.right);
					burnt = true;
				}
				if (parentMap.containsKey(node) && visited.add(parentMap.get(node))) {
					queue.add(parentMap.get(node));
					burnt = true;
				}
			}
			if (burnt) {
				timeTaken++;
			}
		}
		return timeTaken;
	}

	public static void main(String[] args) {
		TreeNode root = new TreeNode(1);

		TreeNode node2 = new TreeNode(2);
		TreeNode node3 = new TreeNode(3);
		TreeNode node4 = new TreeNode(4);
		TreeNode node5 = new TreeNode(5);
		TreeNode node6 = new TreeNode(6);
		TreeNode node7 = new TreeNode(7);
		TreeNode node8 = new TreeNode(8);
		TreeNode node9 = new TreeNode(9);

		root.left = node2;
		root.right = node3;
		node2.left = node4;
		node2.right = node5;
		node3.left = node6;
		node3.right = node7;
		node5.left = node8;
		node5.right = node9;

		BurnBinaryTree obj = new BurnBinaryTree();
		int timeTaken = obj.burnTime(root, node2);
		System.out.println(timeTaken);

	}

}
