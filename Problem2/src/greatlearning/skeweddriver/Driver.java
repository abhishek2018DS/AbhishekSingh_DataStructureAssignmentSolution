package greatlearning.skeweddriver;
import greatlearning.rightscrew.SkewedRightTree;
import greatlearning.node.Node;


public class Driver {
	public static Node node;

	public static void main(String[] args) {
		SkewedRightTree tree = new SkewedRightTree();
		tree.node = new Node(50);
		tree.node.left = new Node(30);
		tree.node.right = new Node(60);
		tree.node.left.left = new Node(10);
		tree.node.left.right = new Node(40);

		tree.convertBSTToSkewedTree(tree.node);
		tree.traverseTree(tree.headNode);

	}
}
