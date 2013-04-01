package ProblemSet1;

import static org.junit.Assert.*;
import junit.framework.Assert;

import org.junit.Before;
import org.junit.Test;

public class PositionImpTest 
{
	Position position;
	@Before
	public void testStart() 
	{
		position=new PositionImp("IBM",500);
	}
	@Test(expected=IllegalArgumentException.class)
	public void tryNullInsertion()
	{
		position=new PositionImp(null,400);
	}
	@Test
	public void testToString()
	{
		Assert.assertNotNull(position.toString());
	}
}
