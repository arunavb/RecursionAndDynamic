package bTree;
import java.util.*;
public class nAryTreeNode 
{
	private char value;
	Map<Character,nAryTreeNode> children;
	List<nAryTreeNode> childrenList;
	public nAryTreeNode(char value)
	{
		this.value=value;
		children=new HashMap<Character,nAryTreeNode>();
		childrenList=new ArrayList<nAryTreeNode>();
	}
	public char getValue()
	{
		return this.value;
	}
	public Map<Character,nAryTreeNode> getChildren()
	{
		return children;
	}
	public List<nAryTreeNode> getChildrenList()
	{
		return childrenList;
	}
}
