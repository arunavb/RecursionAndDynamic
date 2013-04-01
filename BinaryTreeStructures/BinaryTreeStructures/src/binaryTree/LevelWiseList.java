package binaryTree;
import java.util.*;
public class LevelWiseList 
{
	private BinaryTree<Integer> bt;
	public LevelWiseList(BinaryTree<Integer> btree)
	{
		this.bt=btree;
	}
	public ArrayList<ArrayList<Node<Integer>>> BreadthFirst()
	{
		calculateDepth();
		List<Node<Integer>> queue=new ArrayList<Node<Integer>>();
		queue.add(bt.getRoot());
		ArrayList<ArrayList<Node<Integer>>> listOfList=new ArrayList<ArrayList<Node<Integer>>>();
		for(int i=0;i<5;i++)
		{
			listOfList.add(new ArrayList<Node<Integer>>());
		}
		ArrayList<ArrayList<Node<Integer>>> returnList=calculateBFS(queue,listOfList, 0);
		return returnList;
	}
	private ArrayList<ArrayList<Node<Integer>>> calculateBFS
	(List<Node<Integer>> queue,ArrayList<ArrayList<Node<Integer>>> listOfList , int counter)
	{
		
		while(!queue.isEmpty())
		{
			System.out.println("queue "+queue);
			Node<Integer> n=queue.remove(0);
			ArrayList<Node<Integer>> thisLevel=new ArrayList<Node<Integer>>();
			System.out.println("N "+n+"depth"+n.depth);
			thisLevel=listOfList.remove(n.depth);
			System.out.println("this level beginning "+thisLevel);
			if(thisLevel.size()==0)
			{
				thisLevel=new ArrayList<Node<Integer>>();
			}
			thisLevel.add(n);
			Node<Integer> leftChild=n.getLeftChild();
			if(leftChild!=null)
			{
				queue.add(leftChild);
			}
			Node<Integer> rightChild=n.getRightChild();
			if(rightChild!=null)
			{
				queue.add(rightChild);
			}
			System.out.println("Inserted at level: "+n.depth+"Node :"+n+" Depth: "+n.depth);
			System.out.println("this level end"+thisLevel);
			System.out.println("depth of n "+n.depth);
			listOfList.add(n.depth, thisLevel);
			
//			thisLevel.clear();
		}
		return listOfList;
	}
	private void calculateDepth()
	{
		Node<Integer> tempRoot=bt.getRoot();
		assignDepth(tempRoot,0);
	}
	private void assignDepth(Node currentNode,int depth)
	{
		if(currentNode==null)
		{
			return;
		}
		currentNode.depth=depth;
		assignDepth(currentNode.getLeftChild(),depth+1);
		assignDepth(currentNode.getRightChild(),depth+1);
	}
	public static void main(String args[])
	{
		BinaryTree<Integer> bt=new BinaryTree<Integer>();
		bt.insert(7);
//		bt.insertLeft(7, 4);
//		bt.insertRight(7, 8);
//		bt.insertLeft(4, 1);
//		bt.insertRight(4, 18);
//		bt.insertLeft(8, 14);
//		bt.insertRight(8, 21);
//		bt.insertLeft(1, 12);
//		bt.insertRight(1, 13);
//		bt.insertLeft(18, 52);
//		bt.insertRight(18, 58);
//		bt.insertLeft(14, 134);
//		bt.insertRight(14, 98);
//		LevelWiseList lw=new LevelWiseList(bt);
//		ArrayList<ArrayList<Node<Integer>>> list=lw.BreadthFirst();
//		for(int i=0;i<list.size();i++)
		{
//			System.out.println("Level "+i);
//			ArrayList<Node<Integer>> thisList=list.get(i);
//			for(Node<Integer> node:thisList)
			{
//				System.out.print(node+"   ");
			}
			System.out.println();
		}
	}
}
