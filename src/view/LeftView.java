package view;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import ds.TreeNode;

public class LeftView {

	public List<Integer> getLeftView(TreeNode root) {
		List<Integer> ans = new ArrayList<Integer>();
		Queue<TreeNode> queue = new LinkedList<TreeNode>();

		if (root != null) {
			queue.add(root);
		}

		while (!queue.isEmpty()) {

			int size = queue.size();

			for (int i = 0; i < size; i++) {
				TreeNode node = queue.poll();

				if (i == 0) {
					ans.add(node.val);
				}

				if (node.left != null) {
					queue.add(node.left);
				}

				if (node.right != null) {
					queue.add(node.right);
				}
			}

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

		LeftView obj = new LeftView();
		List<Integer> result = obj.getLeftView(root);
		System.out.println(result);
	}

}
