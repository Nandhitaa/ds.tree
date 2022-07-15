package conversions;

import ds.TreeNode;
import traversal.PreOrderTraversal;

public class ChildrenSum {

	public void makeChildrenSum(TreeNode root) {
		if(root==null) return;
		
		if(root.left == null && root.right == null) return;
		
		int sum =0;
		if(root.left != null) {
			sum += root.left.val;
		}
		if(root.right != null) {
			sum+= root.right.val;
		}
		
		if(sum <= root.val) {
			if(root.left != null) {
				root.left.val = root.val;
			}
			if(root.right != null) {
				root.right.val = root.val;
			}
		}
		else {
			root.val = sum;
		}
		
		makeChildrenSum(root.left);
		makeChildrenSum(root.right);
		
		int total = 0;
		if(root.left != null) {
			total += root.left.val;
		}
		if(root.right != null) {
			total += root.right.val;
		}
		if(total > root.val) {
			root.val = total;
		}
	}
	
	public static void main(String[] args) {
		TreeNode root = new TreeNode(40);
		TreeNode node2 = new TreeNode(10);
		TreeNode node3 = new TreeNode(20);
		TreeNode node4 = new TreeNode(2);
		TreeNode node5 = new TreeNode(5);
		TreeNode node6 = new TreeNode(30);
		TreeNode node7 = new TreeNode(40);

		root.left = node2;
		root.right = node3;
		node2.left = node4;
		node2.right = node5;
		node3.left = node6;
		node3.right = node7;
		
		ChildrenSum obj = new ChildrenSum();
		PreOrderTraversal.traverse(root);
		obj.makeChildrenSum(root);
		PreOrderTraversal.traverse(root);
	}

}
