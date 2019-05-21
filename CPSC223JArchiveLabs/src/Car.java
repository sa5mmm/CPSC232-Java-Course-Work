/*
 * Goes with Lab4
 * 
 * */
public class Car {
	private int speed;
	private int distance;
	private String name;
	public Car()
	{
		this.speed = 0;
		this.distance = 0;
		this.name = "Car";
	}
	public Car(String namePar)
	{
		this.speed = 0;
		this.distance=0;
		this.name = namePar;
	}
	public Car(int speedPar, int distancePar, String namePar)
	{
		this.distance=distancePar;
		this.speed=speedPar;
		this.name=namePar;
	}
	public String getName()
	{
		return this.name;
	}
	public void setname(String name)
	{
		this.name = name;
	}
	public int getSpeed()
	{
		return this.speed;
	}
	public void setSpeed(int speed)
	{
		if(speed > 0)
		{
			this.speed = speed;
		}
	}
	public int getDistance()
	{
		return this.distance;
	}
	public void setDistance(int distance)
	{
		this.distance=distance;
	}
	
	public void acclerate()
	{
		this.speed++;
	}
	public void acclerate(int mph)
	{
		if(mph>0)
		{
			this.speed=this.speed+mph;
		}
	}
	public void decelerate()
	{
		if(this.speed>0)
		{
			this.speed--;
		}
	}
	public void decelerate(int mph)
	{
		if(mph>0)
		{
			if(this.speed>=mph)
			{
				this.speed = this.speed - mph;
			}else
			{
				this.speed = 0;
			}
		}
	}
	
	public int travel(double hours)
	{
		this.distance = this.distance + (int)(this.speed*hours);
		return this.distance;
	}
}
