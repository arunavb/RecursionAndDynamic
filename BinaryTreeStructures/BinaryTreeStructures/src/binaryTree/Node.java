package binaryTree;

public class  Node <T> 
{
	private T n;
	private Node<T> leftNode;
	private Node<T> rightNode;
	private Node<T> pred;
	private Node<T> succ;
	public int depth=0;
	public Node(T val)
	{
		this.n=val;
	}
	public Node<T> getPred()
	{
		return this.pred;
	}
	public Node<T> getSucc()
	{
		return this.succ;
	}
	public void setPred(Node<T> pred)
	{
		this.pred=pred;
	}
	public void setSucc(Node<T> succ)
	{
		this.succ=succ;
	}
	public T getValue()
	{
		return this.n;
	}
	public Node<T> getLeftChild()
	{
		return this.leftNode;
	}
	public Node<T> getRightChild()
	{
		return this.rightNode;
	}
	public void setLeftChild(Node<T> n)
	{
		this.leftNode=n;
	}
	public void setRightChild(Node<T> n)
	{
		this.rightNode=n;
	}
	public String toString()
	{
		String returnString=String.valueOf(this.n);
		return returnString;
	}
}
