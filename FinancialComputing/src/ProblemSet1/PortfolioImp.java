package ProblemSet1;

import java.util.ArrayList;
import java.util.List;
/**
 * 
 * @author Arunav
 * This class keeps a track of all the instruments in 
 * the system.
 */
public class PortfolioImp implements Portfolio
{
	List<Position> allInstruments;
	/**
	 * Default Constructor
	 */
	public PortfolioImp()
	{
		allInstruments=new ArrayList<Position>();
	}
	/**
	 * Adds the new trade functionality to the systems.
	 * If the symbol already exists, then, it adds to the existing
	 * function.
	 * Otherwise, it adds to the collection of Instruments
	 */
	@Override
	public void newTrade(String symbol, int quantity) 
	{
		PositionImp newPosition=new PositionImp(symbol,quantity);
		boolean added=false;
		List<Position> zeroPosition=new ArrayList<Position>();
		for(Position presentPosition:allInstruments)
		{
			if(presentPosition.equals(newPosition))
			{
				newPosition=new PositionImp(symbol,presentPosition.getQuantity()+quantity);
				zeroPosition.add(presentPosition);
				break;
			}
		}
		allInstruments.add(newPosition);
		for(Position position:allInstruments)
		{
			if(position.getQuantity()==0)
			{
				zeroPosition.add(position);
			}
		}
		for(Position removePosition:zeroPosition)
		{
			allInstruments.remove(removePosition);
		}
	}
	/**
	 * Returns an object of the type PositionIter that 
	 * allows easy iteration over the elements
	 */
	@Override
	public PositionIter getPositionIter() 
	{
		return new PositionIterImp(this.allInstruments);
	}
	/**
	 * 
	 * @param name: Asks for the instrument name to be searched for
	 * @return the Position object if the instrument exists
	 * or null otherwise
	 */
	public Position getPosition(String name)
	{
		for(Position p:allInstruments)
		{
			if(p.getSymbol().equals(name))
			{
				return p;
			}
		}
		return null;
	}
}
