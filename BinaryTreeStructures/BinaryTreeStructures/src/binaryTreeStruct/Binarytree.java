package binaryTreeStruct; 

import java.util.ArrayList;
import java.util.List;

public class Binarytree <T>
{
	private Node root;
	public Node getRoot() {
		return root;
	}
	public void setRoot(Node root) {
		this.root = root;
	}
	private int largestBST=0;
	private List<Node> postOrderNodes;
	public List<Node> getPostOrderNodes()
	{
		postOrderNodes=new ArrayList<Node>();
		getPostOrder();
		return postOrderNodes;
	}
	public Binarytree()
	{
	}
	public Binarytree(T n)
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
	public Node findNode(T n)
	{
		Node node=null;
		if(this.root.getValue()==n)
		{
			return root;
		}
		else
		{
			return findRoot(root,n);
		}
			
	}
	public void insertRight(T thisval,T n)
	{
		Node thisNode=findNode(thisval);
		thisNode.setRightChild(new Node(n));
	}
	public void insertLeft(T thisval,T n)
	{
		Node thisNode=findNode(thisval);
		thisNode.setLeftChild(new Node(n));
	}
	private Node findRoot(Node thisNode,T n) 
	{
		if(thisNode==null)
		{
			return null;
		}
		if(thisNode.getValue()==n)
		{
			return thisNode;
		}
		else
		{
			Node foundNode=findRoot(thisNode.getLeftChild(),n);
			if(foundNode!=null)
			{
				return foundNode;
			}
			foundNode=findRoot(thisNode.getRightChild(),n);
			return foundNode;
		}
	}
	public Binarytree(List<Node> preOrder,List<Node> postOrder)
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
	
	public Binarytree(List<Node> preOrder)
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
		System.out.print(thisNode.getValue()+"  ");
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
		postOrderNodes.add(thisNode);
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
		System.out.print(thisNode.getValue()+"   ");
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
	public List<Node> returnMaxPath()
	{
		List<Node> returnPath=new ArrayList<Node>();
		Node temp=root;
		returnPath.addAll(max(temp,returnPath));
		return returnPath;
	}
	private List<Node> max(Node root,List<Node> returnPath) 
	{
		List<Node> retPath=new ArrayList<Node>();
		if(root==null)
		{
			return retPath;
		}
		if(root.getLeftChild()==null&&root.getRightChild()==null)
		{
			int leftRoot=(int)root.getValue();
			retPath.add(0, root);
			return retPath;
		}
		else
		{
			List<Node> leftBest=max(root.getLeftChild(),retPath);
			List<Node> rightBest=max(root.getRightChild(),retPath);
			int leftBestCount=(int)root.getValue();
			int rightBestCount=(int)root.getValue();
			for(Node n:leftBest)
			{
				leftBestCount+=(int)n.getValue();
			}
			for(Node n:rightBest)
			{
				rightBestCount+=(int)n.getValue();
			}
			if(leftBestCount>rightBestCount)
			{
				retPath.addAll(leftBest);
				retPath.add(0, root);
				return retPath;
			}
			else
			{
				retPath.addAll(rightBest);
				retPath.add(0, root);
				return retPath;
			}
		}
//		return null;
	}
}
