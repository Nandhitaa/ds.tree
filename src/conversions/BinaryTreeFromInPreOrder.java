package conversions;

import java.util.HashMap;

import ds.TreeNode;
import traversal.PreOrderTraversal;

public class BinaryTreeFromInPreOrder {

	private TreeNode construct(int[] inOrder, int iStart, int iEnd, int[] preOrder, int pStart, int pEnd,
			HashMap<Integer, Integer> inMap) {
		if (pStart > pEnd || iStart > iEnd)
			return null;

		TreeNode root = new TreeNode(preOrder[pStart]);

		int iRoot = inMap.get(preOrder[pStart]);
		int numOfElements = iRoot - iStart;

		root.left = construct(inOrder, iStart, iRoot - 1, preOrder, pStart + 1, pStart + numOfElements, inMap);
		root.right = construct(inOrder, iRoot + 1, iEnd, preOrder, pStart + numOfElements + 1, pEnd, inMap);

		return root;
	}

	public static void main(String[] args) {
		int[] inOrder = { 9, 3, 15, 20, 7 };
		int[] preOrder = { 3, 9, 20, 15, 7 };

		HashMap<Integer, Integer> inMap = new HashMap<Integer, Integer>();

		for (int index = 0; index < inOrder.length; index++) {
			inMap.put(inOrder[index], index);
		}

		BinaryTreeFromInPreOrder obj = new BinaryTreeFromInPreOrder();

		TreeNode root = obj.construct(inOrder, 0, inOrder.length - 1, preOrder, 0, preOrder.length - 1, inMap);

		PreOrderTraversal.traverse(root);

	}
}
