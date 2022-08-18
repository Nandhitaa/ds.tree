package general;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import ds.TreeNode;

public class KDistanceNodes {

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

	private void getKDistnaceNodes(TreeNode root, TreeNode targetNode, List<Integer> result, int k) {
		if (root == null)
			return;
		HashMap<TreeNode, TreeNode> parentMap = new HashMap<TreeNode, TreeNode>();
		getParentNodes(root, parentMap);
		HashSet<TreeNode> visited = new HashSet<TreeNode>();
		Queue<TreeNode> queue = new LinkedList<TreeNode>();
		queue.add(targetNode);
		visited.add(targetNode);
		int level = 0;
		while (!queue.isEmpty()) {
			if (level == k)
				break;
			level++;
			int size = queue.size();
			for (int index = 0; index < size; index++) {
				TreeNode node = queue.poll();
				if (node.left != null && visited.add(node.left)) {
					queue.add(node.left);
				}
				if (node.right != null && visited.add(node.right)) {
					queue.add(node.right);
				}
				if (parentMap.containsKey(node) && visited.add(parentMap.get(node))) {
					queue.add(parentMap.get(node));
				}
			}
		}
		while (!queue.isEmpty()) {
			result.add(queue.poll().val);
		}
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

		int k = 2;

		KDistanceNodes obj = new KDistanceNodes();
		List<Integer> result = new ArrayList<Integer>();
		obj.getKDistnaceNodes(root, node2, result, k);
		System.out.println(result);
	}
}
