package ProblemSet1;
/**
 * 
 * @author Arunav
 *
 */
public interface Portfolio
{
	public void newTrade(String symbol, int quantity);
	public PositionIter getPositionIter();
}