package binaryTree;
import java.util.*;
public class CopyBFS 
{
	public BinaryTree<Integer> returnTree(BinaryTree<Integer> input)
	{
	    List<Node<Integer>> BFSQueue=new ArrayList<Node<Integer>>();
	    return createTree(input,BFSQueue);
	}
	public BinaryTree<Integer> createTree(BinaryTree<Integer> input,List<Node<Integer>> BFS)
	{
	    BinaryTree<Integer> returnTree=new BinaryTree<Integer>();
	    Node<Integer> temp=input.getRoot();
	    insertIntoQueue(BFS,temp,returnTree);
	    insertRecursively(BFS,input,returnTree);
	    return returnTree;
	}
	public void insertIntoQueue(List<Node<Integer>> BFS,Node<Integer> temp,BinaryTree<Integer> tree)
	{
	    BFS.add(temp);
		tree.insert(temp.getValue());
	}
	private void insertRecursively(List<Node<Integer>> BFS,BinaryTree<Integer> originalTree,BinaryTree<Integer> duplicateTree)
	{
	    if(BFS.size()==0)
	    {
	        return;
	    }
	    Node<Integer> frontQueue=BFS.remove(0);
	    Node found=findInDuplicate(frontQueue,duplicateTree.getRoot());
	    if(found==null)
	    {
	        System.out.println("Issue with finding the node just popped");
	    }
	    if(frontQueue.getLeftChild()!=null)
	    {
	        found.setLeftChild(new Node(frontQueue.getLeftChild().getValue()));
	        BFS.add(frontQueue.getLeftChild());
	    }
	    if(frontQueue.getRightChild()!=null)
	    {
	        found.setRightChild(new Node(frontQueue.getRightChild().getValue()));
	        BFS.add(frontQueue.getRightChild());
	    }
	}
	private Node findInDuplicate(Node temp,Node duplicateTreeNode)
	{
	    if(duplicateTreeNode.getValue()==temp.getValue())
	    {
	        return duplicateTreeNode;
	    }
	    else
	    {
	        Node leftChild=findInDuplicate(temp,duplicateTreeNode.getLeftChild());
	        if(leftChild!=null)
	        {
	            return leftChild;
	        }
	        else
	        {
	            Node rightChild=findInDuplicate(temp,duplicateTreeNode.getRightChild());
	            if(rightChild!=null)
	            {
	                return rightChild;
	            }    
	        }
	        return null;
	    }
	}
	public static void main(String args[])
	{
		CopyBFS cb=new CopyBFS();
		BinaryTree bt=new BinaryTree();
		bt.insert(6);
//		bt.insertLeft(6,9);
//		bt.insertRight(6, 1);
		BinaryTree<Integer> returnTree=cb.returnTree(bt);
//		List<Node> postOrder=returnTree.getPostOrderNodes();
//		for(Node n:postOrder)
		{
//			System.out.println(n);
		}
				System.out.println("done");
	}
}
