package dimensions;

import ds.TreeNode;

public class Height {

	public int getHeight(TreeNode root) {
		if (root == null)
			return 0;

		int leftHeight = getHeight(root.left);
		int rightHeight = getHeight(root.right);

		return 1 + Math.max(leftHeight, rightHeight);
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

		Height obj = new Height();
		int result = obj.getHeight(root);
		System.out.println(result);
	}

}
