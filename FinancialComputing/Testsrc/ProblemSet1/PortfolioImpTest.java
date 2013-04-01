package ProblemSet1;

import static org.junit.Assert.*;
import junit.framework.Assert;

import org.junit.Before;
import org.junit.Test;

public class PortfolioImpTest 
{
	PortfolioImp testFolio;
	@Before
	public void test() 
	{
		testFolio=new PortfolioImp();
	}
	@Test
	public void testOneNewTrade()
	{
		testFolio.newTrade("IBM", 100);
		Assert.assertEquals(1, testFolio.allInstruments.size());
	}
	@Test
	public void testTwoNewTrade()
	{
		testFolio.newTrade("IBM", 100);
		testFolio.newTrade("MSFT", -200);
		Assert.assertEquals(2, testFolio.allInstruments.size());
	}
	@Test
	public void testTwoNewTradeDuplicate()
	{
		testFolio.newTrade("IBM", 100);
		testFolio.newTrade("MSFT", -200);
		testFolio.newTrade("IBM", 300);
		Assert.assertEquals(2, testFolio.allInstruments.size());
		PositionImp quantity=(PositionImp) testFolio.getPosition("IBM");
		Assert.assertEquals(400, quantity.getQuantity());
	}
	@Test
	public void testRemoval()
	{
		testFolio.newTrade("IBM", 100);
		testFolio.newTrade("MSFT", -200);
		testFolio.newTrade("IBM", 300);
		testFolio.newTrade("IBM", -400);
		Assert.assertEquals(1, testFolio.allInstruments.size());
	}
	@Test
	public void testRemoval2()
	{
		testFolio.newTrade("IBM", -400);
		testFolio.newTrade("IBM", 100);
		testFolio.newTrade("MSFT", -200);
		testFolio.newTrade("IBM", 300);
		Assert.assertEquals(1, testFolio.allInstruments.size());
	}
	@Test(expected=IllegalArgumentException.class)
	public void testNullString()
	{
		testFolio.newTrade(null, -400);
	}
	@Test
	public void testGetMethod()
	{
		testFolio.newTrade("IBM", -400);
		testFolio.newTrade("IBM", 100);
		testFolio.newTrade("MSFT", -200);
		Assert.assertEquals("IBM", testFolio.getPosition("IBM").getSymbol());
	}
	@Test
	public void testGetMethodNull()
	{
		testFolio.newTrade("IBM", -400);
		testFolio.newTrade("IBM", 100);
		testFolio.newTrade("MSFT", -200);
		Assert.assertEquals(null, testFolio.getPosition("Apple"));
	}
	@Test
	public void testIterator()
	{
		testFolio.newTrade("IBM", -400);
		testFolio.newTrade("IBM", 100);
		testFolio.newTrade("MSFT", -200);
		Assert.assertNotNull(testFolio.getPositionIter());
	}
}
