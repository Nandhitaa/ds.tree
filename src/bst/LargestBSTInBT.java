package bst;

import ds.TreeNode;

class NodeValue {
	public int min;
	public int max;
	public int size;

	NodeValue(int min, int max, int size) {
		this.min = min;
		this.max = max;
		this.size = size;
	}
}

public class LargestBSTInBT {

	private NodeValue getLargestNodeValue(TreeNode node) {
		if (node == null) {
			return new NodeValue(Integer.MAX_VALUE, Integer.MIN_VALUE, 0);
		}

		NodeValue left = getLargestNodeValue(node.left);
		NodeValue right = getLargestNodeValue(node.right);

		if (left.max < node.val && right.min > node.val) {
			return new NodeValue(Math.min(node.val, left.min), Math.max(node.val, right.max),
					1 + left.size + right.size);
		}

		return new NodeValue(Integer.MIN_VALUE, Integer.MAX_VALUE, Math.max(left.size, right.size));

	}

	private int getLargest(TreeNode root) {
		return getLargestNodeValue(root).size;
	}

	public static void main(String[] args) {

		TreeNode root = new TreeNode(20);

		TreeNode node15 = new TreeNode(15);
		TreeNode node40 = new TreeNode(40);
		TreeNode node14 = new TreeNode(14);
		TreeNode node18 = new TreeNode(18);
		TreeNode node17 = new TreeNode(17);
		TreeNode node16 = new TreeNode(16);
		TreeNode node19 = new TreeNode(19);
		TreeNode node50 = new TreeNode(50);
		TreeNode node30 = new TreeNode(30);
		TreeNode node60 = new TreeNode(60);

		root.left = node15;
		root.right = node40;
		node15.left = node14;
		node15.right = node18;
		node14.right = node17;
		node18.left = node16;
		node18.right = node19;
		node40.left = node30;
		node40.right = node60;
		node60.left = node50;

		LargestBSTInBT obj = new LargestBSTInBT();
		int result = obj.getLargest(root);
		System.out.println(result);
	}
}
