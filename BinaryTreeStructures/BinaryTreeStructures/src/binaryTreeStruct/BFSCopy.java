package binaryTreeStruct;


import java.util.*;

public class BFSCopy 
{
	BinaryTree<Integer> bt;
	List<Node<Integer>> BFSQueue=new ArrayList<Node<Integer>>();
	public BFSCopy(BinaryTree<Integer> inputTree)
	{
		this.bt=inputTree;
	}
	public BinaryTree<Integer> returnCopiedTree()
	{
		BinaryTree<Integer> btree=new BinaryTree<Integer>();
		BFSQueue.add(bt.getRoot());
		traverseBFS(btree,BFSQueue,-1);
		return btree;
	}
	private void traverseBFS(BinaryTree<Integer> returnTree,List<Node<Integer>> queue,int parentValue)
	{
		if(queue.size()==0)
		{
			return;
		}
		else
		{
			Node<Integer> currentNode=queue.remove(0);
			if(currentNode.getLeftChild()!=null)
			{
				
			}
		}
	}
	public static void main(String args[])
	{
		BinaryTree<Integer> BinaryTree=new BinaryTree<Integer>();
//		BinaryTree.insert(7);
//		BinaryTree.insertLeft(7, 3);
//		BinaryTree.insertRight(7, 10);
//		BinaryTree.insertLeft(3, 11);
//		BinaryTree.insertRight(3, 16);
//		BinaryTree.insertLeft(11, 2);
//		BinaryTree.insertRight(11, 19);
//		BinaryTree.insertLeft(10, 67);
//		BinaryTree.insertRight(10, 63);
//		BinaryTree.insertLeft(16, 31);
//		BinaryTree.insertRight(16, 33);
//		BinaryTree.insertLeft(2, 51);
//		BinaryTree.insertRight(2, 52);
//		BFSCopy bfs=new BFSCopy(BinaryTree);
	}
}
