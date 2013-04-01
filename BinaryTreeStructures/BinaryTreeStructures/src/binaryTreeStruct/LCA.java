package binaryTreeStruct;

public class LCA 
{
	private BinaryTree tree;
	public LCA(BinaryTree btree)
	{
		this.tree=btree;
	}
	public Node<Integer> highestAncestor(int n1,int n2)
	{
		return null;
//		Node<Integer> firstNode=tree.findNode(n1);
//		Node<Integer> secondNode=tree.findNode(n2);
//		System.out.println("Depth of FirstNode: "+returnDepth(firstNode,tree.getRoot(),0));
//		System.out.println("Depth of SecondNode: "+returnDepth(secondNode,tree.getRoot(),0));
//		return null;
	}
	private int returnDepth(Node<Integer> node,Node<Integer> temp,int depth)
	{
		if(temp==null)
		{
			return 0;
		}
		if(node==temp)
		{
			return depth;
		}
		else
		{
			return returnDepth(node,temp.getLeftChild(),depth+1)+returnDepth(node,temp.getRightChild(),depth+1);
		}
	}
	public static void main(String args[])
	{
		BinaryTree<Integer> bt=new BinaryTree();
		bt.insert(7);
//		bt.insertLeft(7, 5);
//		bt.insertLeft(5, 13);
//		bt.insertLeft(13, 37);
//		bt.insertLeft(37, 61);
//		bt.insertRight(37, 72);
//		bt.insertRight(13, 41);
//		bt.insertRight(5, 17);
//		bt.insertLeft(17, 21);
//		bt.insertLeft(21, 23);
//		bt.insertRight(21, 39);
//		bt.insertRight(17, 19);
//		bt.insertRight(7, 9);
//		bt.insertLeft(9, 1);
//		bt.insertRight(9, 2);
//		LCA lca=new LCA(bt);
//		lca.highestAncestor(39, 7);
	}
}
