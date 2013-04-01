package pemutations;

import java.util.*;

public class SubSets 
{
	private List<String> initialSet;
	public SubSets()
	{
		initialSet=new ArrayList<String>();
		initialSet.add("1");
		initialSet.add("2");
		initialSet.add("3");
	}
	public List<ArrayList<String>> generateAllSets()
	{
		List<ArrayList<String>> listOfSets=new ArrayList<ArrayList<String>>();
		ArrayList<String> emptySet=new ArrayList<String>();
		listOfSets.add(emptySet);
		ArrayList<String> tempList=new ArrayList<String>();
		for(String s:initialSet)
		{
			tempList.add(s);
		}
		listOfSets=allSets(tempList,listOfSets);
		return listOfSets;
	}
	private List<ArrayList<String>> allSets(List<String> initial,List<ArrayList<String>> listOfSets)
	{
		if(initial.size()==0)
		{
			return listOfSets;
		}
		String firstString=initial.remove(0);
		List<ArrayList<String>> tempListOfSets=new ArrayList<ArrayList<String>>();
		for(ArrayList<String> array:listOfSets)
		{
			tempListOfSets.add(new ArrayList<String>(array));
		}
		for(ArrayList<String> array:listOfSets)
		{
			ArrayList<String> thisSet=new ArrayList<String>(array);
			thisSet.add(firstString);
			tempListOfSets.add(thisSet);
		}
		return allSets(initial,tempListOfSets);
	}
	public static void main(String args[])
	{
		SubSets ss=new SubSets();
		List<ArrayList<String>> output=ss.generateAllSets();
		for(ArrayList<String> array:output)
		{
			System.out.print("Set : ");
			for(String i:array)
			{
				System.out.print(i+"  ");
			}
			System.out.println();
		}
	}
}
