package conversions;

import java.util.HashMap;

import ds.TreeNode;
import traversal.PostOrderTraversal;

public class BinaryTreeFromInPostOrder {

	private TreeNode construct(int[] inOrder, int iStart, int iEnd, int[] postOrder, int pStart, int pEnd,
			HashMap<Integer, Integer> inMap) {
		if (pStart > pEnd || iStart > iEnd)
			return null;

		TreeNode root = new TreeNode(postOrder[pEnd]);

		int iRoot = inMap.get(postOrder[pEnd]);
		int numOfElements = iRoot - iStart;

		root.left = construct(inOrder, iStart, iRoot - 1, postOrder, pStart, pStart + numOfElements - 1, inMap);
		root.right = construct(inOrder, iRoot + 1, iEnd, postOrder, pStart + numOfElements, pEnd - 1, inMap);

		return root;
	}

	public static void main(String[] args) {
		int[] inOrder = { 40, 20, 50, 10, 60, 30 };
		int[] postOrder = { 40, 50, 20, 60, 30, 10 };

		HashMap<Integer, Integer> inMap = new HashMap<Integer, Integer>();

		for (int index = 0; index < inOrder.length; index++) {
			inMap.put(inOrder[index], index);
		}

		BinaryTreeFromInPostOrder obj = new BinaryTreeFromInPostOrder();

		TreeNode root = obj.construct(inOrder, 0, inOrder.length - 1, postOrder, 0, postOrder.length - 1, inMap);

		PostOrderTraversal.traverse(root);

	}
}
