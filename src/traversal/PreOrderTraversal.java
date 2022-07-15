package traversal;

import ds.TreeNode;

public class PreOrderTraversal {

	public static void traverseInternal(TreeNode root) {
		if(root == null) return;
		System.out.print(root.val + "->");
		traverseInternal(root.left);
		traverseInternal(root.right);
	}
	
	public static void traverse(TreeNode root) {
		traverseInternal(root);
		System.out.println();
	}
}
