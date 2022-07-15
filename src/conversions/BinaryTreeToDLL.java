package conversions;

import ds.TreeNode;
import traversal.PreOrderTraversal;

public class BinaryTreeToDLL {

	TreeNode prev = null;
	static TreeNode head = null;

	public void binaryTreeToDll(TreeNode root) {
		if (root == null)
			return;

		binaryTreeToDll(root.left);

		if (prev == null) {
			head = root;
		} else {
			prev.right = root;
			root.left = prev;
		}
		prev = root;

		binaryTreeToDll(root.right);

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
		
		BinaryTreeToDLL obj = new BinaryTreeToDLL();
		PreOrderTraversal.traverse(root);
		obj.binaryTreeToDll(root);
		TreeNode curr = head;
		while(curr != null) {
			System.out.print(curr.val + "->");
			curr = curr.right;
		}
	}
	
}
