package pemutations;

public class StringReplacement 
{
	public String replaceA(String input)
	{
		StringBuffer s=new StringBuffer();
		for(int index=0;index<input.length();index++)
		{
			if(input.charAt(index)!='a'&&input.charAt(index)!='A')
			{
				s.append(input.charAt(index));
			}
			else
			{
				if(index+1<input.length())
				{
					if(input.charAt(index+1)!='a'&&input.charAt(index+1)!='A')
					{
						s.append("the");
					}
					else
					{
						s.append(input.charAt(index));
					}
				}
				else
				{
					s.append(input.charAt(index));
				}
			}
		}
		return s.toString();
	}
	public static void main(String args[])
	{
		StringReplacement sr=new StringReplacement();
		System.out.println(sr.replaceA("A man walks in with the Bat"));
	}
}
