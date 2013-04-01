package bTree;

public class SuffixTree 
{
	SuffixTreeNode root;
	public void createSuffixTree(String inputString)
	{
		root=new SuffixTreeNode(null);
		for(int i=0;i<inputString.length();i++)
		{
			root.insertString(inputString.substring(i));
		}
	}
	public void printTree()
	{
		SuffixTreeNode temp=root;
		print(root);
	}
	private void print(SuffixTreeNode temp) 
	{
		if(temp==null)
		{
			return;
		}
		System.out.println("Node :"+temp.getValue());
		System.out.print("Children: ");
		for(char c:temp.getChildren().keySet())
		{
			System.out.print(temp.getChildren().get(c).getValue()+"   ");
		}
		System.out.println();
		for(char c:temp.getChildren().keySet())
		{
			print(temp.getChildren().get(c));
		}
	}
	public static void main(String args[])
	{
		SuffixTree root=new SuffixTree();
		root.createSuffixTree("aabcd");
		root.print(root.root);
	}
	
	
}
