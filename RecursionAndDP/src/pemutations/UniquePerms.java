package pemutations;
import java.util.*;
public class UniquePerms 
{
	public UniquePerms()
	{
		
	}
	public List<String> returnPerms(String s)
	{
		return calculatePerms(s,new ArrayList<String>());
	}
	private ArrayList<String> calculatePerms(String s,ArrayList<String> input)
	{
		if(s.length()==0)
		{
			input.add("");
			return input;
		}
		char firstChar=s.charAt(0);
		String remaining=s.substring(1);
		input=calculatePerms(remaining,input);
		ArrayList<String> thisPerm=new ArrayList<String>();
		thisPerm.addAll(input);
		for(String prevPerm:input)
		{
			if(!thisPerm.contains(firstChar+prevPerm))
			{
				thisPerm.add(firstChar+prevPerm);
			}
			if(!thisPerm.contains(prevPerm+firstChar))
			{
				thisPerm.add(prevPerm+firstChar);
			}
		}
		return thisPerm;
	}
	public static void main(String args[])
	{
		UniquePerms up=new UniquePerms();
		List<String> perms=up.returnPerms("abc");
		for(String p:perms)
		{
			System.out.println(p);
		}
	}
}
