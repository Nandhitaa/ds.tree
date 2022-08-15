package traversal;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

import ds.Pair;
import ds.TreeNode;

public class AllTraversal {

	public static void traverseInternal(TreeNode root, List<Integer> pre, List<Integer> in, List<Integer> post) {
		if (root == null) {
			return;
		}
		Stack<Pair> stack = new Stack<Pair>();
		stack.push(new Pair(root, 1));

		while (!stack.isEmpty()) {
			Pair pair = stack.pop();
			if (pair.verticalLevel == 1) {
				pre.add(pair.node.val);
				stack.push(new Pair(pair.node, pair.verticalLevel + 1));
				if (pair.node.left != null) {
					stack.push(new Pair(pair.node.left, 1));
				}
			}
			else if (pair.verticalLevel == 2) {
				in.add(pair.node.val);
				stack.push(new Pair(pair.node, pair.verticalLevel + 1));
				if (pair.node.left != null) {
					stack.push(new Pair(pair.node.right, 1));
				}
			}
			else {
				post.add(pair.node.val);
			}
		}
	}

	public static void traverse(TreeNode root) {
		List<Integer> pre = new ArrayList<Integer>();
		List<Integer> in = new ArrayList<Integer>();
		List<Integer> post = new ArrayList<Integer>();
		traverseInternal(root, pre, in, post);
		System.out.println(pre);
		System.out.println(in);
		System.out.println(post);
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

		traverse(root);
	}
}
