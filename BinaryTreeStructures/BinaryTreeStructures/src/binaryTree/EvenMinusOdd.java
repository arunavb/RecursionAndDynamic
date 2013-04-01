package binaryTree;
import java.util.*;
public class EvenMinusOdd 
{
	private BinaryTree<Integer> bTree;
	public BinaryTree<Integer> getTree()
	{
		return this.bTree;
	}
	public EvenMinusOdd()
	{
		bTree=new BinaryTree<Integer>();
		populateTree();
	}
	private void populateTree()
	{
		Random rand=new Random(System.nanoTime());
		int count=0;
		while(count<20)
		{
			int value=Math.abs(rand.nextInt()%1000);
			bTree.insert(value);
			count++;
		}
//		System.out.println("Here");
	}
	public int findSubtraction(BinaryTree<Integer> btree)
	{
		int oddSum=0;
		int evenSum=0;
		
		List<Integer> evenOdd=new ArrayList<Integer>();
		evenOdd.add(0);
		evenOdd.add(0);
		evenOdd=findTotalSum(evenOdd,btree.getRoot(),1);
		return evenOdd.get(0)-evenOdd.get(1);
	}
	private List<Integer> findTotalSum(List<Integer> evenOdd,Node<Integer> root, int depth) 
	{
		if(root==null)
		{
			return evenOdd;
		}
		if(depth%2==0)
		{
			evenOdd.set(0, evenOdd.get(0)+root.getValue());
		}
		else
		{
			evenOdd.set(1, evenOdd.get(1)+root.getValue());
		}
		evenOdd=findTotalSum(evenOdd,root.getLeftChild(),depth+1);
		evenOdd=findTotalSum(evenOdd,root.getRightChild(),depth+1);
		return evenOdd;
	}
	public static void main(String args[])
	{
		EvenMinusOdd emo=new EvenMinusOdd();
		System.out.println(emo.findSubtraction(emo.getTree()));
	}
}
