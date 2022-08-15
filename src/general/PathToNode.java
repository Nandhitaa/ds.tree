package general;

import java.util.ArrayList;
import java.util.List;

import ds.TreeNode;

public class PathToNode {

	private boolean getPath(TreeNode node, int val, List<Integer> path) {
		if (node == null) {
			return false;
		}
		path.add(node.val);
		if (node.val == val) {
			return true;
		}

		if (getPath(node.left, val, path)) {
			return true;
		}
		if (getPath(node.right, val, path)) {
			return true;
		}
		path.remove(path.size() - 1);
		return false;
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

		PathToNode obj = new PathToNode();
		List<Integer> path = new ArrayList<Integer>();
		obj.getPath(root, 7, path);
		System.out.println(path);
	}
}
