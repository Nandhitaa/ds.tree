package general;

import ds.TreeNode;

public class IdenticalTrees {

	private boolean isIdentical(TreeNode root1, TreeNode root2) {
		if (root1 == null || root2 == null) {
			return root1 == root2;
		}

		return root1.val == root2.val && isIdentical(root1.left, root2.left) && isIdentical(root1.right, root2.right);

	}

	public static void main(String[] args) {
		IdenticalTrees obj = new IdenticalTrees();

		TreeNode root1 = new TreeNode(1);

		TreeNode node2 = new TreeNode(2);
		TreeNode node3 = new TreeNode(3);
		TreeNode node4 = new TreeNode(4);
		TreeNode node5 = new TreeNode(5);
		TreeNode node6 = new TreeNode(6);
		TreeNode node7 = new TreeNode(7);

		root1.left = node2;
		root1.right = node3;
		node2.left = node4;
		node2.right = node5;
		node3.left = node6;
		node3.right = node7;

		TreeNode root2 = new TreeNode(1);
		root2.left = node3;
		root2.right = node2;

		boolean result = obj.isIdentical(root1, root2);
		System.out.println(result);
	}
}
