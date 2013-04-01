package bTree;
/*
 * InsertPerson function is a binary insert that tries to keep the tree balanced. 
 */

public class BinaryTree 
{
	private TreeNode rootNode;
	public BinaryTree()
	{
	}
	/*
	 * Function: InsertPerson 
	 * a binary insert that tries to keep the tree balanced.
	 * 
	 * Helper Functions: 
	 * 1) insertPersonRecursive
	 * 2) findDepth
	 */
	public TreeNode getRoot()
	{
		return rootNode;
	}
	public void insertPerson(Person p)
	{
		if(rootNode==null)
		{
			rootNode=new TreeNode(p);
		}
		else
		{
			TreeNode tempNode=rootNode;
			insertPersonRecursive(tempNode,p);
		}
	}
	private void insertPersonRecursive(TreeNode root,Person p)
	{
		if(root.getLeftChild()==null)
		{
			root.setLeftChild(p);
			return;
		}
		else if(root.getRightChild()==null)
		{
			root.setRightChild(p);
			return;
		}
		else
		{
			int leftDepth=findDepth(rootNode.getLeftChild());
			int rightDepth=findDepth(rootNode.getRightChild());
			if(rightDepth<leftDepth)
			{
				insertPersonRecursive(rootNode.getRightChild(),p);
			}
			else
			{
				insertPersonRecursive(rootNode.getLeftChild(),p);
			}
		}
		
	}
	private int findDepth(TreeNode root)
	{
		if(root==null)
		{
			return 0;
		}
		else
		{
			int leftDepth=findDepth(root.getLeftChild());
			int rightDepth=findDepth(root.getRightChild());
			if(leftDepth>rightDepth)
			{
				return (1+leftDepth);
			}
			else
			{
				return (1+rightDepth);
			}
		}
	}
	public void printTree()
	{
		TreeNode tempNode=rootNode;
		printNode(tempNode);
	}
	private void printNode(TreeNode root)
	{
		if(root==null)
		{
			return;
		}
		printNode(root.getLeftChild());
		System.out.println(root.getNode());
		printNode(root.getRightChild());
	}
	/*
	 * Function: SpecificInsert
	 * gives the flexibility to insert at any position required.
	 * Parameters:
	 * 1) Parent: The parent of the insert function
	 * 2) Person: The person to be inserted
	 * 3) Direction: 'L' or 'R'
	 */
	public void specificInsert(int ssnParent,Person newNode,char direction)
	{
		direction=Character.toUpperCase(direction);
		TreeNode tempNode=rootNode;
		TreeNode parent=this.findSSN(ssnParent, tempNode);
		if(parent==null)
		{
			System.out.println("Sorry ! No such location exists ");
			return;
		}
		if(direction=='L')
		{
			if(parent.getLeftChild()!=null)
			{
				System.out.println("Sorry ! Person Already present at the specified location");
				return;
			}
			parent.setLeftChild(newNode);
		}
		else
		{
			if(parent.getRightChild()!=null)
			{
				System.out.println("Sorry ! Person Already present at the specified location");
				return;
			}
			parent.setRightChild(newNode);
		}
	}
	private TreeNode findSSN(int ssn,TreeNode root)
	{
		if(root==null)
		{
			return null;
		}
		else
		{
			if(root.getNode().getSSN()==ssn)
			{
				return root;
			}
			else
			{
				TreeNode temp=findSSN(ssn,root.getLeftChild());
				if(temp!=null)
				{
					return temp;
				}
				else
				{
					return findSSN(ssn,root.getRightChild());
				}
			}
		}
	}
}
