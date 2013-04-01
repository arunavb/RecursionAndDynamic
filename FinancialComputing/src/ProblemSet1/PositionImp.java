package ProblemSet1;

public class PositionImp implements Position
{
	private String name;
	private int quantity;
	/**
	 * Constructor
	 * @param name: Name of the instrument
	 * @param quantity: Quantity of Shares
	 */
	public PositionImp(String name,int quantity)
	{
		if(name==null)
		{
			throw new IllegalArgumentException("Name cannot be null");
		}
		this.name=name;
		this.quantity=quantity;
	}
	/**
	 * Returns the quantity of the position shares
	 */
	@Override
	public int getQuantity() 
	{
		// TODO Auto-generated method stub
		return this.quantity;
	}
	/**
	 * Returns the string denoting the instrument held
	 */
	@Override
	public String getSymbol() 
	{
		// TODO Auto-generated method stub
		return this.name;
	}
	/**
	 * Override the equals method
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		PositionImp other = (PositionImp) obj;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}
	@Override
	/**
	 * Overriding the toString method
	 */
	public String toString()
	{
		return "Name: "+this.name+" Quantity: "+this.quantity;
	}	
}
