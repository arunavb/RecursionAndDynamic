package pemutations;
import java.util.*;
public class StringPerms 
{
	private String inputString;
	public StringPerms(String input)
	{
		this.inputString=input;
	}
	public ArrayList<String> returnAllPerms()
	{
		ArrayList<String> returnString=new ArrayList<String>();
		String string=new String(inputString);
		returnString=returnAllPermsPrivate(inputString,returnString);
		return returnString;
	}
	private ArrayList<String> returnAllPermsPrivate(String input,ArrayList<String> permutations)
	{
		if(input.isEmpty())
		{
			permutations.add("");
			return permutations;
		}
		char firstChar=input.charAt(0);
		input=input.substring(1);
		permutations=returnAllPermsPrivate(input,permutations);
		ArrayList<String> addedList=new ArrayList<String>();
		for(String s:permutations)
		{
			addedList.addAll(addChar(firstChar,s));
//			permutations.addAll(addedList);
		}
		return addedList;
	}
	private List<String> addChar(char c,String s)
	{
	    List<String> returnString=new ArrayList<String>();
	    for(int index=0;index<s.length();index++)
	    {
	        String firstPart=s.substring(0,index);
	        String secondPart=s.substring(index,s.length());
	        String addString=firstPart+c+secondPart;
	        if(!returnString.contains(addString))
	        {
	            returnString.add(addString);
	        } 
	    }
	    if(!returnString.contains(s+c))
	    {
	    	returnString.add(s+c);
	    }
	    return returnString;
	}
	public static void main(String args[])
	{
		StringPerms s=new StringPerms("abc");
		ArrayList<String> stringList=s.returnAllPerms();
		for(String st:stringList)
		{
			System.out.println(st);
		}
	}
}
