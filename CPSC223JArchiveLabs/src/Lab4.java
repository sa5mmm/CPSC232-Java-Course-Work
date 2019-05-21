/* Samantha M
 * Goes with notes20180913
 * CPSC 223J
 * Lab 4
 * */
public class Lab4 {
	public static void main(String[] args)
	{
		Car lola = new Car();
		lola.setname("Lola");
		//lola.setSpeed(0);
		
		display(lola);
		
		lola.acclerate(50);
		lola.travel(1.5);
		
		display(lola);		
		lola.decelerate(15);
		lola.travel(1);
		
		display(lola);	
		display(lola.getSpeed(),lola.getDistance());
	}
	public static void display(Car carPar)
	{
		System.out.println(carPar.getName() + " has a current speed of "
				+ carPar.getSpeed() + "mph and has gone a distance of " + carPar.getDistance() + " miles.");
	}
	public static void display(int speed, int distance)
	{
		System.out.println("Lola has a current speed of "
				+ speed + "mph and has gone a distance of " + distance + " miles.");
	}
}
