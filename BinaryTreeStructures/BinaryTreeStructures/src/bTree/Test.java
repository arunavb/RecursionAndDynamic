package bTree;
import java.util.*;
public class Test 
{
	static int[][] matrix=new int[6][6];
	public static void main(String args[])
	{
		BinaryTree bt=new BinaryTree();
		Person p1=new Person(1,"Arunav Borthakur");
		Person p2=new Person(2,"Nidhi Chaudhry");
		Person p3=new Person(3,"Malav Shah");
		Person p4=new Person(4,"Meehir Nagda");
		Person p5=new Person(5,"Prachi Kurkute");
		Person p6=new Person(6,"Anushka Jadhav");
		bt.insertPerson(p1);
		bt.insertPerson(p2);
		bt.insertPerson(p3);
		bt.insertPerson(p4);
		bt.insertPerson(p5);
		bt.insertPerson(p6);
		for(int row=0;row<6;row++)
		{
			for(int col=0;col<6;col++)
			{
				matrix[row][col]=0;
			}
		}
		List<Integer> listOfAncestors=new ArrayList<Integer>();
		changeMatrix(bt.getRoot(),listOfAncestors);
		System.out.println("Matrix ");
		for(int row=0;row<6;row++)
		{
			for(int col=0;col<6;col++)
			{
				System.out.print("  "+matrix[row][col]);
			}
			System.out.println();
		}
	}
	private static void changeMatrix(TreeNode root,List<Integer> ancestors)
	{
		if(root==null)
		{
			return;
		}
		int value=root.getNode().getSSN();
		for(int i:ancestors)
		{
			matrix[i][value-1]=1;
		}
		List<Integer> thisScopeAncestors=new ArrayList<Integer>();
		for(int i:ancestors)
		{
			thisScopeAncestors.add(i);
		}
		thisScopeAncestors.add(value-1);
		changeMatrix(root.getLeftChild(),thisScopeAncestors);
		changeMatrix(root.getRightChild(),thisScopeAncestors);
	}
}
