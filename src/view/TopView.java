package view;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.TreeMap;

import ds.Pair;
import ds.TreeNode;

public class TopView {

	public List<Integer> getTopView(TreeNode root) {
		List<Integer> ans = new ArrayList<Integer>();
		Queue<Pair> queue = new LinkedList<Pair>();
		TreeMap<Integer, Integer> map = new TreeMap<Integer, Integer>();

		if (root != null) {
			queue.add(new Pair(root, 0));
		}

		while (!queue.isEmpty()) {
			Pair element = queue.poll();
			int level = element.verticalLevel;
			TreeNode node = element.node;

			if (!map.containsKey(level)) {
				map.put(level, node.val);
			}

			if (node.left != null) {
				queue.add(new Pair(node.left, level - 1));
			}

			if (node.right != null) {
				queue.add(new Pair(node.right, level + 1));
			}
		}

		for (Map.Entry<Integer, Integer> ele : map.entrySet()) {
			ans.add(ele.getValue());
		}
		return ans;
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
		node5.left = node6;
		node3.right = node7;

		TopView obj = new TopView();
		List<Integer> result = obj.getTopView(root);
		System.out.println(result);
	}

}
