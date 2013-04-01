package pemutations;
import java.util.*;
public class BinaryPerms 
{
	private static BinaryPerms instance=null;
	public static BinaryPerms getInstance()
	{
		if(instance==null)
		{
			instance = new BinaryPerms();
		}
		return instance;
	}
	private BinaryPerms()
	{
		this.returnList=new ArrayList<String>();
	}
	private ArrayList<String> returnList;
	public ArrayList<String> returnPerms(int k)
	{
		ArrayList<String> initialList=new ArrayList<String>();
		if(k==0)
		{
			return initialList;
		}
		else
		{
			return returnPermsPrivate(initialList,k);
		}
	}
	private ArrayList<String> returnPermsPrivate(ArrayList<String> initialList,int k)
	{
		if(k==1)
		{
			initialList.add("1");
			return initialList;
		}
		ArrayList<String> tempList=returnPermsPrivate(initialList,k-1);
		ArrayList<String> thisScopeList=new ArrayList<String>();
		for(String s:tempList)
		{
			thisScopeList.add(s+"1");
			if(s.charAt(s.length()-1)!='0')
			{
				thisScopeList.add(s+"0");
			}
		}
		return thisScopeList;
	}
	public static void main(String args[])
	{
		BinaryPerms bp=BinaryPerms.getInstance();
		ArrayList<String> perms=bp.returnPerms(10);
		for(String s:perms)
		{
			System.out.println(s);
		}
	}
}
