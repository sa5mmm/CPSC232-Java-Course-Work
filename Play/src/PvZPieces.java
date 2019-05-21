
public class PvZPieces
{
	private int health;
	private int damage;
	private int xPos,yPos;
	private int cost;
	private int range;
	
	PvZPieces(int health, int damage, int xPos, int yPos, int cost,int range)
	{
		this.health = health;
		this.damage = damage;
		this.xPos = xPos;
		this.yPos = yPos;
		this.cost = cost;
		this.range = range;
	}
	public int getHealth()
	{
		return this.health;
	}
	public int getCost()
	{
		return this.cost;
	}
	public int getDamage()
	{
		return this.damage;
	}
	public int getX()
	{
		return this.xPos;
	}
	public int getY()
	{
		return this.yPos;
	}
	public void gotHit(int damage)
	{
		health = health - damage;
	}
	public boolean isActive()
	{
		return health>0;
	}
	public int getRange()
	{
		return this.range;
	}
}
