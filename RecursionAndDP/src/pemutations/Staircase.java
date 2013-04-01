package pemutations;
import java.util.*;
public class Staircase 
{
	private int numberOfStep;
	List<ArrayList<Integer>> steps;
	public Staircase()
	{
		
	}
	public ArrayList<String> numberOfWay(int n)
	{
		this.numberOfStep=n;
		steps=new ArrayList<ArrayList<Integer>>(n);
		return numberOfWaysRecursive(n);
	}
	private ArrayList<String> numberOfWaysRecursive(int n)
	{
		if(n==1)
		{
			ArrayList<String> oneStep=new ArrayList<String>();
			oneStep.add("1");
			return oneStep;
		}
		if(n==2)
		{
			ArrayList<String> twoStep=new ArrayList<String>();
			twoStep.add("1,1");
			twoStep.add("2");
			return twoStep;
		}
		ArrayList<String> thisStep=new ArrayList<String>();
		ArrayList<String> oneStepBack=numberOfWaysRecursive(n-1);
		for(String s:oneStepBack)
		{
			thisStep.add(s+",1");
		}
		ArrayList<String> twoStepsBack=numberOfWaysRecursive(n-2);
		for(String s:twoStepsBack)
		{
			thisStep.add(s+",2");
		}
		return thisStep;
	}
	public static void main(String args[])
	{
		Staircase s=new Staircase();
		ArrayList<String> returnString=s.numberOfWay(10);
		for(String st:returnString)
		{
			System.out.println(st);
		}
	}
}
