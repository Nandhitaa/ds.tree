package traversal;

import java.util.ArrayList;
import java.util.List;

import ds.TreeNode;

public class BoundaryTraversal {

	private boolean isLeaf(TreeNode node) {
		return node != null && node.left == null && node.right == null;
	}

	private void addLeftBoundaries(TreeNode root, List<Integer> nodes) {
		TreeNode currentNode = root.left;
		while (currentNode != null) {
			if (!isLeaf(currentNode)) {
				nodes.add(currentNode.val);
			}
			if (currentNode.left != null) {
				currentNode = currentNode.left;
			}
			else {
				currentNode = currentNode.right;
			}
		}
	}

	private void addLeaves(TreeNode root, List<Integer> nodes) {
		if (root == null) {
			return;
		}
		if (isLeaf(root)) {
			nodes.add(root.val);
		}
		addLeaves(root.left, nodes);
		addLeaves(root.right, nodes);
	}

	private void addRightBoundaries(TreeNode root, List<Integer> nodes) {
		List<Integer> tempNodes = new ArrayList<Integer>();
		TreeNode currentNode = root.right;
		while (currentNode != null) {
			if (!isLeaf(currentNode)) {
				tempNodes.add(currentNode.val);
			}
			if (currentNode.right != null) {
				currentNode = currentNode.right;
			}
			else {
				currentNode = currentNode.left;
			}
		}
		for (int index = tempNodes.size() - 1; index >= 0; index--) {
			nodes.add(tempNodes.get(index));
		}
	}

	private void traverse(TreeNode root) {
		List<Integer> nodes = new ArrayList<Integer>();
		if(root == null) {
			return;
		}
		if(!isLeaf(root)) {
			nodes.add(root.val);
		}
		addLeftBoundaries(root, nodes);
		addLeaves(root, nodes);
		addRightBoundaries(root, nodes);
		System.out.println(nodes);
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
		TreeNode node10 = new TreeNode(10);
		TreeNode node11 = new TreeNode(11);
		TreeNode node12 = new TreeNode(12);
		TreeNode node13 = new TreeNode(13);
		TreeNode node14 = new TreeNode(14);
		TreeNode node15 = new TreeNode(15);

		root.left = node2;
		root.right = node3;
		node2.left = node4;
		node2.right = node5;
		node3.left = node6;
		node3.right = node7;
		node4.left = node8;
		node4.right = node9;
		node5.left = node10;
		node5.right = node11;
		node6.left = node12;
		node6.right = node13;
		node7.left = node14;
		node7.right = node15;

		BoundaryTraversal obj = new BoundaryTraversal();

		obj.traverse(root);
	}
}
