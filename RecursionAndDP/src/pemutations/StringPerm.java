package pemutations;
import java.util.*;
public class StringPerm 
{
	List<String> allPerms=new ArrayList<String>();
	public List<String> returnAllPerms(String input)
	{
		if(input.isEmpty())
		{
			allPerms.add("");
			return allPerms;
		}
		char firstChar=input.charAt(0);
		allPerms=returnAllPerms(input.substring(1));	
		List<String> tempList=addToAllChars(firstChar,allPerms);
		return tempList;
	}
	private List<String> addToAllChars(char charToInsert,List<String> list)
	{
		Set<String> setOfList=new HashSet<String>();
		List<String> tempList=new ArrayList<String>();
		for(String s:list)
		{
			setOfList.add(s+charToInsert);
			setOfList.add(charToInsert+s);
			for(int index=0;index<s.length()-1;index++)
			{
				String firstPart=s.substring(0, index+1);
				String secondPart=s.substring(index+1);
				setOfList.add(firstPart+charToInsert+secondPart);
			}
		}
		for(String s:setOfList)
		{
//			System.out.println(s);
			tempList.add(s);
		}
		return tempList;
	}
	public static void main(String args[])
	{
		StringPerm sp=new StringPerm();
		List<String> returnedList=sp.returnAllPerms("tree");
		for(String s:returnedList)
		{
			System.out.println(s);
		}
	}
}
