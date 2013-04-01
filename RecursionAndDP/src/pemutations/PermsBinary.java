package pemutations;

public class PermsBinary 
{
	private int limit;
	public PermsBinary()
	{
		this.limit=0;
	}
	public void returnPerms(int n)
	{
		this.limit=n;
	}
	public boolean checkValid(String thisInput)
	{
		char[] charArray=thisInput.toCharArray();
		if(charArray[0]=='0')
		{
			return false;
		}
		for(int index=1;index<charArray.length;index++)
		{
			if(charArray[index]=='0')
			{
				if(charArray[index-1]!='1')
				{
					return false;
				}
			}
		}
		return true;
	}
	public void generateValidPerms(int n)
	{
		
	}
}
