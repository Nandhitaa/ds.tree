package general;

import ds.TreeNode;

public class IsSymmetric {

	private boolean isSymmetric(TreeNode left, TreeNode right) {
		if (left == null || right == null) {
			return left == right;
		}
		if (left.val != right.val) {
			return false;
		}

		return isSymmetric(left.left, right.right) && isSymmetric(left.right, right.left);
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

		IsSymmetric obj = new IsSymmetric();

		boolean result = obj.isSymmetric(root, root);
		System.out.println(result);
	}
}
