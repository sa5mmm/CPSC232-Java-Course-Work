/*
 * Samantha Montoya
 * Goes with lab 5
 * */
public class Pet {
	private String name;
	private int hunger,cleanliness,happiness,health,age;
	//Constructor
	Pet(String name)
	{
		this.name = name;
		this.age = 0;
		this.hunger = (int)(Math.random()*10)+1;
		this.cleanliness = (int)(Math.random()*10)+1;
		this.happiness = (int)(Math.random()*10)+1;
		this.health = (int)(Math.random()*10)+1;
	}
	//Getters
	public int getHunger()
	{
		return this.hunger;
	}
	public int getAge()
	{
		return this.age;
	}
	public String getName()
	{
		return this.name;
	}
	public int getCleanliness()
	{
		return this.cleanliness;
	}
	public int getHappiness()
	{
		return this.happiness;
	}
	public int getHealth()
	{
		return this.health;
	}
	//Setters
	public void setHunger(int hunger)
	{
		if(hunger >= 0)
		{
			this.hunger = hunger;
		}
	}
	public void setAge(int age)
	{
		if(age >= 0)
		{
			this.age = age;
		}
	}
	public void setName(String name)
	{
		this.name = name;
	}
	public void setCleanliness(int cleanliness)
	{
		if(cleanliness >= 0)
		{
			this.cleanliness=cleanliness;
		}
	}
	public void setHappiness(int happiness)
	{
		if(happiness >= 0)
		{
			this.happiness = happiness;
		}
	}
	public void setHealth(int health)
	{
		if(health >= 0)
		{
			this.health = health;
		}
	}
	public void feed()
	{
		String messageArray[] = {this.name + " jumps with joy as you offer a banana.",
				this.name + " dances with joy and devours pasta."};
		int rand = (int)(Math.random()*messageArray.length);
		this.hunger++;
		this.age++;
		System.out.println(messageArray[rand]);
	}
	public void wash()
	{
		String messageArray[] = {this.name + " brushes his hair and"+
					"\nbecomes slightly upset do to excessive knots.",
				this.name + " puts up a fight to resist,\nhowever he gives "+
					"in and becomes squeaky clean."};

		int rand = (int)(Math.random()*2);
		this.cleanliness++;
		this.age++;
		System.out.println(messageArray[rand]);

	}
	public void play()
	{
		String messageArray[] = {"You pet " + this.name +".\n"+ this.name+  
				" pets you back then suddenly eats a spider from out of your hair. ",
				this.name + " climbs the nearest tree."};
		int rand = (int)(Math.random()*2);
		this.happiness++;
		this.age++;
		System.out.println(messageArray[rand]);
	}
	public void health()
	{
		String messageArray[] = {this.name + " goes for a bike ride.",
				this.name + " thrashes around the vet's office,\nbreaking a window"+
				" trying to escape from a shot."};
		int rand = (int)(Math.random()*2);
		this.health++;
		this.age++;
		System.out.println(messageArray[rand]);
	}
}
