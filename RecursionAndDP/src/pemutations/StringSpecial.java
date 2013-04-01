package pemutations;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class StringSpecial 
{
	private List<Character> charList;
	private List<String> allPerms;
	private String string;
	public StringSpecial(String string,List<Character> special)
	{
		this.string=string;
		this.charList=special;
	}
	public List<String> returnPermutations()
	{
		List<String> allPerms=returnPerms();
		ArrayList<String> returnAll=new ArrayList<String>();
		for(String str:allPerms)
		{
			returnAll.add(string+str);
			returnAll.add(str+string);
			for(int index=1;index<str.length()-1;index++)
			{
				String firstHalf=str.substring(0, index);
				String secondHalf=str.substring(index+1,str.length()-1);
				returnAll.add(firstHalf+string+secondHalf);
			}
		}
		return returnAll;
	}
	private List<String> returnPerms()
	{
		String s="";
		allPerms=new ArrayList<String>();
		for(char c:this.charList)
		{
			allPerms.add(String.valueOf(c));
			s+=c;
		}
		int lastIndex=allPerms.size();
		allPerms=returnAllPerms(s);
		return allPerms;
	}
	private List<String> returnAllPerms(String s) 
	{
		List<String> allPerms=new ArrayList<String>();
		if(s.isEmpty())
		{
			allPerms.add("");
			return allPerms;
		}
		while(!s.isEmpty())
		{
			char firstChar=s.charAt(0);
			s=s.substring(1);
			List<String> returnedPerms=returnAllPerms(s);
			for(String returned:returnedPerms)
			{
				if(returned.length()==0)
				{
					allPerms.add(String.valueOf(firstChar));
				}
				else
				{
					List<String> stringPerms=allPositionInsert(returned,firstChar);
					allPerms.addAll(stringPerms);
				}
				allPerms.add(returned);
			}
			return allPerms;
		}
		return allPerms;
	}
	private List<String> allPositionInsert
	(String string,char charToAppend) 
	{
		List<String> returnedString=new ArrayList<String>();
		char[] stringArray=string.toCharArray();
		int size=stringArray.length;
		for(int index=0;index<size;index++)
		{
			String thisString="";
			int firstHalf=0;
			for(firstHalf=0;firstHalf<=index;firstHalf++)
			{
				thisString+=stringArray[firstHalf];
			}
			thisString+=charToAppend;
			for(int secondHalf=firstHalf;secondHalf<size;secondHalf++)
			{
				thisString+=stringArray[secondHalf];
			}
			returnedString.add(thisString);
		}
		return returnedString;
	}
	public static void main(String args[])
	{
		List<Character> newList=new ArrayList<Character>();
		newList.add('!');
		newList.add('@');
		newList.add('#');
		newList.add('$');
		newList.add('%');
		StringSpecial s=new StringSpecial("test",newList);
		List<String> returnedList=s.returnPermutations();
//		for(String str:returnedList)
//		{
//			System.out.println(str);
//		}
		List<String> stringList=new ArrayList<String>();
		stringList.add("a");
		stringList.add("b");
		stringList.add("ab");
		Collections.sort(stringList);
		for(String str:stringList)
		{
			System.out.println(str);
		}
	}
}
