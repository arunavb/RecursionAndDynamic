package pemutations;
import java.util.*;
public class Paranthesis 
{
	public Paranthesis()
	{
		
	}
	public ArrayList<String> returnPerms(int n)
	{
		ArrayList<String> thisPerm=new ArrayList<String>();
		if(n==1)
		{
			thisPerm.add("()");
			return thisPerm;
		}
		ArrayList<String> prevPerm=returnPerms(n-1);
		for(String s:prevPerm)
		{
			thisPerm.addAll(insertParan(s));
			thisPerm.add("()"+s);
		}
		ArrayList<String> finalPerm=new ArrayList<String>();
		Set<String> set=new HashSet<String>();
		for(String s:thisPerm)
		{
			if(set.add(s))
			{
				finalPerm.add(s);
			}
		}
		return finalPerm;
	}
	private List<String> insertParan(String s)
	{
		ArrayList<String> returnList=new ArrayList<String>();
		char[] toCharArray=s.toCharArray();
		for(int index=0;index<toCharArray.length;index++)
		{
			if((toCharArray[index]=='(')&&(toCharArray[index+1]==')'))
			{
				String firstPart=s.substring(0, index+1);
				String secondPart=s.substring(index+1);
				if(!returnList.contains(firstPart+"()"+secondPart))
				returnList.add(firstPart+"()"+secondPart);
			}
		}
		return returnList;
	}
	public static void main(String args[])
	{
		Paranthesis p=new Paranthesis();
		List<String> output=p.returnPerms(4);
		for(String s:output)
		{
			System.out.println(s);
		}
		System.out.println(output.size());
	}
	
}
