package pemutations;
import java.util.*;
public class FourDigit 
{
	List<Character> allDigits;
	public List<String> returnPerms()
	{
		List<String> returnedList=new ArrayList<String>();
		returnedList.add("1");
		returnedList.add("2");
		returnedList.add("3");
		returnedList.add("4");
		returnedList.add("5");
		returnedList.add("6");
		returnedList.add("7");
		returnedList.add("8");
		returnedList.add("9");
		allDigits=new ArrayList<Character>();
		allDigits.add('0');
		allDigits.add('1');
		allDigits.add('2');
		allDigits.add('3');
		allDigits.add('4');
		allDigits.add('5');
		allDigits.add('6');
		allDigits.add('7');
		allDigits.add('8');
		allDigits.add('9');
		return returnAllPerms(returnedList);
	}
	private List<String> returnAllPerms(List<String> list)
	{
		if(list.get(0).length()==4)
		{
				return list;
		}
		List<String> tempList=new ArrayList<String>();
		for(String s:list)
		{
			if(s.length()==3)
			{
				if(s.charAt(0)=='4')
				{
					tempList.add(s+"4");
				}
				else
				{
					for(char digit:allDigits)
					{
						if(s.charAt(s.length()-1)!=digit)
						tempList.add(s+digit);
					}
				}
			}
			else
			{
				for(char digit:allDigits)
				{
					if(s.charAt(s.length()-1)!=digit)
					tempList.add(s+digit);
				}
			}
		}
		return returnAllPerms(tempList);
		}	
		public static void main(String args[])
		{
			FourDigit fd=new FourDigit();
			List<String> returned=fd.returnPerms();
			for(String s:returned)
			{
				System.out.println(s);
			}
		}
	}
