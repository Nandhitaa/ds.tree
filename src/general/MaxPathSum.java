package general;

import ds.TreeNode;

public class MaxPathSum {

	public int getmaxPathSum(TreeNode node, int[] sum) {
		if (node == null) {
			return 0;
		}

		int leftSum = Math.max(0, getmaxPathSum(node.left, sum));
		int rightSum = Math.max(0, getmaxPathSum(node.right, sum));

		sum[0] = Math.max(sum[0], node.val + leftSum + rightSum);

		return node.val + Math.max(leftSum, rightSum);

	}

	public static void main(String[] args) {
		MaxPathSum obj = new MaxPathSum();

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

		int[] sum = new int[1];
		sum[0] = Integer.MIN_VALUE;
		obj.getmaxPathSum(root, sum);
		System.out.println(sum[0]);
	}
}
