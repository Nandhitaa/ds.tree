package dimensions;

import ds.TreeNode;

public class Diameter {

	private int diameter;

	public int getDiameter() {
		return this.diameter;
	}

	public int setDiameterInternal(TreeNode root) {
		if (root == null) {
			return 0;
		}

		int leftHeight = setDiameterInternal(root.left);
		int rightHeight = setDiameterInternal(root.right);
		
		this.diameter = Math.max(this.diameter, leftHeight + rightHeight);
		
		return 1 + Math.max(leftHeight, rightHeight);
	}

	public void setDiamater(TreeNode root) {
		setDiameterInternal(root);
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
		node3.left = node4;
		node3.right = node6;
		node4.left = node5;
		node5.right = node9;
		node6.right = node7;
		node7.right = node8;

		Diameter obj = new Diameter();
		obj.setDiamater(root);
		System.out.println(obj.getDiameter());
	}
}
