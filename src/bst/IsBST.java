package bst;

import ds.TreeNode;

public class IsBST {

	TreeNode prev = null;
	
	public boolean isBst(TreeNode root) {
		if(root == null) return true;
		if(!isBst(root.left)) return false;
		if(prev != null && prev.val >= root.val) return false;
		prev = root;
		return isBst(root.right);
	}
	
	public static void main(String[] args) {
		TreeNode root = new TreeNode(10);
		TreeNode node2 = new TreeNode(5);
		TreeNode node3 = new TreeNode(15);
		TreeNode node4 = new TreeNode(4);
		TreeNode node5 = new TreeNode(6);
		TreeNode node6 = new TreeNode(14);
		TreeNode node7 = new TreeNode(16);

		root.left = node2;
		root.right = node3;
		node2.left = node4;
		node2.right = node5;
		node3.left = node6;
		node3.right = node7;

		IsBST obj = new IsBST();
		boolean result = obj.isBst(root);
		System.out.println(result);
	}

}
