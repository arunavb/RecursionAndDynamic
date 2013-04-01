package pemutations;
import java.util.*;
public class AllCombinationAddition 
{
	Map<Integer,List<String>> map;
	public AllCombinationAddition()
	{
		map=new HashMap<Integer,List<String>>();
		initializeMap();
	}
	private void initializeMap()
	{
		List<String> one=new ArrayList<String>();
		one.add("1");
		List<String> two=new ArrayList<String>();
		map.put(1, one);
	}
	public List<String> returnAllCombination(int k)
	{
		return retAllCombPvt(k);
	}
	private List<String> retAllCombPvt(int k)
	{
		if(k==1)
		{
			return map.get(k);
		}
		int value=1;
		List<String> thisScope=new ArrayList<String>();
		while(value<k)
		{
			int addValue=value;
			int newK=k-value;
			List<String> thisK=new ArrayList<String>();
			thisK=returnAllCombination(newK);
			for(String s:thisK)
			{
				if(!thisScope.contains(s+" "+addValue))
				{
					thisScope.add(s+" "+addValue);
				}
			}
			if(!thisScope.contains(addValue+" "+newK))
			{
				thisScope.add(addValue+" "+newK);
			}
			value++;
		}
		return thisScope;
	}
	public static void main(String args[])
	{
		AllCombinationAddition aca=new AllCombinationAddition();
		List<String> returned=aca.returnAllCombination(5);
		for(String s:returned)
		{
			System.out.println(s);
		}
	}
}
