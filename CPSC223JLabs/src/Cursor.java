
public class Cursor {
	private int xMax,yMax;
	private int xPos,yPos;
	
	public Cursor(int xMax, int yMax)
	{
		this.xMax = xMax;
		this.yMax = yMax;
		xPos = 0;
		yPos = 0;
	}
	public void moveUp()
	{
		xPos--;
		if(xPos<0)
		{
			xPos = xMax-1;
		}
	}
	public void moveDown()
	{
		xPos = (xPos+1)%xMax;
	}
	public void moveLeft()
	{
		yPos--;
		if(yPos<0)
		{
			yPos = yMax-1;
		}
	}
	public void moveRight()
	{
		yPos = (yPos+1)%yMax;
	}
	public int getX()
	{
		return xPos;
	}
	public int getY()
	{
		return yPos;
	}

}
