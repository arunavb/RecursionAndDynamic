package pemutations;

import java.util.*;

public class TextPad 
{
	private Map<Integer,List<Character>> textPad;
	public Map<Integer,List<Character>> getMap()
	{
		return this.textPad;
	}
	public TextPad()
	{
		textPad=new HashMap<Integer,List<Character>>();
		List<Character> thisList2=new ArrayList<Character>();
		thisList2.add('a');
		thisList2.add('b');
		thisList2.add('c');
		textPad.put(2, thisList2);
		List<Character> thisList3=new ArrayList<Character>();
		thisList3.add('d');
		thisList3.add('e');
		thisList3.add('f');
		textPad.put(3, thisList3);
		List<Character> thisList4=new ArrayList<Character>();
		thisList4.add('g');
		thisList4.add('h');
		thisList4.add('i');
		textPad.put(4, thisList4);
	}
	public List<String> getPermutation(String input)
	{
		List<String> perms=new ArrayList<String>();
		perms=returnPerms(input,perms);
		return perms;
	}
	private List<String> returnPerms(String input,List<String> perms) 
	{
		if(input.isEmpty())
		{
			perms.add("");
			return perms;
		}
		int c=Character.getNumericValue(input.charAt(0));
		System.out.println(c);
		String remainder=input.substring(1);
		perms=returnPerms(remainder,perms);
		List<String> newPerms=new ArrayList<String>();
		for(String s:perms)
		{
			for(char addChar:textPad.get(Integer.valueOf(c)))
			{
				newPerms.add(addChar+s);
			}
		}
		return newPerms;
	}
	public static void main(String args[])
	{
		TextPad tp=new TextPad();
		List<String> returnPerms=tp.getPermutation("234");
		for(String s:returnPerms)
		{
			System.out.print(s+"  ");
		}
	}
}
