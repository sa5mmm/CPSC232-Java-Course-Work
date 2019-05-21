/* Goes with lab 6
 * */
public class Player {
	private int id;
	private double avg;
	private static int count;
	private static double teamAvg;
	Player(int id, double avg)
	{
		this.id = id;
		this.avg = avg;
		count = count + 1;
		teamAvg = teamAvg + avg*1.0;
	}
	Player(int id)
	{
		this(id,.5);
	}
	Player(double avg)
	{
		this(999,avg);
	}
	
	public int getCount()
	{
		return count;
	}
	public int getID()
	{
		return this.id;
	}
	public double getAvg()
	{
		return this.avg;
	}
	public double getTeamAvg()
	{
		return teamAvg*1.0/count;
	}
}