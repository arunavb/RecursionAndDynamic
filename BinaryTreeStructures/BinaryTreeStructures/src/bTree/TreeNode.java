package bTree;
public class TreeNode 
{
	private Person person;
	private TreeNode leftPerson;
	private TreeNode rightPerson;
	public TreeNode()
	{
		
	}
	public TreeNode(Person p)
	{
		person=new Person(p.getSSN(),p.getName());
		leftPerson=null;
		rightPerson=null;
	}
	public void setLeftChild(Person p)
	{
		leftPerson=new TreeNode(p);
	}
	public void setRightChild(Person p)
	{
		rightPerson=new TreeNode(p);
	}
	public TreeNode getLeftChild()
	{
		return this.leftPerson;
	}
	public TreeNode getRightChild()
	{
		return this.rightPerson;
	}
	public Person getNode()
	{
		return this.person;
	}
	private void setNode(Person p)
	{
		this.person=new Person(p.getSSN(),p.getName());
	}
}
