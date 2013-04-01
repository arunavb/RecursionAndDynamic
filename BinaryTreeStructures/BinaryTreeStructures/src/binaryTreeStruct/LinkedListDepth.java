package binaryTreeStruct;

import java.util.Random;
import java.util.*;
public class LinkedListDepth
{
	Map<Integer,LinkedList<Node>> depthMap;
	BinaryTree<Integer> bt;
	public LinkedListDepth(int n)
	{
		bt=new BinaryTree();
		int count=0;
		while(count<n)
		{
			count++;
			Random rand=new Random(System.nanoTime());
			int value=Math.abs(rand.nextInt()%100);
			System.out.println("Insert: "+value);
			bt.insert(value);
		}
		depthMap=new HashMap<Integer,LinkedList<Node>>();
	}
	public void populateList()
	{
		Node temp=bt.getRoot();
		fillList(temp,0);
	}
	private void fillList(Node root,int level)
	{
		if(root==null)
		{
			return;
		}
		LinkedList<Node> thisLevel=depthMap.get(level);
		if(thisLevel==null)
		{
			thisLevel=new LinkedList<Node>();
		}
		thisLevel.add(root);
		depthMap.put(level, thisLevel);
		fillList(root.getLeftChild(),level+1);
		fillList(root.getRightChild(),level+1);
	}
	public void printList()
	{
		for(int i:depthMap.keySet())
		{
			System.out.println("Depth: "+i);
			for(Node n:depthMap.get(i))
			{
				System.out.print(n.getValue()+"   ");
			}
			System.out.println();
		}
	}
	public static void main(String args[])
	{
		LinkedListDepth lld=new LinkedListDepth(20);
		System.out.println("Values Inserted");
		lld.populateList();
		lld.printList();
	}
}
