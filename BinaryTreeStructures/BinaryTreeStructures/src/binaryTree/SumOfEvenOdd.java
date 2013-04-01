package binaryTree;
import java.util.*;
public class SumOfEvenOdd 
{
	BinaryTree<Integer> bt;
	public SumOfEvenOdd()
	{
		bt=new BinaryTree<Integer>();
		Random r=new Random(System.nanoTime());
		bt.insert(Math.abs(r.nextInt()%1000));
		bt.insert(Math.abs(r.nextInt()%1000));
		bt.insert(Math.abs(r.nextInt()%1000));
		bt.insert(Math.abs(r.nextInt()%1000));
		bt.insert(Math.abs(r.nextInt()%1000));
		bt.insert(Math.abs(r.nextInt()%1000));
		bt.insert(Math.abs(r.nextInt()%1000));
		bt.insert(Math.abs(r.nextInt()%1000));
		bt.insert(Math.abs(r.nextInt()%1000));
		bt.insert(Math.abs(r.nextInt()%1000));
		bt.insert(Math.abs(r.nextInt()%1000));
		bt.insert(Math.abs(r.nextInt()%1000));
		bt.insert(Math.abs(r.nextInt()%1000));
		bt.insert(Math.abs(r.nextInt()%1000));
		
	}
	public int getDifference()
	{
		List<Integer> evenList=new ArrayList<Integer>();
		List<Integer> oddList=new ArrayList<Integer>();
		List<Node<Integer>> queue=new ArrayList<Node<Integer>>();
		List<Node<Integer>> next=new ArrayList<Node<Integer>>();
		List<Integer> level=new ArrayList<Integer>();
		queue.add(bt.getRoot());
		level.add(0);
		populateList(queue,level,evenList,oddList);
		System.out.println("Even Level Nodes");
		int evenSum=0;
		int oddSum=0;
		for(int i:evenList)
		{
			evenSum+=i;
		}
		System.out.println("Odd Level Nodes");
		for(int i:oddList)
		{
			oddSum+=i;
		}
		return (evenSum-oddSum); 
		
	}
	private void populateList
	(List<Node<Integer>> queue, List<Integer> level,List<Integer> evenList,List<Integer> oddList) 
	{
		if(queue.isEmpty())
		{
			return;
		}
		Node<Integer> element=queue.remove(0);
		int currentLevel=level.remove(0);
		if(element.getLeftChild()!=null)
		{
			queue.add(element.getLeftChild());
			level.add(currentLevel+1);
		}
		if(element.getRightChild()!=null)
		{
			queue.add(element.getRightChild());
			level.add(currentLevel+1);
		}
		if(currentLevel%2==0)
		{
			evenList.add(element.getValue());
		}
		else
		{
			oddList.add(element.getValue());
		}
		populateList(queue,level,evenList,oddList);
	}
	public static void main(String args[])
	{
		SumOfEvenOdd seo=new SumOfEvenOdd();
		seo.bt.getPostOrder();
		System.out.println();
		System.out.println("Difference of the sum is: ");
		System.out.println(seo.getDifference());
	}
}
