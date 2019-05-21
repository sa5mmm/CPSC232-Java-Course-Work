
public class Attribute_Tool {
	public enum Att {HEALTH,HAPPINESS,HUNGER,CLEANLINESS};
	public static void checkCleanliness(Pet pet)
	{
		int attribute = 3;
		String message[] = {"Oh no, " + pet.getName() + " is starting to smell bad!",
				pet.getName() + " has a dingleberry!"};
		int rand = (int)(Math.random()*message.length);
		if(pet.getCleanliness()<5)
		{
			System.out.print(message[rand]);
			change(pet,attribute);
		}
	}
	public static void checkHappiness(Pet pet)
	{
		int attribute = 1;
		String message[] = {"Oh no, " + pet.getName() + " is depressed!",
				pet.getName() + " needs attention."};
		int rand = (int)(Math.random()*message.length);
		if(pet.getHappiness()<5)
		{
			System.out.print(message[rand]);
			change(pet,attribute);
		}
	}
	public static void checkHealth(Pet pet)
	{
		int attribute = 0;
		String message[] = {"Oh no, " + pet.getName() + " broke his arm.",
				pet.getName() + " should go to the doctor."};
		int rand = (int)(Math.random()*message.length);
		if(pet.getHealth()<5)
		{
			System.out.print(message[rand]);
			change(pet,attribute);
		}
	}
	public static void checkHunger(Pet pet)
	{
		int attribute = 2;
		String message[] = {"Oh no, " + pet.getName() + " is starving!",
				pet.getName() + " needs to eat something."};
		int rand = (int)(Math.random()*message.length);
		if(pet.getHunger()<5)
		{
			System.out.print(message[rand]);
			change(pet,attribute);
		}
	}
	static void change(Pet pet,int curAtt)
	{
		int attribute = curAtt;
		while(attribute == curAtt)
		{
			attribute = (int)(Math.random()*4);
		}
		boolean decrease = (int)(Math.random()*4)>0;//3/4 chance to decrease
		String action = "+";
		int change = 1;
		if(decrease)
		{
			action = "";
			change = -1;
		}
		switch(attribute)
		{
		case 0:
			System.out.println("(Health " +action+change+")");
			pet.setHealth(pet.getHealth()+change);
			break;
		case 1:
			System.out.println("(Happiness " +action+change+")");
			pet.setHappiness(pet.getHappiness()+change);
			break;
		case 2:
			System.out.println("(Hunger " +action+change+")");
			pet.setHunger(pet.getHunger()+change);
			break;
		case 3:
			System.out.println("(Cleanliness "+action+change+")");
			pet.setCleanliness(pet.getCleanliness()+change);
			break;
		}
	}
	public static boolean alive(Pet pet)
	{
		boolean alive = true;
		if(pet.getCleanliness()==0)
		{
			alive = false;
		}else if(pet.getHappiness()==0)
		{
			alive = false;
		}else if(pet.getHealth()==0)
		{
			alive =false;
		}else if(pet.getHunger()==0)
		{
			alive = false;
		}
		return alive;
	}
}
