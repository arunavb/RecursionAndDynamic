package bTree;
import java.util.*;
public class Person 
{
	private int ssn;
	private String name;
	public Person(int SSN,String Name)
	{
		this.ssn=SSN;
		this.name=Name;
	}
	public int getSSN()
	{
		return this.ssn;
	}
	public String getName()
	{
		return this.name;
	}
	public String toString()
	{
		return "SSN : "+this.ssn+" Name : "+this.name;
	}
}
