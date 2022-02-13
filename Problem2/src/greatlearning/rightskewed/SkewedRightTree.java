package com.greatlearning.rightskewed;
import com.greatlearning.nodeclass.Node;


public class SkewedRightTree
{
	
	//Node tree = new Node();
	public static Node node;
    public Node prevNode = null;
    public Node headNode = null;
	public void flattenSkewedTree(Node root, int order)
	{
		// Base Case
		if(root == null)
		{
			return;
		}
		// Condition to check the order in which the skewed tree to maintained
		if(order > 0)
		{
			flattenSkewedTree(root.right, order);
		}
		else
		{
			flattenSkewedTree(root.left, order);
		}
		Node rightNode = root.right;
		Node leftNode = root.left;
		// Condition to check if the root Node of the skewed tree is not defined
		if(headNode == null)
		{
			headNode = root;
			root.left = null;
			prevNode = root;
		}
		else
		{
			prevNode.right = root;
			root.left = null;
			prevNode = root;
		}

		// Similarly recurse for the left / right subtree on the basis of the order required
		if (order > 0)
		{
			flattenSkewedTree(leftNode, order);
		}
		else
		{
			flattenSkewedTree(rightNode, order);
		}
		
	}
	// Function to traverse the right skewed tree using recursion
	public void traverseRightSkewed(Node root)
	{
		if(root == null)
		{
			return;
		}
		System.out.print(root.val + " ");
		traverseRightSkewed(root.right);
	}

	
}
