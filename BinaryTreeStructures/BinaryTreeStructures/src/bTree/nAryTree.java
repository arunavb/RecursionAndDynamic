package bTree;

public class nAryTree 
{
	nAryTreeNode root=null;
	public nAryTree()
	{
		
	}
	public void insert(char a)
	{
		root=new nAryTreeNode(a);
	}
	public void insert(String s)
	{
		if(s.isEmpty())
		{
			return;
		}
		if(root==null)
		{
			root=new nAryTreeNode(s.charAt(0));
			insert(s.substring(1));
		}
		else
		{
			nAryTreeNode temp=root;
			insertAt(temp,s);
		}
	}
	private void insertAt(nAryTreeNode temp, String s) 
	{
		if(s.isEmpty())
		{
			return;
		}
		char first=s.charAt(0);
		s=s.substring(1);
		if(temp.children.keySet().contains(first))
		{
			insertAt(temp.children.get(first),s);
		}
		else
		{
			temp.children.put(first, new nAryTreeNode(first));
			insertAt(temp.children.get(first),s);
		}
	}
	public void printInOrder()
	{
		nAryTreeNode temp=root;
		print(temp);
	}
	public void print(nAryTreeNode tempRoot)
	{
		
	}
	public static void main(String args[])
	{
		nAryTree trie=new nAryTree();
		trie.insert("arunav");
	}
}
