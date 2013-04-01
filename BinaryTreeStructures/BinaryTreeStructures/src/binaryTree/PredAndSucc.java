package binaryTree;

public class PredAndSucc<T> 
{
	private BinaryTree<T> btree;
	public PredAndSucc(BinaryTree<T> bt)
	{
		this.btree=bt;
	}
	public void getLinkList()
	{
		Node<T> btreeRoot=btree.getRoot();
		AssignNodes(btreeRoot);
	}
	private void AssignNodes(Node<T> current)
	{
		if(current==null)
		{
			return;
		}
		Node<T> leftChild=current.getLeftChild();
		Node<T> rightChild=current.getRightChild();
		current.setLeftChild(current.getPred());
		current.setRightChild(current.getSucc());
		AssignNodes(leftChild);
		AssignNodes(rightChild);
	}
	private void assignPredAndSucc(Node<T> parent,Node<T> current)
	{
		if(current==null)
		{
			return;
		}
		if(current.getLeftChild()!=null)
		{
			Node<T> returnRightMost=returnRightMost(current.getLeftChild());
			current.setPred(returnRightMost);
			returnRightMost.setSucc(current);
		}
		if(current.getRightChild()!=null)
		{
			Node<T> returnLeftMost=returnLeftMost(current.getRightChild());
			returnLeftMost.setPred(current);
			current.setSucc(returnLeftMost);
		}
		if(current.getLeftChild()==null&&current.getRightChild()==null)
		{
			if(parent.getLeftChild()==current)
			{
				current.setSucc(parent);
			}
			if(parent.getRightChild()==current)
			{
				current.setPred(parent);
			}
		}
		assignPredAndSucc(current,current.getLeftChild());
		assignPredAndSucc(current,current.getRightChild());
	}
	private Node<T> returnLeftMost(Node<T> current)
	{
		if(current.getLeftChild()==null)
		{
			return current;
		}
		return returnLeftMost(current.getLeftChild());
	}
	private Node<T> returnRightMost(Node<T> current)
	{
		if(current.getRightChild()==null)
		{
			return current;
		}
		return returnRightMost(current.getRightChild());
	}
}
