package pemutations;
import java.util.*;
public class LadderRevisited 
{
	private List<List<Integer>> combinations;
	public int returnNumberOfCombinations(int n)
	{
		List<String> returned= calculateCombo(n);
		for(String s:returned)
		{
			System.out.println(s);
		}
		return 0;
	}
	private List<String> calculateCombo(int n)
	{
		List<String> thisScope=new ArrayList<String>();
		if(n<1)
		{
			return thisScope;
		}
		if(n==1)
		{
			thisScope.add("1");
			return thisScope;
		}
		if(n==2)
		{
			thisScope.add("1 1");
			thisScope.add("2");
			return thisScope;
		}
		List<String> oneStepLess=calculateCombo(n-1);
		for(String s:oneStepLess)
		{
			thisScope.add(s+" 1");
		}
		List<String> twoStepsLess=calculateCombo(n-2);
		for(String s:twoStepsLess)
		{
			String tempString=s+" 1 1";
			if(!thisScope.contains(tempString))
			{
				thisScope.add(tempString);
			}
			thisScope.add(s+" 2");
		}
		return thisScope;
	}
	public static void main(String args[])
	{
		LadderRevisited lr=new LadderRevisited();
		lr.returnNumberOfCombinations(5);
	}
}
