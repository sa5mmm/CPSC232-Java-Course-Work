import java.util.Scanner;
/* Samantha M
 * Virtual Pet
 * Lab 5 */
public class Lab5 {
	public static void main(String[] args)
	{
		Scanner input = new Scanner(System.in);
		System.out.println("Please enter a name for your pet\nOrangutan: ");
		String namePar = input.nextLine();
		System.out.println("-Initializing Stats-");
		Pet pet1 = new Pet(namePar);
		print(pet1);
		int userChoice = 0;
		while(userChoice != 5 && pet1.getAge()<10&&Attribute_Tool.alive(pet1))
		{
		print();
		userChoice = input.nextInt();
		switch(userChoice)
		{
		case 1:
			pet1.feed();
			break;
		case 2:
			pet1.wash();
			break;
		case 3:
			pet1.play();
			break;
		case 4:
			pet1.health();
			break;
		case 5:
			//Do nothing loop will close!
			break;
		default:
			break;
		}
		Attribute_Tool.checkCleanliness(pet1);
		Attribute_Tool.checkHappiness(pet1);
		Attribute_Tool.checkHealth(pet1);
		Attribute_Tool.checkHunger(pet1);
		print(pet1);
		}
		
		if(!Attribute_Tool.alive(pet1))
		{
			System.out.println("\n\n"+pet1.getName() + 
					" was neglected and died!\nQuitting Program...");
		}else
		{
			System.out.println("\n\n"+pet1.getName() + 
					" died of old age!\nQuitting Program...");
		}
		input.close();
	}
	public static void print(Pet petPar)
	{
		System.out.println("-" + petPar.getName() + "'s Stats-");
		System.out.println("Hunger: " + petPar.getHunger());
		System.out.println("Cleanliness: " + petPar.getCleanliness());
		System.out.println("Happiness: " + petPar.getHappiness());
		System.out.println("Health: " + petPar.getHealth());
	}
	public static void print()
	{
		System.out.println("Main Menu: ");
		System.out.println("1. Feed\n2. Wash\n3. Play\n4. " +
		"Health\n5. -Quit-\nEnter a number (1-5)\n");
		
	}
}
