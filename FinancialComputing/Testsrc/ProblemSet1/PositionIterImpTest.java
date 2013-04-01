package ProblemSet1;

import org.junit.Before;
import org.junit.Test;

import junit.framework.Assert;

public class PositionIterImpTest 
{
	PortfolioImp testFolio;
	PositionIter iterator;
	@Before
	public void testStart()
	{
		testFolio=new PortfolioImp();
		testFolio.newTrade("IBM", -400);
		testFolio.newTrade("IBM", 100);
		testFolio.newTrade("MSFT", -200);
		iterator=testFolio.getPositionIter();
	}
	@Test
	public void getNext()
	{
		Assert.assertNotNull(iterator.getNextPosition());
	}
	@Test
	public void getNextNull()
	{
		iterator.getNextPosition();
		iterator.getNextPosition();
		iterator.getNextPosition();
		Assert.assertNull(iterator.getNextPosition());
	}
}
