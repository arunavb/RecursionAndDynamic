package binaryTree;

import java.util.List;

public class MergeBST 
{
	private BinarySearchTree tree1;
	private BinarySearchTree tree2;
	public MergeBST()
	{
		
	}
	
	public BinarySearchTree merge(BinarySearchTree b1,BinarySearchTree b2)
	{
		int count1=b1.getCount();
		int count2=b2.getCount();
		if(count1>count2)
		{
			addToTree(b1,b2);
			return b1;
		}
		else
		{
			addToTree(b2,b1);
			return b2;
		}
	}

	private void addToTree(BinarySearchTree b2, BinarySearchTree b1) 
	{
//		List<Node> listOfNodes=b1.getInOrderNodes();
//		for(Node n:listOfNodes)
//		{
//			b2.insert(n.getValue());
//		}
	}
}
