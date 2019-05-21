//For Lab 11
public class DiceGame {
	private Dice[] allDice;
	private int cash;
	private int numberOfDice;
	public DiceGame()
	{
		this(6,1000);
	}
	public DiceGame( int sizeOfDie, int startingCash)
	{
		this.cash = startingCash;
		allDice = new Dice[3];
		this.numberOfDice = 3;
		for (int i=0; i<numberOfDice; i++)
		{
			allDice[i] = new Dice(sizeOfDie);
		}
		
	}
	public void setCash(int change)
	{
		cash = cash + change;
	}
	public int getCash()
	{
		return cash;
	}
	public void rollDice()
	{
		for(int i =0; i<numberOfDice; i++)
		{
			allDice[i].roll();
		}
	}
	public int rollADie(int diePar)
	{
		allDice[diePar-1].roll();
		return allDice[diePar-1].getRoll();
	}
	public int getMulti()
	{
		int multi = -1;
		if(allDice[0].getRoll()==allDice[1].getRoll())
		{
			multi = 2;
			if(allDice[0].getRoll()==allDice[2].getRoll())
			{
				multi = 3;
			}
		}else if(allDice[0].getRoll()==allDice[2].getRoll())
		{
			multi = 2;
		}else if (allDice[1].getRoll()==allDice[2].getRoll())
		{
			multi = 2;
		}
		
		return multi;
	}
	public int getRoll(int diePar)
	{
		return allDice[diePar-1].getRoll();
	}
	private class Dice
	{
		private int sides;
		private int roll;
		Dice()
		{
		this(6);//Defaults dice to six sides	
		}
		Dice(int sides)
		{
			this.sides = sides;
		}
		public void roll()
		{
			roll = (int)(Math.random()*sides)+1;
		}
		public int getRoll()
		{
			return roll;
		}
	}

}
