package binaryTreeStruct;

import java.util.ArrayList;
import java.util.List;

public class BinarySearchTree 
{
	private Node root;
	private int count=0;
	private List<Node> inOrderTraversal;
	private List<Node> preOrderTraversal;
	private List<Node> postOrderTraversal;
	int numberOfNodes=0;
	public Node getRoot()
	{
		return this.root;
	}
	public List<Node>  getInOrderNodes()
	{
		getInorder();
		return this.inOrderTraversal;
	}
	public List<Node> getPreOrderNodes()
	{
		getPreOrder();
		return this.preOrderTraversal;
	}
	public List<Node> getPostOrderNodes()
	{
		getPostOrder();
		return this.postOrderTraversal;
	}
	public BinarySearchTree()
	{
		
	}
	public BinarySearchTree(int n)
	{
		if(root==null)
		{
			numberOfNodes++;
			root=new Node(n);
		}
		else
		{
			Node temp=root;
//			this.insertNode(temp,n);
		}
	}
	public void insert(int n)
	{
		if(root==null)
		{
//			System.out.println(++count);
			root=new Node<Integer>(n);
//			return;
		}
		else
		{
			Node<Integer> temp=root;
			this.insertNode(temp,n);
		}
		numberOfNodes++;
	}
	private void insertNode(Node<Integer> thisNode,int n)
	{
		if(n<thisNode.getValue())
		{
			if(thisNode.getLeftChild()==null)
			{
//				System.out.println(++count);
				thisNode.setLeftChild(new Node<Integer>(n));
			}
			else
			{
				insertNode(thisNode.getLeftChild(),n);
			}
		}
		else
		{
			if(thisNode.getRightChild()==null)
			{
//				System.out.println(++count);
				thisNode.setRightChild(new Node<Integer>(n));
			}
			else
			{
				insertNode(thisNode.getRightChild(),n);
			}
		}
	}
	public void getInorder()
	{
		inOrderTraversal=new ArrayList<Node>();
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
		inOrderTraversal.add(thisNode);
		getInOrderPrivate(thisNode.getRightChild());
	}
	public void getPostOrder()
	{
		postOrderTraversal=new ArrayList<Node>();
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
		postOrderTraversal.add(thisNode);
	}
	public void getPreOrder()
	{
		preOrderTraversal=new ArrayList<Node>();
		Node temp=this.root;
		getPreOrderPrivate(temp);
	}
	private void getPreOrderPrivate(Node thisNode)
	{
		if(thisNode==null)
		{
			return;
		}
		preOrderTraversal.add(thisNode);
		getPreOrderPrivate(thisNode.getLeftChild());
		getPreOrderPrivate(thisNode.getRightChild());
	}
	public int getCount()
	{
		Node temp=this.root;
		int count=getCountPrivate(temp);
		return count;
	}
	private int getCountPrivate(Node thisNode)
	{
		if(thisNode==null)
		{
			return 0;
		}
		return (1+getCountPrivate(thisNode.getLeftChild())+getCountPrivate(thisNode.getRightChild()));
	}
}
