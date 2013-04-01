package ProblemSet1;

import java.util.Iterator;
import java.util.List;

public class PositionIterImp implements PositionIter 
{
	private List<Position> listToIterate;
	private Iterator listIterator;
	/**
	 * Constructor
	 * @param listToIterate: input 
	 */
	public PositionIterImp(List<Position> listToIterate)
	{
		this.listToIterate=listToIterate;
		listIterator=this.listToIterate.iterator();
	}
	/**
	 * returns the next position.
	 * Returns null if none exist
	 */
	@Override
	public Position getNextPosition() 
	{
		if(listIterator.hasNext())
		{
			return (Position) listIterator.next();
		}
		return null;
	}
}
