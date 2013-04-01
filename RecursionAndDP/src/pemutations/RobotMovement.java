package pemutations;

public class RobotMovement 
{
	private int endX;
	private int endY;
	public RobotMovement(int destX,int destY)
	{
		this.endX=destX;
		this.endY=destY;
	}
	public int CalculatePath(int startX,int startY)
	{
		return returnCount(startX,startY);
	}
	private int returnCount(int posX,int posY)
	{
		if((posX>this.endX)||(posY>this.endY))
		{
			return 0;
		}
		if((posX==this.endX)&&(posY==(this.endY-1)))
		{
			return 1;
		}
		if((posX==this.endX-1)&&(posY==this.endY))
		{
			return 1;
		}
		return (returnCount(posX+1,posY)+returnCount(posX,posY+1));
	}
	public static void main(String args[])
	{
		RobotMovement rm=new RobotMovement(2,2);
		System.out.println(rm.CalculatePath(0, 0));
	}
}
