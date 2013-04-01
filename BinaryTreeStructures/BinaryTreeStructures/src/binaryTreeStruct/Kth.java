package binaryTreeStruct;
import java.util.*;
public class Kth 
{
	BinarySearchTree tree;
	public Kth(List<Integer> list)
	{
		tree=new BinarySearchTree();
		for(int i:list)
		{
			tree.insert(i);
		}
	}
	public List<Node> print()
	{
		return tree.getInOrderNodes();
	}
	public Node getKth(int k)
	{
		Node returnNode=null;
		return findKth(k,tree.getRoot());
	}
	private Node findKth(int k,Node root)
	{
		if(root==null)
		{
			return null;
		}
		int numberOfSmallerNodes=findNodes(root.getLeftChild());
		if(numberOfSmallerNodes==k-1)
		{
			return root;
		}
		if(numberOfSmallerNodes>k-1)
		{
			return findKth(k,root.getLeftChild());
		}
		else
		{
			return findKth(k-(numberOfSmallerNodes+1),root.getRightChild());
		}
	}
	private int findNodes(Node root)
	{
		if(root==null)
		{
			return 0;
		}
		else
		{
			return (1+findNodes(root.getLeftChild())+findNodes(root.getRightChild()));
		}
	}
	public void printAllSmaller(Node<Integer> root)
	{
		if(root==null)
		{
			return;
		}
		System.out.println("Root : "+root+" Nodes Lesser than :"+findNodes(root.getLeftChild()));
		printAllSmaller(root.getLeftChild());
		printAllSmaller(root.getRightChild());
	}
	public static void main(String args[])
	{
		List<Integer> insertList=new ArrayList<Integer>();
		int count=1;
		Random rand=new Random(System.nanoTime());
		while(count<=10)
		{
			int value=Math.abs(rand.nextInt()%100);
			insertList.add(value);
//			System.out.println("Inserted : "+value);
			count++;			
		}
		Kth k=new Kth(insertList);
		List<Node> nodes=k.print();
		System.out.println("List");
		for(Node n:nodes)
		{
			System.out.print(n+"   ");
		}
		System.out.println("5th Element: ");
		System.out.println(k.getKth(5));
	}
	
}
