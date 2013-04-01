package binaryTreeStruct; 

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class BinaryTree <T>
{
	private Node root;
	private int largestBST=0;
	public BinaryTree()
	{
	}
	public BinaryTree(T n)
	{
		if(root==null)
		{
			root=new Node(n);
		}
		else
		{
			Node temp=root;
			this.insertNode(temp,n);
		}
	}
	public Node<T>  getRoot()
	{
		return this.root;
	}
	public BinaryTree(List<Node> preOrder,List<Node> postOrder)
	{
		int postOrderIndex=postOrder.size()-1;
		Node rootNode=postOrder.remove(postOrderIndex);
		preOrder.remove(rootNode);
		if(this.root==null)
		{
			root=rootNode;
		}
		Node rightNode=postOrder.get(postOrder.size()-1);
		int indexInPreOrder=returnIndexOf(rightNode,preOrder);
		List<Node> leftPostOrder=new ArrayList<Node>();
		List<Node> rightPostOrder=new ArrayList<Node>();
		List<Node> leftPreOrder=new ArrayList<Node>();
		List<Node> rightPreOrder=new ArrayList<Node>();
		for(int leftIndex=0;leftIndex<indexInPreOrder;leftIndex++)
		{
			leftPreOrder.add(preOrder.remove(0));
		}
		rightPreOrder=preOrder;
		int indexInPostOrder=returnIndexOf(leftPreOrder.get(0),postOrder);
		for(int leftIndex=0;leftIndex<=indexInPostOrder;leftIndex++)
		{
			leftPostOrder.add(postOrder.remove(0));
		}
		rightPostOrder=postOrder;
//		System.out.println("Left Pre Order");
//		printList(leftPreOrder);
//		System.out.println("Left Post Order");
//		printList(leftPostOrder);
//		System.out.println("Right Pre Order");
//		printList(rightPreOrder);
//		System.out.println("Right Post Order");
//		printList(rightPostOrder);
		createTreeLeft(root,leftPreOrder,leftPostOrder);
		createTreeRight(root,rightPreOrder,rightPostOrder);
		
	}
	
	public BinaryTree(List<Node> preOrder)
	{
		root=preOrder.remove(0);
		createBinaryTreeOne(root,preOrder);
	}
	
	private void createBinaryTreeOne(Node root, List<Node> preOrder) 
	{
			if(preOrder.size()==0)
			{
				return;
			}
			root.setLeftChild(preOrder.remove(0));
			createBinaryTreeOne(root.getLeftChild(),preOrder);
	}
	private void createTreeLeft(Node root,List<Node> preOrder,List<Node> postOrder)
	{
		try
		{
			if(postOrder.size()==0)
			{
				return;
			}
			Node rootNode=postOrder.remove(postOrder.size()-1);
			preOrder.remove(rootNode);
			root.setLeftChild(rootNode);
			Node rightNode=postOrder.get(postOrder.size()-1);
			int indexInPreOrder=returnIndexOf(rightNode,preOrder);
			List<Node> leftPostOrder=new ArrayList<Node>();
			List<Node> rightPostOrder=new ArrayList<Node>();
			List<Node> leftPreOrder=new ArrayList<Node>();
			List<Node> rightPreOrder=new ArrayList<Node>();
			for(int leftIndex=0;leftIndex<indexInPreOrder;leftIndex++)
			{
				leftPreOrder.add(preOrder.remove(0));
			}
			rightPreOrder=preOrder;
			int indexInPostOrder=returnIndexOf(leftPreOrder.get(0),postOrder);
			for(int leftIndex=0;leftIndex<=indexInPostOrder;leftIndex++)
			{
				leftPostOrder.add(postOrder.remove(0));
			}
			rightPostOrder=postOrder;
			createTreeLeft(rootNode,leftPreOrder,leftPostOrder);
			createTreeRight(rootNode,rightPreOrder,rightPostOrder);
		}
		catch(IndexOutOfBoundsException e)
		{
			return;
		}
	}
	private void createTreeRight(Node root,List<Node> preOrder,List<Node> postOrder)
	{
		try
		{
			if(postOrder.size()==0)
			{
				return;
			}
			Node rootNode=postOrder.remove(postOrder.size()-1);
			preOrder.remove(rootNode);
			root.setRightChild(rootNode);
			Node rightNode=postOrder.get(postOrder.size()-1);
			int indexInPreOrder=returnIndexOf(rightNode,preOrder);
			List<Node> leftPostOrder=new ArrayList<Node>();
			List<Node> rightPostOrder=new ArrayList<Node>();
			List<Node> leftPreOrder=new ArrayList<Node>();
			List<Node> rightPreOrder=new ArrayList<Node>();
			for(int leftIndex=0;leftIndex<indexInPreOrder;leftIndex++)
			{
				leftPreOrder.add(preOrder.remove(0));
			}
			rightPreOrder=preOrder;
			int indexInPostOrder=returnIndexOf(leftPreOrder.get(0),postOrder);
			for(int leftIndex=0;leftIndex<=indexInPostOrder;leftIndex++)
			{
				leftPostOrder.add(postOrder.remove(0));
			}
			rightPostOrder=postOrder;
			createTreeLeft(rootNode,leftPreOrder,leftPostOrder);
			createTreeRight(rootNode,rightPreOrder,rightPostOrder);
		}
		catch(IndexOutOfBoundsException e)
		{
			return;
		}
	}
	private void printList(List<Node> list) 
	{
		for(Node n:list)
		{
			System.out.println(n.getValue());
		}
	}
	private int returnIndexOf(Node n,List<Node> list)
	{
		int index=0;
		for(index=0;index<list.size();index++)
		{
			if(list.get(index)==n)
			{
				return index;
			}
		}
		return -1;
	}
	public void insert(T n)
	{
		if(root==null)
		{
			root=new Node(n);
		}
		else
		{
			Node temp=root;
			this.insertNode(temp,n);
		}
	}
	private void insertNode(Node thisNode,T n)
	{
		if(thisNode.getLeftChild()==null)
		{
			thisNode.setLeftChild(new Node(n));
		}
		else if(thisNode.getRightChild()==null)
		{
			thisNode.setRightChild(new Node(n));
		}
		else
		{
			int leftDepth=getDepth(thisNode.getLeftChild());
			int rightDepth=getDepth(thisNode.getRightChild());
			if(rightDepth<leftDepth)
			{
				insertNode(thisNode.getRightChild(),n);
			}
			else
			{
				insertNode(thisNode.getLeftChild(),n);
			}
		}
	}
	private int getDepth(Node thisNode)
	{
		if(thisNode==null)
		{
			return 0;
		}
		else
		{
			int leftDepth=1+getDepth(thisNode.getLeftChild());
			int rightDepth=1+getDepth(thisNode.getRightChild());
			if(leftDepth>rightDepth)
			{
				return leftDepth;
			}
			else
			{
				return rightDepth;
			}
		}
	}
	public void getInorder()
	{
		Node temp=this.root;
		getInOrderPrivate(temp);
	}
	private void getInOrderPrivate(Node thisNode)
	{
		if(thisNode==null)
		{
			return;
		}
		getInOrderPrivate(thisNode.getLeftChild());
		System.out.print(thisNode.getValue()+"   ");
		getInOrderPrivate(thisNode.getRightChild());
	}
	public void getPostOrder()
	{
		Node temp=this.root;
		getPostOrderPrivate(temp);
	}
	private void getPostOrderPrivate(Node thisNode)
	{
		if(thisNode==null)
		{
			return;
		}
		getPostOrderPrivate(thisNode.getLeftChild());
		getPostOrderPrivate(thisNode.getRightChild());
		System.out.print(thisNode.getValue()+"  ");
	}
	public void getPreOrder()
	{
		Node temp=this.root;
		getPreOrderPrivate(temp);
	}
	private void getPreOrderPrivate(Node thisNode)
	{
		if(thisNode==null)
		{
			return;
		}
		System.out.println(thisNode.getValue());
		getPreOrderPrivate(thisNode.getLeftChild());
		getPreOrderPrivate(thisNode.getRightChild());
	}
	public int getBSTCount()
	{
		int count=0;
		Node tempRoot=this.root;
//		int countLeft=calculateBSTCount(tempRoot.getLeftChild());
//		int countRight=calculateBSTCount(tempRoot.getRightChild());
		return 0;
		
	}
	
}
