package pemutations;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class AllNumberSum 
{
	public static void main(String args[])
	{
		Map<Integer, List<ArrayList<Integer>>> fullList=new HashMap<Integer,List<ArrayList<Integer>>>();
		ArrayList<Integer> first=new ArrayList<Integer>();
		first.add(2);
		List<ArrayList<Integer>> firstList=new ArrayList<ArrayList<Integer>>();
		firstList.add(first);
		fullList.put(2,firstList);
		first=new ArrayList<Integer>();
		first.add(3);
		firstList=new ArrayList<ArrayList<Integer>>();
		firstList.add(first);
		fullList.put(3, firstList);
		for(int key=4;key<=20;key++)
		{
			ArrayList<Integer> thisKey=new ArrayList<Integer>();
			List<ArrayList<Integer>> thisList=new ArrayList<ArrayList<Integer>>();
			thisKey.add(key);
			thisList.add(thisKey);
			for(int combination=2;combination<key;combination++)
			{
				if(key-combination>1)
				{
					for(ArrayList<Integer> arrayList:fullList.get(key-combination))
					{
						ArrayList<Integer> thisKey2=new ArrayList<Integer>();
						thisKey2.add(combination);
						thisKey2.addAll(arrayList);
						thisList.add(thisKey2);
					}
				}
				
			}
			fullList.put(key, thisList);
		}
		for(int key=2;key<=20;key++)
		{
			System.out.print(key+"->");
			List<ArrayList<Integer>> thisList=fullList.get(key);
			for(ArrayList<Integer> array:thisList)
			{
				System.out.print("[ ");
				for(int i:array)
				{
					System.out.print(i+" ");
				}
				System.out.print("]  ");
			}
			System.out.println();
		}
	}
}
