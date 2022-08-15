package ds;

public class Tuple {

	public TreeNode node;
	public int verticalLevel;
	public int horizontalLevel;

	public Tuple(TreeNode node, int vLevel, int hLevel) {
		this.node = node;
		this.verticalLevel = vLevel;
		this.horizontalLevel = hLevel;
	}
}
