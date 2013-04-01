package bTree;

import java.util.HashMap;
import java.util.Map;

public class SuffixTreeNode 
{
	String value;
	Map<Character,SuffixTreeNode> children;
	public SuffixTreeNode(String value)
	{
		this.value=value;
		children=new HashMap<Character,SuffixTreeNode>();
	}
	public Map<Character,SuffixTreeNode> getChildren()
	{
		return this.children;
	}
	public String getValue()
	{
		return this.value;
	}
	public void insertString(String input)
	{
		char first=input.charAt(0);
		if(this.children.get(first)==null)
		{
			if(this.value!=null)
			{
				int index=0;	
				while(input.charAt(index)==value.charAt(index))
					{
						index++;
					}
					String newValue=value.substring(0,index+1);
					String firstChild=value.substring(index+1);
					String nextChild=input.substring(index);
					this.value=newValue;
					if(this.children.get(firstChild.charAt(0))==null)
					{
						this.children.put(firstChild.charAt(0), new SuffixTreeNode(firstChild));
					}
					else
					{
						this.children.get(firstChild.charAt(0)).insertString(firstChild.substring(1));
					}
					if(this.children.get(nextChild.charAt(0))==null)
					{
						this.children.put(nextChild.charAt(0), new SuffixTreeNode(nextChild));
					}
					else
					{
						this.children.get(nextChild.charAt(0)).insertString(nextChild.substring(1));
					}
				
			}
			this.children.put(first, new SuffixTreeNode(input));
		}
		else
		{
			this.children.get(first).insertString(input.substring(1));
		}
	}
}
